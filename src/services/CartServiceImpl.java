package services;

import DAO.DBConnect;
import entities.Cart;
import entities.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartServiceImpl implements CartService {


    @Override
    public void viewCart(int customerId) throws SQLException {
        Connection con = DBConnect.connectDB();

        String cartSql = "SELECT cart_id, products.product_name, price, products.description, products.product_id FROM cart\n" +
                "join products on cart.product_id = products.product_id \n" +
                "join customers on cart.customer_id = customers.customer_id\n" +
                "where customers.customer_id = ?";
        PreparedStatement statement = con.prepareStatement(cartSql);
        statement.setInt(1, customerId);
        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Cart_ID", "Product Name", "Price", "Description", "Product Id");

        while (resultSet.next()) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", resultSet.getInt("cart_id"),
                    resultSet.getString("product_name"), resultSet.getDouble("price"),
                    resultSet.getString("description"), resultSet.getInt("product_id")

            );
        }
    }

    @Override
    public String updateCart(int customerId, int productId, Products products) throws SQLException {
        return null;
    }

    @Override
    public String AddToCart(int productId, int customerId) throws SQLException {

        Connection con = DBConnect.connectDB();

        String addToCartSql = "INSERT INTO cart VALUES(null, ?, ?)";

        PreparedStatement statement = con.prepareStatement(addToCartSql);
        statement.setInt(1, customerId);
        statement.setInt(2, productId);
        if(statement.execute()){
            return "Cart added successfully";
        }
        return "Failed to add to cart!!!";
    }
}
