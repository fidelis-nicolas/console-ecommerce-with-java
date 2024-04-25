package entities;

import java.util.Date;
import java.util.Objects;

public class Orders {
    private int orderID;
    private int productID;
    private int customerID;
    private Date orderDate;
    private String orderStatus;

    // Constructor
    public Orders(){

    }
    // Constructor without ID. ID will be generated by DB
    public Orders(int productID, int customerID, Date orderDate, String orderStatus) {
        this.productID = productID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }



    // Getters & Setters
    public void setOrderID(int orderID){
        this.orderID = orderID;
    }

    public int getOrderID(){
        return orderID;
    }

    public void setProductID(int productID){
        this.productID = productID;
    }

    public int getProductID(){
        return productID;
    }

    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    public int getCustomerID(){
        return customerID;
    }

    public void setOrderDate(Date orderDate){
        this.orderDate = orderDate;
    }

    public Date getOrderDate(){
        return orderDate;
    }

    // To string
    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", productID=" + productID +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderID == orders.orderID && productID == orders.productID && customerID == orders.customerID && Objects.equals(orderDate, orders.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, productID, customerID, orderDate);
    }
}
