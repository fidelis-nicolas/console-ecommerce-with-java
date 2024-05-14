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
    public String cancelOrders(int orderID, String orderStatus) throws SQLException {
        String message = "success";
        Connection con = DBConnect.connectDB();

        String cancelSql = "UPDATE orders SET order_status = ? WHERE order_id = ?";

        PreparedStatement statement = con.prepareStatement(cancelSql);
        statement.setString(1, orderStatus);
        statement.setInt(2, orderID);

        int updatedStatus = statement.executeUpdate();
        // How do we account for when the order id doesnt exists ?
        if (updatedStatus == 0) {
            message = "No order found with ID: " + orderID;
        } else {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Order_ID", "Product_ID", "Customer_ID", "Order_Date", "Order_Status");

            //Fetch and display updated order
            String updatedSql = "SELECT * FROM orders WHERE order_id = ?";
            PreparedStatement updateStatement = con.prepareStatement(updatedSql);
            updateStatement.setInt(1, orderID);

            ResultSet resultSet = updateStatement.executeQuery();
            while (resultSet.next()){
                System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getInt("order_id"),
                        resultSet.getInt("product_id"), resultSet.getInt("customer_id"),
                        resultSet.getDate("order_date"), resultSet.getString("order_status"));
            }
        }

        return message;
    }

    @Override
    public java.sql.Date searchOrders(Date order_date) throws SQLException {

        Connection con = DBConnect.connectDB();

        String dateSql = "SELECT * FROM orders WHERE order_date = ?";

        PreparedStatement statement = con.prepareStatement(dateSql);

        statement.setDate(1, order_date);

        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Order_ID", "Product_ID", "Customer_ID", "Order_Date", "Order_Status");


        while (resultSet.next()) {
            java.sql.Date orderDate = resultSet.getDate("order_date");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getInt("order_id"),
                    resultSet.getInt("product_id"), resultSet.getInt("customer_id"), orderDate, resultSet.getString("order_status"));
            return orderDate;
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
