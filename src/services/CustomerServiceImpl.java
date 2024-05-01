package services;

import DAO.DBConnect;
import entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    public static Customer customer;
    @Override
    public boolean authenticateCustomer(String customerName, String customerEmail) throws SQLException {
        boolean login = false;

        Connection con = DBConnect.connectDB();

        String loginSql = "SELECT customer_name, customer_email FROM customers WHERE customer_name = ? AND customer_email = ?";
        PreparedStatement statement = con.prepareStatement(loginSql);

        statement.setString(1, customerName);
        statement.setString(2, customerEmail);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            customer = new Customer(resultSet.getString("customer_name"),
                    resultSet.getString("customer_email"));
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

    }

    @Override
    public String searchAllCustomers(String customer_name, int customer_id) throws SQLException {
        return null;
    }
}
