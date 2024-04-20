package entities;

import java.util.Objects;

public class Products {
    private int productID;
    private String name;
    private double price;
    private String description;
    private int quantity;

    // Constructors
    public Products(){

    }

    public Products(String name, double price, String description, int quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productID == products.productID && Double.compare(price, products.price) == 0 && quantity == products.quantity && Objects.equals(name, products.name) && Objects.equals(description, products.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, price, description, quantity);
    }
}
