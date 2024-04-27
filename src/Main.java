import services.AdminService;
import services.AdminServiceImpl;
import view.Utilities;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        AdminService adminService = new AdminServiceImpl();
        adminService.viewAllProduct();
        adminService.viewAllOrders();
    }
}
