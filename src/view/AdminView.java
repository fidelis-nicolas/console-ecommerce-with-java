package view;

import entities.Products;
import services.*;

import java.sql.SQLException;
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
                    productService.deleteProduct(id);
                    break;
                case 8:
                    break;
                case 9:
                    scanner.nextLine();
                    System.out.print("Enter the customer name to search: ");
                    String customer_name = scanner.nextLine();
                    if(customerService.searchAllCustomers(customer_name)){

                    }else {
                        System.out.println("customer not found");
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                    //boolean searchResult = customerService.searchAllCustomers(customer_name);
//                    if (searchResult) {
//                        System.out.println("Customer found");
//                    } else {
//                        System.out.println("Customer not found");
//                    }
            }
        }
    }
}
