# Travel and Tourism Management System

## Overview

The Travel Management System is a comprehensive Java-based application that facilitates the management and booking of travel services. This project includes features for managing customer details, booking flights, and booking travel packages. It employs Java Swing for the graphical user interface (GUI) and MySQL for the backend database.

## Features

### 1. User Authentication
- **Sign Up**: Users can create a new account.
- **Login**: Registered users can log in to access the system.

### 2. Customer Management
- **View Customer Details**: Display detailed information about customers, including username, name, ID type, ID number, gender, country, address, phone, and email.
- **Add Customer**: Users can add new customers to the system.
- **Delete Customer**: Users can delete existing customers from the system.

### 3. Flight Booking
- **View Available Flights**: Users can view available flights.
- **Book Flight**: Users can book a flight by selecting flight details, number of persons, and travel dates. The system calculates the total price based on the selected flight and number of persons.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

### 4. Package Booking
- **View Available Packages**: Users can view available travel packages.
- **Book Package**: Users can book a travel package by filling in the necessary details.
- **Validation**: Ensures all required fields are filled before booking. It also checks for duplicate bookings by the same user.

## Project Structure

### Packages

- `travel.management.system`: Contains all the classes and resources for the application.

### Classes

- `ViewCustomers.java`: Displays customer details.
- `BookFlight.java`: Handles the flight booking process.
- `BookPackage.java`: Handles the package booking process.
- `Conn.java`: Manages the database connection.

## Database

The application uses MySQL as the backend database. The database schema includes tables for storing user information, customer details, flight details, and booking information.

### Database Configuration

Ensure the MySQL database is set up with the following credentials:

- **Database**: `Travel_Management`
- **Username**: `root`
- **Password**: `Krish@2092003`

### Tables

- `customer`: Stores customer details.
- `flights`: Stores flight details.
- `booked_flights`: Stores booked flight information.
- `booked_packages`: Stores booked package information.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/travel-management-system.git
    ```

2. Set up the MySQL database with the provided schema.

3. Update the database credentials in the `Conn.java` file if necessary.

4. Compile and run the application:
    ```bash
    javac travel/management/system/*.java
    java travel.management.system.Main
    ```

## Screenshots

Include screenshots of your application's main screens here. You can add images to your repository and reference them in this section.

## Future Enhancements

- **Payment Integration**: Integrate payment gateway for processing payments.
- **Email Notifications**: Send email notifications for booking confirmations and updates.
- **Enhanced UI**: Improve the user interface for a better user experience.

## Contribution

Contributions are welcome! Please fork the repository and submit a pull request for review.

## License

This project is licensed under the MIT License.

