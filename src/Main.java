import admin_service.AdminService;
import admin_service.AdminServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
       AdminService adminAuth = new AdminServiceImpl();
       AdminServiceImpl adminService = new AdminServiceImpl();
        try {
            if(
                adminAuth.validateAmin("admin", "12345")){
                System.out.println(adminService.admin.getUsername());
                System.out.println(adminService.admin.getPassword());
            }else {
                System.out.println("Invalid login details");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
