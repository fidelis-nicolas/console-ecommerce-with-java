package services;

import entities.Customer;

import java.sql.SQLException;

public interface CustomerService {

    boolean authenticateCustomer(String password, String customerEmail) throws SQLException;
    void viewallCustomers() throws SQLException;

    boolean searchAllCustomers(String customer_name) throws SQLException;

    String createAccount(Customer customer) throws SQLException;
    void viewCustomerProfile(int customerId) throws SQLException;
    String updateCustomerProfile(int customerId, String customerName, String customerPassword, String email, String address)throws SQLException;


}
