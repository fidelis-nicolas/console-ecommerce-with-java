package view;

import services.*;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerView {
    CustomerService customerService = new CustomerServiceImpl();
    ProductService productService = new ProductServiceImpl();
    CartService cartService = new CartServiceImpl();
    public void customerLogin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            if(customerService.authenticateCustomer(password, email)){
                try {
                    customerMenu();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Invalid login details");
            }
        }

    }
    public void mainOption() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for login");
        System.out.println("Enter 2 to create an account");
        System.out.print("Enter option: ");
        String userOption = scanner.nextLine();
                if(userOption.equals("1")){
                    customerLogin();
                } else if (userOption.equals("2")) {

                }else {
                    System.out.println("You have entered an invalid option");

                }
    }

    public void customerMenu() throws SQLException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true){

        System.out.println("1. View Profile");
        System.out.println("2. Update profile");
        System.out.println("3. View Products");
        System.out.println("4. Search product using name");
        System.out.println("5. Add product to cart");
        System.out.println("6. View cart");
        System.out.println("7. Delete product from cart");
        System.out.println("8. Order product and checkout");
        System.out.println("9. View Order History");
        System.out.println("10. Logout");

        System.out.print("Enter option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                productService.viewAllProduct();
                break;
            case 4:
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                if(productService.searchProduct(productName)){

                }else {
                    System.out.println("Product not found");
                }
                break;
            case 5:
                System.out.print("Enter the product ID: ");
                String productId = scanner.nextLine();
                int prodId = Integer.parseInt(productId);
                int customerId = CustomerServiceImpl.customerId;
                cartService.AddToCart(prodId, customerId);
                break;
            case 6:
                cartService.viewCart(CustomerServiceImpl.customerId);
                Thread.sleep(10000);
                break;
            case 7:
                // This should be from cart service but then our cart only has order id and the rest, not designed from a customer POV
                scanner.nextLine();
                System.out.print("Enter the name of the product you want to remove from cart: ");
                String name = scanner.nextLine();
                productService.deleteProductbyName(name);
                System.out.println("Product has been removed from your cart");
                break;
            default:
                System.out.println("Invalid option selected");

             }
        }


    }
}
