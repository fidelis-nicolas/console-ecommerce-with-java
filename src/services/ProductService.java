package services;

import entities.Products;

import java.sql.SQLException;

public interface ProductService {

    void addProduct(Products products) throws SQLException;

    void viewAllProduct()throws SQLException;

    String updateProduct(String product_name, double productPrice, int productQuantity, int product_id) throws SQLException;

    String deleteProduct(int productID) throws SQLException;

    String deleteProductbyName(String productName) throws SQLException;

    boolean searchProduct(String product_name) throws SQLException;

}
