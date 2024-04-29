import entities.Products;
import services.AdminService;
import services.AdminServiceImpl;
import services.ProductService;
import services.ProductServiceImpl;
import view.Utilities;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        AdminService adminService = new AdminServiceImpl();
        ProductService productService = new ProductServiceImpl();
        productService.viewAllProduct();
//        adminService.viewAllOrders();
       // System.out.println(adminService.updateAdmin("test", 1));

//        Products products = new Products("Milk", 34.99, "Delicious", 10);
//        productService.addProduct(products);
    }
}
