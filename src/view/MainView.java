package view;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {

    AdminView adminView = new AdminView();
    CustomerView customerView = new CustomerView();
    Scanner inputs = new Scanner(System.in);
    public void mainMenu(){
        while (true) {
            System.out.println("Enter 1 For Admin");
            System.out.println("Enter 2 for customer");
            System.out.print("Enter option: ");
            int userInput = inputs.nextInt();

            if (userInput == 1) {
                adminView.login();
            } else if (userInput ==2) {
                try {
                    customerView.customerLogin();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
