package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.*;

public class BookFlight extends JFrame {
    private JPanel contentPane;
    private JTextField numberOfPersons;
    private Choice flight;
    private JLabel usernameLabel, nameLabel, idLabel, numberLabel, phoneLabel, totalPriceLabel;
    private JComboBox<String> fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
    private boolean isPriceChecked = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookFlight frame = new BookFlight("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookFlight(String username) {
        setTitle("Book Flight");
        setBounds(260, 110, 1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addComponents(username);
        loadCustomerDetails(username);
        loadFlightChoices();
    }

    private void addComponents(String username) {
        addBackgroundImage();

        JLabel title = new JLabel("BOOK FLIGHT");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(new Color(34, 45, 65));
        title.setBounds(450, 0, 400, 40);
        contentPane.add(title);

        addLabel("Username :", 50, 70);
        usernameLabel = new JLabel(username);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setBounds(270, 70, 100, 25);
        contentPane.add(usernameLabel);

        addLabel("Name :", 50, 110);
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(270, 110, 200, 25);
        contentPane.add(nameLabel);

        addLabel("Select Flight :", 50, 150);
        flight = new Choice();
        flight.setBounds(270, 150, 180, 25);
        contentPane.add(flight);

        addLabel("Number of Persons :", 50, 190);
        numberOfPersons = new JTextField("1");
        numberOfPersons.setBounds(270, 190, 180, 25);
        contentPane.add(numberOfPersons);

        addLabel("From Date :", 50, 230);
        fromDay = createDayComboBox();
        fromMonth = createMonthComboBox();
        fromYear = createYearComboBox();
        addDateComboBoxes(fromDay, fromMonth, fromYear, 270, 230);

        addLabel("To Date :", 50, 270);
        toDay = createDayComboBox();
        toMonth = createMonthComboBox();
        toYear = createYearComboBox();
        addDateComboBoxes(toDay, toMonth, toYear, 270, 270);

        addLabel("ID :", 50, 310);
        idLabel = new JLabel();
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idLabel.setForeground(Color.BLACK);
        idLabel.setBounds(270, 310, 150, 25);
        contentPane.add(idLabel);

        addLabel("Number :", 50, 350);
        numberLabel = new JLabel();
        numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        numberLabel.setForeground(Color.BLACK);
        numberLabel.setBounds(270, 350, 150, 25);
        contentPane.add(numberLabel);

        addLabel("Phone :", 50, 390);
        phoneLabel = new JLabel();
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        phoneLabel.setForeground(Color.BLACK);
        phoneLabel.setBounds(270, 390, 150, 25);
        contentPane.add(phoneLabel);

        addLabel("Total Price :", 50, 430);
        totalPriceLabel = new JLabel();
        totalPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        totalPriceLabel.setForeground(Color.BLACK);
        totalPriceLabel.setBounds(270, 430, 150, 25);
        contentPane.add(totalPriceLabel);

        addButton("Check Price", 30, 480, e -> checkPrice());
        addButton("Book", 200, 480, e -> bookFlight(username));
        addButton("Back", 370, 480, e -> setVisible(false));
    }

    private void addBackgroundImage() {
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/flighticon.png"));
        Image scaledImage = backgroundIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(450, 30, 700, 500);
        contentPane.add(backgroundLabel);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        label.setForeground(new Color(34, 45, 65));
        label.setBounds(x, y, 200, 25);
        contentPane.add(label);
    }

    private void addButton(String text, int x, int y, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 140, 30);
        button.setFont(new Font("SERIF", Font.BOLD, 20));
        button.setBackground(new Color(255, 153, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
        addHoverEffect(button);
        contentPane.add(button);
    }

    private void loadCustomerDetails(String username) {
        try (Conn conn = new Conn()) {
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nameLabel.setText(rs.getString("name"));
                idLabel.setText(rs.getString("id_type"));
                numberLabel.setText(rs.getString("id_number"));
                phoneLabel.setText(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading customer details: " + e.getMessage());
        }
    }

    private void loadFlightChoices() {
        try (Conn conn = new Conn()) {
            String query = "SELECT name FROM flights";
            PreparedStatement pst = conn.c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                flight.addItem(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading flight choices: " + e.getMessage());
        }
    }

    private void checkPrice() {
        if (numberOfPersons.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the number of persons.");
            return;
        }

        try (Conn conn = new Conn()) {
            String selectedFlight = flight.getSelectedItem();
            String query = "SELECT price FROM flights WHERE name = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, selectedFlight);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double price = rs.getDouble("price");
                int persons = Integer.parseInt(numberOfPersons.getText().trim());

                if (persons > 0) {
                    double totalPrice = price * persons;
                    totalPriceLabel.setText("Rs " + totalPrice);
                    totalPriceLabel.setForeground(Color.RED);
                    totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
                    isPriceChecked = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Number of persons must be greater than 0.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error checking price: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format for persons: " + e.getMessage());
        }
    }

    private void bookFlight(String username) {
        if (!isPriceChecked) {
            JOptionPane.showMessageDialog(this, "Please check the price before booking.");
            return;
        }

        // Validate all required fields are filled
        if (nameLabel.getText().isEmpty() || idLabel.getText().isEmpty() || numberLabel.getText().isEmpty() || phoneLabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required customer details.");
            return;
        }

        String fromDate = fromYear.getSelectedItem() + "-" + fromMonth.getSelectedItem() + "-" + fromDay.getSelectedItem();
        String toDate = toYear.getSelectedItem() + "-" + toMonth.getSelectedItem() + "-" + toDay.getSelectedItem();

        // if (numberOfPersons.getText().trim().isEmpty() || fromDate.isEmpty() || toDate.isEmpty()) {
        //     JOptionPane.showMessageDialog(this, "Please fill in all required fields (Number of Persons, From Date, To Date).");
        //     return;
        // }

        try (Conn conn = new Conn()) {
            // Check if the same booking exists
            if (isBookingExists(username, fromDate, toDate)) {
                JOptionPane.showMessageDialog(this, "You have already booked the same flight with the same dates.");
                return;
            }

            String insertQuery = "INSERT INTO booked_flights(username, name, flight_name, price, numberOfPersons, from_date, to_date, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.c.prepareStatement(insertQuery)) {
                pst.setString(1, username);
                pst.setString(2, nameLabel.getText());
                pst.setString(3, flight.getSelectedItem());
                pst.setDouble(4, Double.parseDouble(totalPriceLabel.getText().substring(3)));
                pst.setInt(5, Integer.parseInt(numberOfPersons.getText().trim()));
                pst.setDate(6, Date.valueOf(fromDate));
                pst.setDate(7, Date.valueOf(toDate));
                pst.setDouble(8, Double.parseDouble(totalPriceLabel.getText().substring(3)));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Flight Booked Successfully");
                setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error booking flight: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format: " + e.getMessage());
        }
    }

    private boolean isBookingExists(String username, String fromDate, String toDate) throws SQLException {
        String query = "SELECT * FROM booked_flights WHERE username = ? AND from_date = ? AND to_date = ?";
        try (Conn conn = new Conn();
             PreparedStatement pst = conn.c.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setDate(2, Date.valueOf(fromDate));
            pst.setDate(3, Date.valueOf(toDate));
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Returns true if there is any existing booking with the same details
        }
    }

    private JComboBox<String> createDayComboBox() {
        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.format("%02d", i));
        }
        return dayComboBox;
    }

    private JComboBox<String> createMonthComboBox() {
        JComboBox<String> monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.format("%02d", i));
        }
        return monthComboBox;
    }

    private JComboBox<String> createYearComboBox() {
        JComboBox<String> yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 10; i++) {
            yearComboBox.addItem(Integer.toString(i));
        }
        return yearComboBox;
    }

    private void addDateComboBoxes(JComboBox<String> day, JComboBox<String> month, JComboBox<String> year, int x, int y) {
        day.setBounds(x, y, 50, 25);
        contentPane.add(day);

        month.setBounds(x + 60, y, 50, 25);
        contentPane.add(month);

        year.setBounds(x + 120, y, 70, 25);
        contentPane.add(year);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(255, 153, 0));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(255, 153, 0));
                button.setForeground(Color.WHITE);
            }
        });
    }
}
