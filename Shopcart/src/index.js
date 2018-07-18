var item = new Array("Watch", "Bag", "Shirt", "Pant", "Shoe");
var length = item.length;
var prices = [100, 250, 300, 350, 200];
var quant = [0, 0, 0, 0, 0];
function product(itemName, price, quantity) {
  this.itemName = itemName;
  this.price = price;
  this.quantity = quantity;
}
var productList = []; //object
var totalPrice = 0;
var totalQuantity = 0;
//adding the elements to class
for (i = 0; i < length; i++) {
  productList.push(new product(item[i], prices[i], quant[i]));
}
//table creation
var app = document.getElementById("app");
var tab = document.getElementById("table1");
var y = tab.createTHead();
y.setAttribute("id", "thh");
var row = y.insertRow(0);
var cell = row.insertCell(0);
cell.innerHTML = "NAME";
var cell = row.insertCell(1);
cell.innerHTML = "PRICE";
var cell = row.insertCell(2);
cell.innerHTML = "ADD";
var cell = row.insertCell(3);
cell.innerHTML = "REMOVE";
var cell = row.insertCell(4);
cell.innerHTML = "QUANTITY";
tab.appendChild(y);
app.appendChild(tab);
//table data
for (var i = 0; i < length; i++) {
  var tr = document.createElement("tr");
  var td = document.createElement("td");
  td.setAttribute("id", "tdd");
  var node = document.createTextNode(item[i]);
  td.appendChild(node);
  tr.appendChild(td);
  var td = document.createElement("td");
  td.setAttribute("id", "tdd");
  var node = document.createTextNode(prices[i]);
  td.appendChild(node);
  tr.appendChild(td);
  var td = document.createElement("td");
  var $bid = document.createElement("button");
  $bid.setAttribute("id", i);
  $bid.setAttribute("class", "button2");
  var node = document.createTextNode("+");
  $bid.onclick = function () {
    totalQuantity++;
    totalPrice += productList[this.id].price;
    console.log(totalPrice);
    productList[this.id].quantity += 1;
    var c = this.id;
    document.getElementById("piid").innerHTML = `<h3>TOTAL = ${totalQuantity}</h3>`;
    console.log(this.id);
    document.getElementById("tdd" + c).innerHTML =
      productList[this.id].quantity;
  };
  $bid.appendChild(node);
  td.appendChild($bid);
  tr.appendChild(td);
  var td = document.createElement("td");
  var buttonRem = document.createElement("button");
  buttonRem.setAttribute("id", i);
  buttonRem.setAttribute("class", "button3");
  var node = document.createTextNode("-");
  buttonRem.onclick = function () {
    if (productList[this.id].quantity != 0) {
      totalQuantity--;
      totalPrice -= productList[this.id].price;
      console.log(totalPrice);
      productList[this.id].quantity -= 1;
      var c = this.id;
      document.getElementById("piid").innerHTML = `<h3>TOTAL = ${totalQuantity}</h3>`;
      document.getElementById("tdd" + c).innerHTML =
        productList[this.id].quantity;
    }
  };
  buttonRem.appendChild(node);
  td.appendChild(buttonRem);
  tr.appendChild(td);
  var td = document.createElement("td");
  td.setAttribute("id", "tdd" + i);
  td.setAttribute("class", "para");
  var node = document.createTextNode(quant[i]);
  td.appendChild(node);
  tr.appendChild(td);
  tab.appendChild(tr);
}
button1.onclick = function () {
  document.getElementById("app").innerHTML = ``;
  document.getElementById("piid").innerHTML = ``;
  document.write('<body bgcolor="lightpink">');
  document.write(
    '<h1 id="cartHead" style="color:red;margin-top:50px;font-size:50px;" ><div align="center">MY CART</div></h2></br></br>'
  );
  if (totalQuantity != 0) {
    document.write(
      '<table style="border-spacing: 50px 20px;margin-left:260px;"><tr><th style="color:green";><h2>ITEM</h2></th><th      style="color:green"><h2>QUANTITY</h2></th><th style="color:green"><h2>PRICE/ITEM</h2></th><th style="color:green"><h2>PRICE</h2></th></tr>'
    );
    for (i = 0; i < length; i++) {
      if (productList[i].quantity != 0) {
        document.write("<tr><td>" + productList[i].itemName + "</td>");
        document.write("<td>" + productList[i].quantity + "</td>");
        document.write("<td>" + productList[i].price + "</td>");
        var t = productList[i].price * productList[i].quantity;
        document.write("<td>" + t + "</td></tr>");
      }
    }
    document.write("<table></table>");
    document.write("<br/>");
    document.write("<br/>");
    document.write(
      '<p><div style="color:blue;margin-left:680px;font-size:30px;margin-top:60px">Total  :  ' +
      totalPrice + "/-" +
      " </div></p>"
    );
  } else
    document.write(
      '<p><div align="center"style="color:blue;font-size:35px;margin-top:250px;">.......!! No Item !!.......</div></p>'
    );
};
