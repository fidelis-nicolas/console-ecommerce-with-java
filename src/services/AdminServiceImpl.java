package services;

import DAO.DBConnect;
import entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    public static Admin admin;

    @Override
    public boolean validateAmin(String username, String password) throws SQLException {
        boolean login = false;
        Connection con = DBConnect.connectDB();

        PreparedStatement statement = con.prepareStatement("select username, password from admin WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            admin = new Admin(resultSet.getString("username"), resultSet.getString("password"));
//            System.out.println(admin.getPassword());
//            System.out.println(admin.getUsername());

            login= true;
        }
        return login;
    }
    // To be completed by Mal
    //Read up on service Facade
    @Override
    public String updateAdmin(String username, int id) throws SQLException {
//        boolean update = false;
        String message = "failed to update";

        // Establish a connection to the database
        Connection con = DBConnect.connectDB();
        //PreparedStatement statement = null;

        // SQL statement to update username
        String query = "UPDATE admin SET username = ? WHERE id = ?";

        // Prepared statement for executing the SQL query
        PreparedStatement statement = con.prepareStatement(query);

        try {
            // Set the parameters for the prepared statement
            statement.setString(1, username);
            statement.setInt(2, id);

            // Execute the update statement
            int rowsUpdated = statement.executeUpdate();

            // If rowsUpdated is greater than 0 , the update was successful
            if (rowsUpdated > 0) {
                message = "admin details successfully updated!!";

            }
        } catch (SQLException e) {
            // Handle any SQL exceptions that show up in the update process
            e.printStackTrace(); // Print the stack trace of the exception
        } finally {
            // Close the prepared statement and database connection to release resources
            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        }

        // Return statement to confirm if update was successful
        return  message;
    }

}
