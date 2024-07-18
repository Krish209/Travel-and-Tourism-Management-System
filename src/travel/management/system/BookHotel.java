package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    private JTextField totalPersons, numberOfDays;
    private Choice hotel, ac, food;
    private JLabel name, id, number, phone, totalPrice;
    private boolean isPriceChecked = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookHotel frame = new BookHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookHotel(String username) {
        setTitle("Book Hotel");
        setBounds(260, 110, 1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addComponents(username);
        loadCustomerDetails(username);
        loadHotelChoices();
    }

    private void addComponents(String username) {
        addBackgroundImage();

        JLabel title = new JLabel("BOOK HOTEL");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(new Color(34, 45, 65));
        title.setBounds(450, 10, 400, 40);
        contentPane.add(title);

        addLabel("Username :", 50, 70);
        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setBounds(270, 70, 100, 25);
        contentPane.add(usernameLabel);

        addLabel("Name :", 50, 110);
        name = new JLabel();
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        name.setForeground(Color.BLACK);
        name.setBounds(270, 110, 200, 25);
        contentPane.add(name);

        addLabel("Select Hotel :", 50, 150);
        hotel = new Choice();
        hotel.setBounds(270, 150, 150, 25);
        contentPane.add(hotel);

        addLabel("Total Persons :", 50, 190);
        totalPersons = new JTextField("1");
        totalPersons.setBounds(270, 190, 150, 25);
        contentPane.add(totalPersons);

        addLabel("Number of Days :", 50, 230);
        numberOfDays = new JTextField("1");
        numberOfDays.setBounds(270, 230, 150, 25);
        contentPane.add(numberOfDays);

        addLabel("AC / Non-AC :", 50, 270);
        ac = new Choice();
        ac.add("AC");
        ac.add("Non-AC");
        ac.setBounds(270, 270, 150, 25);
        contentPane.add(ac);

        addLabel("Food Included :", 50, 310);
        food = new Choice();
        food.add("Yes");
        food.add("No");
        food.setBounds(270, 310, 150, 25);
        contentPane.add(food);

        addLabel("ID :", 50, 350);
        id = new JLabel();
        id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        id.setForeground(Color.BLACK);
        id.setBounds(270, 350, 150, 25);
        contentPane.add(id);

        addLabel("Number :", 50, 390);
        number = new JLabel();
        number.setFont(new Font("Tahoma", Font.PLAIN, 18));
        number.setForeground(Color.BLACK);
        number.setBounds(270, 390, 150, 25);
        contentPane.add(number);

        addLabel("Phone :", 50, 430);
        phone = new JLabel();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        phone.setForeground(Color.BLACK);
        phone.setBounds(270, 430, 150, 25);
        contentPane.add(phone);

        addLabel("Total Price :", 50, 470);
        totalPrice = new JLabel();
        totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        totalPrice.setForeground(Color.BLACK);
        totalPrice.setBounds(270, 470, 150, 25);
        contentPane.add(totalPrice);

        addButton("Check Price", 30, 510, e -> checkPrice());
        addButton("Book", 200, 510, e -> bookHotel(username));
        addButton("Back", 370, 510, e -> setVisible(false));
    }

    private void addBackgroundImage() {
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/hotel5.jpeg"));
        Image scaledImage = backgroundIcon.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(500, 80, 550, 400);
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
                name.setText(rs.getString("name"));
                id.setText(rs.getString("id_type"));
                number.setText(rs.getString("id_number"));
                phone.setText(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadHotelChoices() {
        try (Conn conn = new Conn()) {
            String query = "SELECT name FROM hotels";
            PreparedStatement pst = conn.c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hotel.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void checkPrice() {
        try (Conn conn = new Conn()) {
            String selectedHotel = hotel.getSelectedItem();
            String query = "SELECT cost_per_day, food_charges, ac_charges FROM hotels WHERE name = ?";
            PreparedStatement pst = conn.c.prepareStatement(query);
            pst.setString(1, selectedHotel);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int costPerDay = rs.getInt("cost_per_day");
                int foodCharges = rs.getInt("food_charges");
                int acCharges = rs.getInt("ac_charges");

                int persons = Integer.parseInt(totalPersons.getText().trim());
                int days = Integer.parseInt(numberOfDays.getText().trim());
                String acOption = ac.getSelectedItem();
                String foodOption = food.getSelectedItem();

                if (persons > 0 && days > 0) {
                    int totalCost = costPerDay * persons * days;
                    if (acOption.equals("AC")) {
                        totalCost += acCharges * persons * days;
                    }
                    if (foodOption.equals("Yes")) {
                        totalCost += foodCharges * persons * days;
                    }
                    totalPrice.setText("Rs " + totalCost);
                    totalPrice.setForeground(Color.red);
                    totalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
                    isPriceChecked = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Persons and days must be greater than 0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void bookHotel(String username) {
        if (!isPriceChecked) {
            JOptionPane.showMessageDialog(this, "Please check the price before booking.");
            return;
        }

        if (name.getText().isEmpty() || id.getText().isEmpty() || number.getText().isEmpty() || phone.getText().isEmpty() || totalPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the details before booking.");
            return;
        }

        try (Conn conn = new Conn()) {
            String checkQuery = "SELECT * FROM booked_hotels WHERE username = ?";
            PreparedStatement checkPst = conn.c.prepareStatement(checkQuery);
            checkPst.setString(1, username);
            ResultSet rs = checkPst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "You have already booked a hotel with this username.");
                return;
            }

            String insertQuery = "INSERT INTO booked_hotels(username, name, hotel_name, totalPersons, numberOfDays, ac, food, id_type, id_number, phone, totalPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.c.prepareStatement(insertQuery);
            pst.setString(1, username);
            pst.setString(2, name.getText());
            pst.setString(3, hotel.getSelectedItem());
            pst.setInt(4, Integer.parseInt(totalPersons.getText().trim()));
            pst.setInt(5, Integer.parseInt(numberOfDays.getText().trim()));
            pst.setString(6, ac.getSelectedItem());
            pst.setString(7, food.getSelectedItem());
            pst.setString(8, id.getText());
            pst.setString(9, number.getText());
            pst.setString(10, phone.getText());
            pst.setString(11, totalPrice.getText().substring(3));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Hotel Booked Successfully");
            setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error booking hotel: " + e.getMessage());
        }
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
