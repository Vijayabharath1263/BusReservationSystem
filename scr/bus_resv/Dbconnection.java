package Bus_reservation;

import java.sql.*;

public class Dbconnection {

    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String user = "root";
    private static final String password = "your_workbench_pass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
