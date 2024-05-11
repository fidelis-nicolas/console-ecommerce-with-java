package services;

import entities.Products;

import java.sql.SQLException;

public interface CartService {

    void viewCart(int customerId) throws SQLException;
    String updateCart(int customerId, int productId, Products products) throws SQLException;

    String AddToCart(int productId, int customerId) throws SQLException;
}
