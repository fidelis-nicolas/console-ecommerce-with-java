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
    public String updateProduct(String product_name, double productPrice, int productQuantity, int product_id) throws SQLException {

        String message = "error";

        Connection con = DBConnect.connectDB();

        String updateSql = "UPDATE products SET product_name = ?, price = ?, quantity = ? WHERE product_id = ?";
        PreparedStatement statement = con.prepareStatement(updateSql);

        statement.setString(1, product_name);
        statement.setDouble(2, productPrice);
        statement.setInt(3, productQuantity);
        statement.setInt(4, product_id);

        int productUpdated = statement.executeUpdate();

        if (productUpdated > 0) {
            message = "product successfully updated";
        }


        return message;
    }

    @Override
    public String deleteProduct(int product_id) throws SQLException {

        String confirmationMessage = "error";

        Connection con = DBConnect.connectDB();

        String deleteSql = "DELETE FROM products WHERE product_id = ?";
        PreparedStatement   statement = con.prepareStatement(deleteSql);

        statement.setInt(1, product_id);

        int productDeleted = statement.executeUpdate();

        if (productDeleted > 0) {
            confirmationMessage = "product is now deleted";
        }

        return confirmationMessage;
    }

    @Override
    public boolean searchProduct(String product_name) throws SQLException {
        boolean confirmationMessage = false;

        Connection con = DBConnect.connectDB();

        String searchSql = "SELECT * FROM products WHERE product_name LIKE '?%'";
        PreparedStatement statement = con.prepareStatement(searchSql);

        statement.setString(1, product_name);
        //statement.setInt(2, product_id);

        ResultSet resultSet = statement.executeQuery();


            //StringBuilder builder = new StringBuilder();
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Product_ID", "Product Name", "Price", "Discription", "Qantity");

            while (resultSet.next()) {
                System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getString("product_id"),
                        resultSet.getString("product_name"), resultSet.getString("price"),
                        resultSet.getString("description"), resultSet.getString("quantity"));
                confirmationMessage = true;
            }
            //confirmationMessage = true;
            System.out.println();


            return confirmationMessage;

    }
}
