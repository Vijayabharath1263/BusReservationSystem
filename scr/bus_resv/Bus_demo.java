package Bus_reservation;

import java.sql.SQLException;
import java.util.Scanner;

public class Bus_demo {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BusDao busdao = new BusDao();
            busdao.displayBusInfo();

            int userOpt = 1;

            while (userOpt == 1) {
                System.out.println("Enter 1 to Book and 2 to exit:");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid option (1 or 2):");
                    sc.next();
                }
                userOpt = sc.nextInt();
                if (userOpt == 1) {
                    // Use Booking constructor that reads from stdin
                    Booking booking = new Booking();
                    if (booking.isAvailable()) {
                        BookingDao bookingdao = new BookingDao();
                        bookingdao.addBooking(booking);
                        System.out.println("Your booking is Confirmed.");
                    } else {
                        System.out.println("Sorry. Bus is full. Try another bus or date.");
                    }
                } else if (userOpt == 2) {
                    System.out.println("Exiting. Thank you!");
                    break;
                } else {
                    System.out.println("Invalid option. Please enter 1 or 2.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

