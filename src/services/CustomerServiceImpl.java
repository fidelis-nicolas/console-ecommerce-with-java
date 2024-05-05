package services;

import DAO.DBConnect;
import entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    public static Customer customer;

    public static int customerId;
    @Override
    public boolean authenticateCustomer(String customerEmail, String password) throws SQLException {
        boolean login = false;

        Connection con = DBConnect.connectDB();

        String loginSql = "SELECT  customer_email, password, customer_id FROM customers WHERE password = ? AND customer_email = ?";
        PreparedStatement statement = con.prepareStatement(loginSql);

        statement.setString(1, password);
        statement.setString(2, customerEmail);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            customerId = resultSet.getInt("customer_id");
//            customer = new Customer(resultSet.getString("customer_name"),
//                    resultSet.getString("customer_email"));
            //System.out.println(customer.getCustomerName());
            //System.out.println(customer.getCustomerEmail());

            login = true;
        }

        if(login = true){
            System.out.println("Login successful");
        } else {
            System.out.println("Authentication failed");
        }


        return login;
    }

    @Override
    public void viewallCustomers() throws SQLException {
        Connection con = DBConnect.connectDB();

        String customerSql = "SELECT * FROM customers";
        PreparedStatement statement = con.prepareStatement(customerSql);
        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Customer_ID", "Customer Name", "Customer Email", "Customer Address", "Password");

        while (resultSet.next()){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("customer_id"),
                    resultSet.getString("customer_name"), resultSet.getString("customer_email"),
                    resultSet.getString("customer_address"), resultSet.getString("password"));
        }
    }

    @Override
    public boolean searchAllCustomers(String customer_name, int customer_id) throws SQLException {
        boolean confirmSearch = false;

        Connection con = DBConnect.connectDB();
        String searchCustomerSql = "SELECT * FROM customers WHERE customer_name = ?";
        PreparedStatement statement = con.prepareStatement(searchCustomerSql);

        statement.setString(1, customer_name);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            String customerName = resultSet.getString("customer_name");
            System.out.println("Customer Name: " + customer_name);
            confirmSearch = true;
        }
        return confirmSearch;
    }

    @Override
    public String createAccount(Customer customer) throws SQLException {


        return null;
    }


}
