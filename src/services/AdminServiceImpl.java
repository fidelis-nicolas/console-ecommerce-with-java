package services;

import DAO.DBConnect;
import entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    public static Admin admin;

    @Override
    public boolean validateAmin(String username, String password) throws SQLException {
        boolean login = false;
        Connection con = DBConnect.connectDB();

        PreparedStatement statement = con.prepareStatement("select username, password from admin WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            admin = new Admin(resultSet.getString("username"), resultSet.getString("password"));
//            System.out.println(admin.getPassword());
//            System.out.println(admin.getUsername());

            login= true;
        }
        return login;
    }
    // To be completed by Mal
    //Read up on service Facade
    @Override
    public String updateAdmin(String userName, String password) throws SQLException {
        return null;
    }

    @Override
    public void viewAllProduct() throws SQLException {
        Connection con = DBConnect.connectDB();
        String sql = "SELECT * FROM products";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        //StringBuilder builder = new StringBuilder();
        while (resultSet.next()){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Product_ID", "Product Name", "Price", "Discription", "Qantity");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("product_id"),
                    resultSet.getString("product_name"), resultSet.getString("price"),
                    resultSet.getString("description"), resultSet.getString("quantity"));
        }
    }

    @Override
    public void viewAllOrders() throws SQLException {
        Connection con = DBConnect.connectDB();
        String sql = "SELECT order_id, oder_date, order_status, customer_name, customer_email, cusotmer_address, product_name, price\n" +
                "FROM orders INNER JOIN customers ON orders.customer_id = customers.customer_id\n" +
                "INNER JOIN products ON orders.product_id = products.product_id;";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Order ID", "Order Date",
                    "Oder Status", "Customer name", "Customer email", "Customer Address", "Product name", "product price");

            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("order_id"),
                    resultSet.getString("oder_date"), resultSet.getString("order_status"),
                    resultSet.getString("customer_name"), resultSet.getString("cusotmer_address"),
                    resultSet.getString("product_name"), resultSet.getString("price")
                    );
        }
    }
}
