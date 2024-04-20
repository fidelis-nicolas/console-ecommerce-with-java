package entities;

public class Cart {
    private int cartId;
    private int customerId;
    private int productId;
    private Customer customer;
    private Products products;

    public Cart(int customerId, int productId) {
        this.customerId = customerId;
        this.productId = productId;

    }

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
