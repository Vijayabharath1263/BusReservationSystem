package Bus_reservation;

import java.util.Date;
import java.sql.*;

public class BookingDao {

    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query = "SELECT COUNT(passenger_name) FROM booking WHERE bus_no = ? AND travel_date = ?";
        try (Connection con = Dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            pst.setInt(1, busNo);
            pst.setDate(2, sqldate);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    return 0;
                }
            }
        }
    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO booking (passenger_name, bus_no, travel_date) VALUES (?, ?, ?)";
        try (Connection con = Dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
            pst.setString(1, booking.passengerName);
            pst.setInt(2, booking.busNo);
            pst.setDate(3, sqldate);
            pst.executeUpdate();
        }
    }
}

