# Travel and Tourism Management System

## Overview

The Travel Management System is a comprehensive Java-based application that facilitates the management and booking of travel services. This project includes features for managing customer details, booking flights, booking hotels, and booking travel packages. It employs Java Swing for the graphical user interface (GUI) and MySQL for the backend database.

## Features

### 1. User Authentication
- **Sign Up**: Users can create a new account.
- **Login**: Registered users can log in to access the system.

### 2. Customer Management
- **View Customer Details**: Display detailed information about customers, including username, name, ID type, ID number, gender, country, address, phone, and email.
- **Add Customer**: Users can add new customers to the system.
- **Delete Customer**: Users can delete existing customers from the system.

### 3. Hotel Booking
- **Check Hotels**: Users can check available hotels.
- **Book Hotel**: Users can book hotels by selecting hotel details and dates.
- **View Booked Hotels**: Users can view their booked hotel details.

### 4. Package Booking
- **View Available Packages**: Users can view available travel packages.
- **Book Package**: Users can book a travel package by filling in the necessary details.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

### 5. Flight Booking
- **View Available Flights**: Users can view available flights.
- **Book Flight**: Users can book a flight by selecting flight details, number of persons, and travel dates. The system calculates the total price based on the selected flight and number of persons.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

## Project Structure

### Packages

- `travel.management.system`: Contains all the classes and resources for the application.

### Classes

- `Main.java`: The main class to run the application.
- `Conn.java`: Handles the database connection.
- `SignUp.java`: Handles user registration.
- `Login.java`: Handles user login.
- `AddCustomer.java`: Manages adding new customer details.
- `ViewCustomers.java`: Displays customer details.
- `BookFlight.java`: Manages flight booking.
- `ViewBookedFlights.java`: Displays booked flight details.
- `BookHotel.java`: Manages hotel booking.
- `ViewBookedHotels.java`: Displays booked hotel details.
- `BookPackage.java`: Manages package booking.

## Database

The application uses MySQL as the backend database. The database schema includes tables for storing user information, customer details, flight details, hotel details, and booking information.

### Tables

- `customer`: Stores customer details.
- `flights`: Stores flight details.
- `booked_flights`: Stores booked flight information.
- `hotels`: Stores hotel details.
- `booked_hotels`: Stores booked hotel information.
- `packages`: Stores package details.
- `booked_packages`: Stores booked package information.

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

3. **Customer Management**:
   - Add new customers and view all customer details.

4. **Flight Booking**:
   - Select flight details, dates, and the number of passengers to book a flight.
   - Check the price and confirm the booking.

5. **Hotel Booking**:
   - Check available hotels and select hotel details and dates to book a hotel.
   - Confirm the booking.

6. **Package Booking**:
   - View available packages and select details to book a package.
   - Confirm the booking.

7. **View Booked Flights and Hotels**:
   - View detailed information about your booked flights and hotels.

## Screenshots

![Signup](path/to/signup.png)
![Login](path/to/login.png)
![Book Flight](path/to/book-flight.png)
![View Booked Flights](path/to/view-booked-flights.png)
![Book Hotel](path/to/book-hotel.png)
![View Booked Hotels](path/to/view-booked-hotels.png)
![Book Package](path/to/book-package.png)
![View Booked Packages](path/to/view-booked-packages.png)

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
