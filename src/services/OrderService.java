package services;

import entities.Orders;

import java.sql.Date;
import java.sql.SQLException;

public interface OrderService {
    void viewAllOrders() throws SQLException;

    String cancelOrders(int ordrID, String orderStatus) throws SQLException;

    java.sql.Date searchOrders(Date order_date) throws SQLException;

    void addOrders(Orders orders) throws SQLException;
}
