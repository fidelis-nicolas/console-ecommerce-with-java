import DAO.DBConnect;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBConnect.connectDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
