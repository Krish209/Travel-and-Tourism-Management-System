# Travel and Tourism Management System

## Overview

The Travel Management System is a comprehensive Java-based application that facilitates the management and booking of travel services. This project includes features for managing customer details, booking flights, booking hotels, and booking travel packages. It employs Java Swing for the graphical user interface (GUI) and MySQL for the backend database.

## Features

### 1. User Authentication
- **Sign Up**: Users can create a new account.
- **Login**: Registered users can log in to access the system.
- **Forgot Password**: Registered users can reset their password if they forget it.

### 2. Customer Management
- **View Customer Details**: Display detailed information about customers, including username, name, ID type, ID number, gender, country, address, phone, and email.
- **Add Customer**: Users can add new customers to the system.
- **Update Customer**: Users can update existing customer details.
- **Delete Customer**: Users can delete existing customers from the system.

### 3. Hotel Booking
- **Check Hotels**: Users can check available hotels.
- **Book Hotel**: Users can book hotels by selecting hotel details and dates.
- **View Booked Hotels**: Users can view their booked hotel details.

### 4. Package Booking
- **Check Packages**: Users can check available travel packages.
- **View Available Packages**: Users can view available travel packages.
- **Book Package**: Users can book a travel package by filling in the necessary details.
- **View Booked Packages**: Users can view their booked package details.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

### 5. Flight Booking
- **View Available Flights**: Users can view available flights.
- **Book Flight**: Users can book a flight by selecting flight details, number of persons, and travel dates. The system calculates the total price based on the selected flight and number of persons.
- **View Booked Flights**: Users can view their booked flight details.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

## Project Structure

### Packages

- `travel.management.system`: Contains all the classes and resources for the application.

### Classes

- `Main.java`: The main class to run the application.
- `Home.java`: Redirects the user after login to access different features.
- `Conn.java`: Handles the database connection.
- `SignUp.java`: Handles user registration.
- `Login.java`: Handles user login.
- `ForgotPassword.java`: Handles password reset.
- `AddCustomer.java`: Manages adding new customer details.
- `UpdateCustomer.java`: Manages updating customer details.
- `DeleteCustomer.java`: Manages deleting customer details.
- `ViewCustomers.java`: Displays customer details.
- `CheckPackage.java`: Allows users to check available packages.
- `BookPackage.java`: Manages package booking.
- `ViewBookedPackage.java`: Displays booked package details.
- `CheckHotels.java`: Allows users to check available hotels.
- `BookHotel.java`: Manages hotel booking.
- `ViewBookedHotel.java`: Displays booked hotel details.
- `BookFlight.java`: Manages flight booking.
- `ViewBookedFlights.java`: Displays booked flight details.

## Database

The application uses MySQL as the backend database. The database schema includes tables for storing user information, customer details, flight details, hotel details, and booking information.

### Tables

- `customer`: Stores customer details.
- `packages`: Stores package details.
- `booked_packages`: Stores booked package information.
- `hotels`: Stores hotel details.
- `booked_hotels`: Stores booked hotel information.
- `flights`: Stores flight details.
- `booked_flights`: Stores booked flight information.

## Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/travel-management-system.git
    ```

2. **Open with VSCode**:
    ```bash
    code .
    ```

3. **Set up the MySQL database with the provided schema.**

4. **Update the database credentials in the `Conn.java` file if necessary.**
    ```java
    public class Conn {
        Connection c;
        Statement s;
        public Conn() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql:///Travel_Management", "root", "password");
                s = c.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```

5. **Compile and run the Application**:
    ```bash
    javac travel/management/system/*.java
    java travel.management.system.Main
    ```

## Usage

1. **Sign Up**:
   - Create a new account using the signup form.

2. **Login**:
   - Log in with your username and password.
  
3. **Forgot Password**:
   - Reset your password if you forget it.

4. **Customer Management**:
   - Add new customers and view all customer details.
   - Update existing customer details.
   - Delete customers.

5. **Package Booking**:
   - Check available packages.
   - View available packages and select details to book a package.
   - Confirm the booking.
   - View booked packages.

6. **Hotel Booking**:
   - Check available hotels.
   - Select hotel details and dates to book a hotel.
   - Confirm the booking.
   - View booked hotels.

7. **Flight Booking**:
   - View available flights.
   - Select flight details, dates, and the number of passengers to book a flight.
   - Check the price and confirm the booking.
   - View booked flights.

## Screenshots

![image](https://github.com/user-attachments/assets/56fbd6c9-e2a6-469b-8874-5788a5c02d3c)

![image](https://github.com/user-attachments/assets/c79ca99c-9d3b-4228-9674-f6fca4a8271b)

![image](https://github.com/user-attachments/assets/1dbd711d-207d-4d99-9d86-0f52466de97b)

![image](https://github.com/user-attachments/assets/ecabed9b-b715-4ac3-956e-621e4b42fc5d)

![image](https://github.com/user-attachments/assets/e3bc1fdc-7a93-45f9-aaa6-7a7a86b40f6f)

![image](https://github.com/user-attachments/assets/18e20414-7e73-44ee-a5a9-040db2ee4284)

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.


