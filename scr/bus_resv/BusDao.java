package Bus_reservation;

import java.sql.*;

public class BusDao {

    public void displayBusInfo() throws SQLException {
        String query = "SELECT id, is_ac, capacity FROM bus";
        try (Connection con = Dbconnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("Available buses:");
            while (rs.next()) {
                System.out.println("Bus No: " + rs.getInt("id"));
                int acFlag = rs.getInt("is_ac");
                System.out.println("AC : " + (acFlag == 0 ? "No" : "Yes"));
                System.out.println("Capacity: " + rs.getInt("capacity"));
                System.out.println("-------------------------------");
            }
        }
    }

    public int getCapacity(int id) throws SQLException {
        String query = "SELECT capacity FROM bus WHERE id = ?";
        try (Connection con = Dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("capacity");
                } else {
                    throw new SQLException("Bus with id=" + id + " not found.");
                }
            }
        }
    }
}

