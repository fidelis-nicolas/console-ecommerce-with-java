package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection connectDB() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mal_ecommerce", "root", "Fidelis@123");
        System.out.println("Connection successful");
        return con;
    }
}
