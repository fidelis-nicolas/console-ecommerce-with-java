package services;

import entities.Products;

import java.sql.SQLException;

public interface ProductService {
    void addProduct(Products products) throws SQLException;
    String updateProduct(int id) throws SQLException;
    String deleteProduct(int id) throws SQLException;
}
