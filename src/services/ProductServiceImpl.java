package services;

import DAO.DBConnect;
import entities.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductServiceImpl implements ProductService{
    @Override
    public void addProduct(Products products) throws SQLException {
        Connection con = DBConnect.connectDB();

        String productName = products.getName();
        double productPrice = products.getPrice();
        String productDesc = products.getDescription();
        int productQantity = products.getQuantity();

        String sql = "INSERT INTO products VALUES(null,?,?,?,?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,productName);
        statement.setDouble(2, productPrice);
        statement.setString(3, productDesc);
        statement.setInt(4, productQantity);

        int row = statement.executeUpdate();
        if (row > 0){
            System.out.println("Product added successfully");
        }else {
            System.out.println("Error!!!");
        }

    }

    @Override
    public void viewAllProduct() throws SQLException {
        Connection con = DBConnect.connectDB();
        String sql = "SELECT * FROM products";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        //StringBuilder builder = new StringBuilder();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Product_ID", "Product Name", "Price", "Discription", "Qantity");

        while (resultSet.next()){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("product_id"),
                    resultSet.getString("product_name"), resultSet.getString("price"),
                    resultSet.getString("description"), resultSet.getString("quantity"));
        }
    }

    @Override
    public String updateProduct(int id) throws SQLException {
        return null;
    }

    @Override
    public String deleteProduct(int id) throws SQLException {
        return null;
    }
}
