package services;

import DAO.DBConnect;
import entities.Orders;

import java.sql.*;

public class OrderServiceImpl implements OrderService {

    public static Orders orders;
    @Override
    public void viewAllOrders() throws SQLException {
        Connection con = DBConnect.connectDB();

        String ordersSql = "SELECT * FROM orders";
        PreparedStatement statement = con.prepareStatement(ordersSql);

        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Order_ID", "Product_ID", "Customer_ID", "Order_Date", "Order_Status");

        while (resultSet.next()) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("Order_id"),
                    resultSet.getString("Product_id"), resultSet.getString("Customer_id"),
                    resultSet.getString("Order_date"), resultSet.getString("Order_status"));
        }

    }

    @Override
    public int cancelOrders(int order_id) throws SQLException {
        return 0;
    }

    @Override
    public Date searchOrders(Date order_date) throws SQLException {

        Connection con = DBConnect.connectDB();

        String dateSql = "SELECT * FROM orders WHERE order_date = ?";

        PreparedStatement statement = con.prepareStatement(dateSql);

        statement.setDate(1, order_date);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Date orderDate = resultSet.getDate("order_date");
        }
        return null;
    }

    @Override
    public void addOrders(Orders orders) throws SQLException {
        Connection con = DBConnect.connectDB();

        // get all the attributes from order table
        //int orderID = orders.getOrderID();
        int productID = orders.getProductID();
        int customerID = orders.getCustomerID();
        Date orderDate = (Date) orders.getOrderDate();
        String orderStatus = orders.getOrderStatus();

        // SQL query
        String addSql = "INSERT INTO orders VALUES(null, null, null, ?, ?)";

        PreparedStatement statement = con.prepareStatement(addSql);

        // set the order????
        //statement.setInt(1, orderID);
        //statement.setInt(1, productID);
        //statement.setInt(2, customerID);
        statement.setDate(1, orderDate);
        statement.setString(2, orderStatus);

        int rowAdded = statement.executeUpdate();
        if (rowAdded > 0) {
            System.out.println("Order added successfully");
        } else {
            System.out.println("Error!!!");
        }

    }
}
