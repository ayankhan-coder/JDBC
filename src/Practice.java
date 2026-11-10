import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Practice {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "DataBase Password";

        String query = "select * from employees;";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully");

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){

                int id = result.getInt("id");
                String name = result.getString("name");
                String jobtitle = result.getString("jobtitle");
                double salary = result.getDouble("salary");
                System.out.println("====================");
                System.out.println("Id : "+id);
                System.out.println("Name : "+ name);
                System.out.println("JobTitle : "+jobtitle);
                System.out.println("Salary : "+salary);
            }

            result.close();
            stmt.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        }catch (SQLException e){
            System.out.println(e);
        }


    }
}
