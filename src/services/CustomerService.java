package services;

import entities.Customer;

import java.sql.SQLException;

public interface CustomerService {

    boolean authenticateCustomer(String customerEmail, String password) throws SQLException;
    void viewallCustomers() throws SQLException;

    boolean searchAllCustomers(String customer_name, int customer_id) throws SQLException;

    String createAccount(Customer customer) throws SQLException;

}
