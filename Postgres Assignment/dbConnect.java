import javax.print.DocFlavor;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author imssbora
 */
public class dbConnect {





    public static void main(String[] args) {

        dbOperate dbo=new dbOperate();

        dbo.displayTable();
        int option;
        Scanner s=new Scanner(System.in);
        // Step 1 - Open connection

        do {

            System.out.println("What operation do you want to perform" +
                    "\n1.INSERT" +
                    "\n2.DELETE" +
                    "\n3.UPDATE" +
                    "\n4.EXIT");

            option = Integer.parseInt(s.nextLine());

            switch (option) {

                case 1:
                    System.out.println("Please enter a name:");
                    String name = s.nextLine();
                    System.out.println("Please enter a address:");
                    String adress = s.nextLine();
                    dbo.insertTable(name, adress);

                    dbo.displayTable();
                    break;

                case 2:
                    dbo.displayTable();

                    System.out.println("Please enter ID to delete");
                    int id = Integer.parseInt(s.nextLine());
                    dbo.deleteTable(id);

                    dbo.displayTable();
                    break;

                case 3:
                    dbo.displayTable();

                    System.out.println("Please enter ID to update");
                    id = Integer.parseInt(s.nextLine());
                    System.out.println("Please enter a name:");
                    name = s.nextLine();
                    System.out.println("Please enter a address:");
                    adress = s.nextLine();

                    dbo.updateTable(id,name,adress);

                    dbo.displayTable();
                    break;


                default:
                    System.out.println("\n\nWrong option!!!! RETRY\n\n");
                    break;

            }
        } while (option !=4);
    }
}