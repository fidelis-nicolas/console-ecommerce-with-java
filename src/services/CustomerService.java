package services;

import java.sql.SQLException;

public interface CustomerService {

    boolean authenticateCustomer(String customerName, String customerEmail) throws SQLException;
    void viewallCustomers() throws SQLException;

    String searchAllCustomers(String customer_name, int customer_id) throws SQLException;


}
