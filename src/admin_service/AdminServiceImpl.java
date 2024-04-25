package admin_service;

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

    @Override
    public String updateAdmin(String userName, String password) throws SQLException {
        return null;
    }
}
