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
    public void viewCart() throws SQLException {
        Connection con = DBConnect.connectDB();

        String cartSql = "SELECT * FROM customers";
        PreparedStatement statement = con.prepareStatement(cartSql);
        ResultSet resultSet = statement.executeQuery();

        System.out.printf("%-20s %-20s %-20s\n", "Cart_ID", "Customer_ID", "Product_ID");

        while (resultSet.next()) {
            System.out.printf("%-20s %-20s %-20s\n", resultSet.getInt("cart_id"),
                    resultSet.getInt("customer_id"), resultSet.getInt("product_id"));
        }
    }

    @Override
    public String updateCart(int customerId, int productId, Products products) throws SQLException {
        return null;
    }

    @Override
    public String AddToCart(int productId, Products products) throws SQLException {

        Connection con = DBConnect.connectDB();

        String addToCartSql = "INSERT INTO carts VALUES(null,null null)";

        return null;
    }
}
