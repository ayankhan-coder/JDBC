import java.sql.*;

public class Practice2 {
    public static void main(String[] args) throws Exception{

        /* DATA INSERTION */

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String password = "";
        String user = "root";
        String query = "update employees set salary = 10 where id = 101;";


        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection established");

            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println("Update Successful "+ rowsAffected +" row(s) affected");
            }else {
                System.out.println("Update Failed");
            }
            stmt.close();
            connection.close();
            System.out.println(rowsAffected);


        }catch (Exception e){
            System.out.println(e);
            System.out.println("Connection Failed");
        }





    }
}
