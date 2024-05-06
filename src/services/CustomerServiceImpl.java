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
    public boolean authenticateCustomer(String password, String customerEmail) throws SQLException {
        boolean login = false;

        Connection con = DBConnect.connectDB();

        String loginSql = "SELECT password, customer_email, customer_id FROM customers WHERE password = ? AND customer_email = ?";
        PreparedStatement statement = con.prepareStatement(loginSql);

        statement.setString(1, password);
        statement.setString(2, customerEmail);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            customerId = resultSet.getInt("customer_id");
            login = true;
        }

        if(login){
            System.out.println("Login successful");
        } else {
            System.out.println("Authentication failed");
        }


        return login;
    }

    @Override
    public void viewallCustomers() throws SQLException {

    }

    @Override
    public String searchAllCustomers(String customer_name, int customer_id) throws SQLException {
        return null;
    }

    @Override
    public String createAccount(Customer customer) throws SQLException {
        return null;
    }


}
