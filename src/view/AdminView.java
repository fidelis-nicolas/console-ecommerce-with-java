package view;

import entities.Products;
import services.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AdminView {

    AdminService service = new AdminServiceImpl();
    ProductService productService = new ProductServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    OrderService orderService  = new OrderServiceImpl();
    Scanner scanner = new Scanner(System.in);
    public void login(){
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        try {
            if (service.validateAmin(username, password)){
                adminMenu();
            }
            else {
                System.out.println("invalid Login details");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewProduct() throws SQLException {
        Scanner in = new Scanner(System.in);
        Scanner des = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String prodName = in.nextLine();
        System.out.print("Price: ");
        double prodPrice = in.nextDouble();

        System.out.print("Quantity: ");
        int prodQuantity = in.nextInt();

        System.out.print("Description: ");
        String prodDescription = des.nextLine();


        productService.addProduct(new Products(prodName, prodPrice, prodDescription, prodQuantity));
    }
    public void updateProduct() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String prodName = in.nextLine();
        System.out.print("Price: ");
        double prodPrice = in.nextDouble();
        System.out.print("Quantity: ");
        int prodQuantity = in.nextInt();
        System.out.print("Product ID: ");
        int prodId = in.nextInt();
        productService.updateProduct(prodName,prodPrice, prodQuantity, prodId);
    }

    public void updateOrderStatus() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the order ID you want to update: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the order status: ");
        String orderStats = scanner.nextLine();
        orderService.cancelOrders(orderID, orderStats);
    }

    private void adminMenu() throws SQLException {
        while (true) {
            System.out.println("1. Update password and username");
            System.out.println("2. View all product");
            System.out.println("3. View All orders");
            System.out.println("4. View All customers");
            System.out.println("5. Add product");
            System.out.println("6. update product");
            System.out.println("7. delete product");
            System.out.println("8. Cancel order convert to change order status");
            System.out.println("9. Search Customer");
            System.out.println("10. Search order");
            System.out.println("11. Search products");
            System.out.println("12. Logout");

            System.out.print("Enter option: ");
            int userOption = scanner.nextInt();
            switch (userOption){
                case 1:
                    System.out.print("Enter new Username: ");
                    String newUsername = scanner.next();
                    service.updateAdmin(newUsername, 1);

                    break;
                case 2:
                    productService.viewAllProduct();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    orderService.viewAllOrders();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    customerService.viewallCustomers();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    addNewProduct();
                    break;
                case 6:
                    updateProduct();
                    break;
                case 7:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    productService.deleteProduct(id); // here had to pass in name because i modified the method to accept name from customers POV
                    // Update I've created a new method to delete just by name for customers only
                    break;
                case 8:
                    scanner.nextLine();
                    updateOrderStatus();
                    break;
                case 9:
                    scanner.nextLine();
                    System.out.print("Enter the customer name to search: ");
                    String customerName = scanner.nextLine();
                    if(customerService.searchAllCustomers(customerName)){

                    }else {
                        System.out.println("customer not found");
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.println("Enter the date for the order you want to search for (YYYY-MM-DD): ");
                    String dateString = scanner.nextLine();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        java.sql.Date date = new java.sql.Date(dateFormat.parse(dateString).getTime());
                        java.sql.Date foundDate = orderService.searchOrders(date);
                        if (foundDate != null){

                        } else {
                            System.out.println("Order not found");
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in this format YYYY-MM-DD");
                    }
                    try {
                        // Rationale for thread : Give users a brief pause after displaying the result before viewing the list of options.
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:
                    scanner.nextLine();
                    System.out.println("Enter the name of the product you want to search: ");
                    String productSearch = scanner.nextLine();
                    if (productService.searchProduct(productSearch)){

                    } else {
                        System.out.println("Product is not available");
                    }
                    break;
                case 12:
                    scanner.nextLine();
                    System.out.println("Logout successful");
                    // Here, the user can enter username/password to logout, but seems unnecessary to me.
                default:
            }
        }
    }
}
