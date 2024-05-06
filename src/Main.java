import services.*;
import view.MainView;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Call all admin methods here
        //AdminService adminService = new AdminServiceImpl();
        //adminService.viewAllOrders();
       // System.out.println(adminService.updateAdmin("test", 1));

        //*******************************************************************************************************
        // Call all product methods here
        ProductService productService = new ProductServiceImpl();

        // View product
        //productService.viewAllProduct();

        // Add products
        /*Products products = new Products("Milk", 34.99, "Vegan made", 10);
        Products products2 = new Products("Book", 4.99, "Best NYTimes seller", 10);
        Products products3 = new Products("Table", 304.09, "Coffee Table", 10);
        Products products4 = new Products("Phone", 1099.62, "iphone12", 10);
        productService.addProduct(products);
        productService.addProduct(products2);
        productService.addProduct(products3);
        productService.addProduct(products4);*/


        // Update products
        //System.out.println(productService.updateProduct("Bag", 1));

        // Delete products
        //System.out.println(productService.deleteProduct(2));

        // Search products
        //System.out.println(productService.searchProduct("Phone"));

        //*******************************************************************************************************
        // Call all cart methods here

        //*******************************************************************************************************
        // Call all customers methods here
//        CustomerService customerService = new CustomerServiceImpl();
//        customerService.authenticateCustomer("1245", "fidelis@email.com");
//        System.out.println(CustomerServiceImpl.customerId);

        //*******************************************************************************************************
        // Call all orders methods here
        //OrderService orderService = new OrderServiceImpl();
        //View Orders
        //orderService.viewAllOrders();
        //Add Orders
        /*Date orderDate1 = Date.valueOf("2024-12-2");
        Date orderDate2 = Date.valueOf("2023-01-2");
        Orders orders1 = new Orders(orderDate1, "delivered");
        Orders orders2 = new Orders(orderDate2, "pending");
        orderService.addOrders(orders1);
        orderService.addOrders(orders2);*/

        MainView mainView = new MainView();
        mainView.mainMenu();
    }
}
