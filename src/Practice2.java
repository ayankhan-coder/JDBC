import java.sql.*;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "195319862019M";

        int enterId;
        String enterName;
        String enterJobTitle;
        double enterSalary;
        Connection con = null;
        Statement stmt;
        int option = 0;
        int id = 0;
        int rowsAffected = 0;

        try {
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");

        }catch (SQLException e){
            System.out.println("Connection Failed");
        }

        do {

            try {
                System.out.println("-------------------------------------");

                System.out.println("1:Add 2:FindById 3:Delete 4:viewAll");
                System.out.print("Enter Option : ");
                option = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Enter Valid Option Number!!");
                sc.nextLine();
                continue;

            }


            switch (option) {
                case 1:
                    try {

                        System.out.print("Enter Id : ");
                        enterId = sc.nextInt();
                        System.out.print("Enter Name : ");
                        sc.nextLine();
                        enterName = sc.nextLine();
                        System.out.print("Enter JobTitle : ");
                        enterJobTitle = sc.nextLine();
                        System.out.print("Enter Salary : ");
                        enterSalary = sc.nextDouble();

                        stmt = con.createStatement();
                        rowsAffected = stmt.executeUpdate("insert into employees (id,name,jobtitle,salary) values"+"("+enterId+",'"+enterName+"','"+enterJobTitle+"',"+enterSalary+");");
                        if (rowsAffected>0){
                            System.out.println("Data Entered Successfully");
                            break;
                        }else {
                            System.out.println("Data Entry Failed!!");
                        }

                    }catch (Exception e){
                        System.out.println("Invalid Information!!");
                        sc.nextLine();
                        continue;
                    }
                    break;


                case 2:
                    try {

                        System.out.println("Enter Id To Search : ");

                        id = sc.nextInt();
                    }catch (Exception e){
                        System.out.println("Invalid Search");
                        sc.nextLine();
                        continue;
                    }
                    stmt = con.createStatement();
                    ResultSet resultSet = stmt.executeQuery("select * from employees where id = " + id + ";");

                    while (resultSet.next()) {
                        int idd = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String jobtitle = resultSet.getString("jobtitle");
                        double salary = resultSet.getDouble("salary");
                        System.out.println("====================");
                        System.out.println("Id : " + idd);
                        System.out.println("Name : " + name);
                        System.out.println("JobTitle : " + jobtitle);
                        System.out.println("Salary : " + salary);
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Id To Delete : ");
                        enterId = sc.nextInt();
                        stmt = con.createStatement();
                        rowsAffected = stmt.executeUpdate("delete from employees where id = " + enterId + ";");
                        if (rowsAffected > 0) {
                            System.out.println("Employee Deleted");
                            break;
                        } else {
                            System.out.println("Deletion Failed");
                        }
                    }catch (Exception e){
                        System.out.println("Invalid Information!!");
                    }
                    break;

                case 4:
                    stmt = con.createStatement();
                    resultSet = stmt.executeQuery("select * from employees;");

                    while (resultSet.next()){

                        int idd = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String jobtitle = resultSet.getString("jobtitle");
                        double salary = resultSet.getDouble("salary");
                        System.out.println("====================");
                        System.out.println("Id : "+idd);
                        System.out.println("Name : "+ name);
                        System.out.println("JobTitle : "+jobtitle);
                        System.out.println("Salary : "+salary);
                    }
                    break;
                default:
                    System.out.println("Enter Correct Option!!");


            }
        }while (option != 100);








    }
}
