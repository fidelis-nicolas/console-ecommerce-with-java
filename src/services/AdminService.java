package services;

import java.sql.SQLException;

public interface AdminService {
     boolean validateAmin(String username, String password)throws SQLException;
     String updateAdmin(String username, int id) throws SQLException;
     //void viewAllProduct()throws SQLException;
     void viewAllOrders()throws SQLException;
     void viewAllCustomers()throws SQLException;
}
