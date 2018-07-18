import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dbOperate {

    String jdbcUrl = "jdbc:postgresql://localhost:5432/sample";

    String mainUser="tony";
    String mainPassword="tony";


    String readOnlyUser = "newrole";
    String readOnlyPassword = "Test1234";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    Scanner s = new Scanner(System.in);



    public void displayTable(){

        try {
            conn = DriverManager.getConnection(jdbcUrl, readOnlyUser, readOnlyPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from employee;");

            System.out.println("\n\nID\tName\tAddress");

            // Step 3 - Get result
            while (rs.next()) {
                for (int i = 1; i <= 3; i++)
                    System.out.print(rs.getString(i) + " \t");
                System.out.print("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    void insertTable(String name,String address){

        try {
            conn = DriverManager.getConnection(jdbcUrl, mainUser, mainPassword);
            stmt = conn.createStatement();
            stmt.executeUpdate("Insert into employee (name,address) values ('" + name + "','" + address + "');");
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    void deleteTable(int ID){

        try {
            conn = DriverManager.getConnection(jdbcUrl, mainUser, mainPassword);
            stmt = conn.createStatement();
            stmt.executeUpdate("delete from employee where id=" + ID + "");
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    void updateTable(int ID,String name,String address){

        try {
            conn = DriverManager.getConnection(jdbcUrl, mainUser, mainPassword);
            stmt = conn.createStatement();
            stmt.executeUpdate("update employee set name='"+name+"',address='"+address+"'3where id="+ID+";");
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
