package services;

import entities.Customer;

import java.sql.SQLException;

public interface CustomerService {

    boolean authenticateCustomer(String password, String customerEmail) throws SQLException;
    void viewallCustomers() throws SQLException;

    String searchAllCustomers(String customer_name, int customer_id) throws SQLException;

    String createAccount(Customer customer) throws SQLException;

}
