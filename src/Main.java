
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcpractice";
        String username = "root";
        String password = "195319862019M";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            System.out.println("Database connected successfully!");
            System.out.println(con);

            con.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}