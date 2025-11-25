# Bus Reservation System (Java Console + MySQL)

A Java-based bus reservation console application using JDBC and MySQL.

## Features
- View available buses (AC/Non-AC, capacity)
- Book a ticket
- Prevents overbooking
- Stores booking details in MySQL database

## Project Structure
BusReservationSystem/
├── src/
│   └── Bus_reservation/
│       ├── Bus.java
│       ├── Booking.java
│       ├── Bus_demo.java
│       ├── BookingDao.java
│       ├── BusDao.java
│       └── Dbconnection.java
├── sql/
│   ├── schema.sql
│   └── sample_data.sql
└── README.md

## How to Run
1. Create database using `sql/schema.sql`
2. Insert sample data using `sql/sample_data.sql`
3. Update your DB credentials in `Dbconnection.java`
4. Run `Bus_demo` class in Eclipse

