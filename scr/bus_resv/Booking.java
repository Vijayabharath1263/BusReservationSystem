package Bus_reservation;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
    public String passengerName;
    public int busNo;
    public Date date;

    public Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passenger:");
        passengerName = sc.nextLine().trim();

        System.out.println("Enter bus no:");
        while(!sc.hasNextInt()) {
            System.out.println("Please enter a valid bus number (integer):");
            sc.next();
        }
        busNo = sc.nextInt();

        System.out.println("Enter date (dd-MM-yyyy):");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using current date as fallback.");
            date = new Date();
        }
        // NOTE: Do not close System.in Scanner here if others will reuse it.
    }

    public boolean isAvailable() throws SQLException {
        BusDao busdao = new BusDao();
        BookingDao bookingdao = new BookingDao();

        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo, date);
        return booked < capacity;
    }
}
