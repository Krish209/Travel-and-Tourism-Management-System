package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    private JTextField t1;
    private Choice c1;
    private JLabel l1, l2, l3, l4, l5, l6;

    private boolean priceChecked = false; // flag to check if price is checked

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookPackage frame = new BookPackage("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookPackage(String username) {
        setTitle("Book Package");
        setBounds(300, 200, 980, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/bookpackage.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(430, 430, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(500, 30, 430, 390);
        add(la1);

        // Title label
        JLabel lblName = new JLabel("BOOK PACKAGE");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 24));
        lblName.setBounds(118, 5, 300, 53);
        contentPane.add(lblName);

        // Username label
        JLabel la2 = new JLabel("Username:");
        la2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        la2.setBounds(50, 70, 200, 20);
        contentPane.add(la2);

        l1 = new JLabel(username);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(271, 70, 200, 20);
        contentPane.add(l1);

        // Name label
        JLabel la4 = new JLabel("Name:");
        la4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        la4.setBounds(50, 110, 200, 20);
        contentPane.add(la4);

        l6 = new JLabel();
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(271, 110, 200, 20);
        contentPane.add(l6);

        // Select package label
        JLabel lblId = new JLabel("Select Package:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblId.setBounds(50, 150, 200, 20);
        contentPane.add(lblId);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271, 150, 150, 30);
        add(c1);

        // Total persons label
        JLabel la3 = new JLabel("Total Persons:");
        la3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        la3.setBounds(50, 190, 200, 20);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setText("1");
        t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        t1.setBounds(271, 190, 150, 25);
        contentPane.add(t1);
        t1.setColumns(10);

        // ID label
        JLabel lbl1 = new JLabel("ID Type:");
        lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl1.setBounds(50, 230, 200, 20);
        contentPane.add(lbl1);

        l2 = new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(271, 230, 200, 20);
        contentPane.add(l2);

        // Number label
        JLabel lbl2 = new JLabel("ID Number:");
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl2.setBounds(50, 270, 200, 20);
        contentPane.add(lbl2);

        l3 = new JLabel();
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(271, 270, 200, 20);
        contentPane.add(l3);

        // Phone label
        JLabel lbl3 = new JLabel("Phone:");
        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl3.setBounds(50, 310, 200, 20);
        contentPane.add(lbl3);

        l4 = new JLabel();
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(271, 310, 200, 20);
        contentPane.add(l4);

        // Total price label
        JLabel lblDeposite = new JLabel("Total Price:");
        lblDeposite.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDeposite.setBounds(50, 350, 200, 20);
        contentPane.add(lblDeposite);

        l5 = new JLabel();
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setBounds(271, 350, 200, 20);
        l5.setForeground(Color.RED);
        contentPane.add(l5);

        // Load customer details
        loadCustomerDetails(username);

        // Check price button
        JButton Checkprice = new JButton("Check Price");
        Checkprice.setFocusPainted(false);
        Checkprice.addActionListener(e -> {
            calculatePrice();
            priceChecked = true;
        });
        Checkprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        Checkprice.setBounds(30, 390, 130, 30);
        Checkprice.setBackground(Color.BLUE);
        Checkprice.setForeground(Color.WHITE);
        addHoverEffect(Checkprice);
        contentPane.add(Checkprice);

        // Book button
        JButton book = new JButton("Book");
        book.setFocusPainted(false);
        book.addActionListener(e -> bookPackage(username));
        book.setFont(new Font("Tahoma", Font.BOLD, 16));
        book.setBounds(180, 390, 120, 30);
        book.setBackground(Color.BLUE);
        book.setForeground(Color.WHITE);
        book.setToolTipText("First check price before booking");
        addHoverEffect(book);
        contentPane.add(book);

        // Back button
        JButton back = new JButton("Back");
        back.setFocusPainted(false);
        back.addActionListener(e -> setVisible(false));
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(320, 390, 120, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        addHoverEffect(back);
        contentPane.add(back);

        getContentPane().setBackground(Color.WHITE);
    }

    private void loadCustomerDetails(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //check password
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM customer WHERE username = ?")) {
            
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                l6.setText(rs.getString("name"));
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("id_number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading customer details: " + e.getMessage());
        }
    }

    // Calculate the price based on the selected package and number of persons.
    private void calculatePrice() {
        try {
            String packageType = c1.getSelectedItem();
            int cost = 0;
            switch (packageType) {
                case "Gold Package":
                    cost = 12000;
                    break;
                case "Silver Package":
                    cost = 25000;
                    break;
                case "Bronze Package":
                    cost = 32000;
                    break;
            }
            int totalPersons = Integer.parseInt(t1.getText());
            if (totalPersons < 1) {
                JOptionPane.showMessageDialog(this, "Total Persons cannot be less than 1");
                return;
            }
            cost *= totalPersons;
            l5.setText("Rs " + cost);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of persons");
        }
    }

    // Book the selected package for the given username.
    private void bookPackage(String username) {
        if (!priceChecked) {
            JOptionPane.showMessageDialog(this, "Please check the price before booking");
            return;
        }

        if (l6.getText().isEmpty() || l2.getText().isEmpty() || l3.getText().isEmpty() || l4.getText().isEmpty() || l5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the details before booking");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //change password
             PreparedStatement checkPst = conn.prepareStatement("SELECT * FROM booked_packages WHERE username = ?")) {

            checkPst.setString(1, username);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "You have already booked a package with this username");
                return;
            }
            
            try (PreparedStatement pst = conn.prepareStatement("INSERT INTO booked_packages (username, name, package, number_of_persons, id_type, id_number, phone, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

                pst.setString(1, username);
                pst.setString(2, l6.getText());
                pst.setString(3, c1.getSelectedItem());
                pst.setInt(4, Integer.parseInt(t1.getText()));
                pst.setString(5, l2.getText());
                pst.setString(6, l3.getText());
                pst.setString(7, l4.getText());
                pst.setString(8, l5.getText());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Package Booked Successfully");
                setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error booking package: " + e.getMessage());
        }
    }

    // Add hover effect to buttons
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.WHITE);
            }
        });
    }
}
