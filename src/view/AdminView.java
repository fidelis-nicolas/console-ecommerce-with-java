package view;

import services.AdminService;
import services.AdminServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView {

    AdminService service = new AdminServiceImpl();
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
            }
        }
    }
}
