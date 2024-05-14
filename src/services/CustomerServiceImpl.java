package services;

import DAO.DBConnect;
import entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    //find a way make
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
//            customer = new Customer(resultSet.getString("customer_name"),
//                    resultSet.getString("customer_email"));
            //System.out.println(customer.getCustomerName());
            //System.out.println(customer.getCustomerEmail());

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
    public boolean searchAllCustomers(String customer_name) throws SQLException {
        boolean confirmSearch = false;

        Connection con = DBConnect.connectDB();
        String searchCustomerSql = "SELECT * FROM customers WHERE customer_name LIKE ?";
        PreparedStatement statement = con.prepareStatement(searchCustomerSql);

        statement.setString(1, customer_name + "%" );

        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Customer_ID", "Customer Name", "Customer Email", "Customer Address", "Password");

        while (resultSet.next()){
                System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("customer_id"),
                        resultSet.getString("customer_name"), resultSet.getString("customer_email"),
                        resultSet.getString("customer_address"), resultSet.getString("password"));
            confirmSearch = true;
        }
        return confirmSearch;
    }

    @Override
    public String createAccount(Customer customer) throws SQLException {
        String message = null;
        Connection con = DBConnect.connectDB();
        String name = customer.getCustomerName();
        String email = customer.getCustomerEmail();
        String password = customer.getPassword();
        String address = customer.getCustomerAddress();

        String sql = "INSERT INTO customer values(null,????)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setString(3, address);
        statement.setString(4, password);

        int createAccount = statement.executeUpdate();

        if (createAccount>0){
            message = "Account created successfully";
        }

        return  message;
    }

    @Override
    public void viewCustomerProfile(int customerId) throws SQLException {
        Connection con = DBConnect.connectDB();

        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, customerId);
        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Customer_ID", "Customer Name", "Customer Email", "Customer Address", "Password");

        while (resultSet.next()) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("customer_id"),
                    resultSet.getString("customer_name"), resultSet.getString("customer_email"),
                    resultSet.getString("customer_address"), resultSet.getString("password"));

        }
    }

    @Override
    public String updateCustomerProfile(int customerId, String customerName, String customerPassword, String email, String address) throws SQLException {
        String message = null;
        Connection con = DBConnect.connectDB();
        String sql = "UPDATE customers set customer_name = ?, customer_email = ?, customer_address = ?, password = ? WHERE customer_id = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, customerName);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, customerPassword);
        preparedStatement.setInt(5, customerId);

        int update = preparedStatement.executeUpdate();

        if(update>0){
            message = "Updated successfully!!";
        }

        return message;
    }


}
