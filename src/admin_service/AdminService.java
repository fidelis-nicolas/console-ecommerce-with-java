package admin_service;

import java.sql.SQLException;

public interface AdminService {
    public boolean validateAmin(String username, String password)throws SQLException;
    public String updateAdmin(String userName, String password) throws SQLException;
}
