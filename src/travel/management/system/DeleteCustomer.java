package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class DeleteCustomer extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel lblUsername, lblName, lblId, lblIdNumber, lblGender, lblCountry, lblAddress, lblPhone, lblEmail;
    private JLabel lblUsername1, lblName1, lblId1, lblIdNumber1, lblGender1, lblCountry1, lblAddress1, lblPhone1, lblEmail1;
    private JButton delete, back;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DeleteCustomer frame = new DeleteCustomer("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DeleteCustomer(String username) {
        setTitle("Delete Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 530, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialize labels for left column
        lblUsername = createLabel("Username :", 60, 30, 200, 25);
        lblName = createLabel("Name :", 60, 80, 200, 25);
        lblId = createLabel("ID Type :", 60, 130, 200, 25);
        lblIdNumber = createLabel("ID Number :", 60, 180, 200, 25);
        lblGender = createLabel("Gender :", 60, 230, 200, 25);
        lblCountry = createLabel("Country :", 60, 280, 200, 25);
        lblAddress = createLabel("Address :", 60, 330, 200, 25);
        lblPhone = createLabel("Phone :", 60, 380, 200, 25);
        lblEmail = createLabel("Email :", 60, 430, 200, 25);

        // Initialize labels for right column
        lblUsername1 = createLabel("", 200, 30, 300, 25);
        lblName1 = createLabel("", 200, 80, 300, 25);
        lblId1 = createLabel("", 200, 130, 300, 25);
        lblIdNumber1 = createLabel("", 200, 180, 300, 25);
        lblGender1 = createLabel("", 200, 230, 300, 25);
        lblCountry1 = createLabel("", 200, 280, 300, 25);
        lblAddress1 = createLabel("", 200, 330, 300, 25);
        lblPhone1 = createLabel("", 200, 380, 300, 25);
        lblEmail1 = createLabel("", 200, 430, 300, 25);

        // Set font and color for left column labels
        Font labelFont = new Font("Verdana", Font.BOLD, 16);
        Color labelColor = new Color(39, 174, 96);
        setLabelStyles(lblUsername, labelFont, labelColor);
        setLabelStyles(lblName, labelFont, labelColor);
        setLabelStyles(lblId, labelFont, labelColor);
        setLabelStyles(lblIdNumber, labelFont, labelColor);
        setLabelStyles(lblGender, labelFont, labelColor);
        setLabelStyles(lblCountry, labelFont, labelColor);
        setLabelStyles(lblAddress, labelFont, labelColor);
        setLabelStyles(lblPhone, labelFont, labelColor);
        setLabelStyles(lblEmail, labelFont, labelColor);

        // Set font and color for right column labels
        setLabelStyles(lblUsername1, labelFont, Color.BLACK);
        setLabelStyles(lblName1, labelFont, Color.BLACK);
        setLabelStyles(lblId1, labelFont, Color.BLACK);
        setLabelStyles(lblIdNumber1, labelFont, Color.BLACK);
        setLabelStyles(lblGender1, labelFont, Color.BLACK);
        setLabelStyles(lblCountry1, labelFont, Color.BLACK);
        setLabelStyles(lblAddress1, labelFont, Color.BLACK);
        setLabelStyles(lblPhone1, labelFont, Color.BLACK);
        setLabelStyles(lblEmail1, labelFont, Color.BLACK);

        // Load customer data
        loadCustomerData(username);

        // Delete button
        delete = new JButton("Delete");
        delete.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        delete.addActionListener(this);
        delete.setBounds(100, 490, 100, 35);
        delete.setBackground(new Color(213, 32, 32));
        delete.setForeground(Color.WHITE);
        delete.setBorder(new LineBorder(new Color(213, 32, 32)));
        delete.setFocusPainted(false);
        delete.setToolTipText("Are you sure?");
        addHoverEffect(delete);
        contentPane.add(delete);

        // Back button
        back = new JButton("Back");
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        back.addActionListener(this);
        back.setBounds(300, 490, 100, 35);
        back.setBackground(new Color(32, 130, 213));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(32, 130, 213)));
        back.setFocusPainted(false);
        addHoverEffect1(back);
        contentPane.add(back);

        getContentPane().setBackground(new Color(255, 248, 220));
    }

    // Method to create JLabel with specified properties
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        contentPane.add(label);
        return label;
    }

    // Method to set font and color for labels
    private void setLabelStyles(JLabel label, Font font, Color color) {
        label.setFont(font);
        label.setForeground(color);
    }

    // Method to load customer data from database
    private void loadCustomerData(String username) {
        String query = "SELECT * FROM customer WHERE username = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //check password
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lblUsername1.setText(rs.getString("username"));
                lblName1.setText(rs.getString("name"));
                lblId1.setText(rs.getString("id_type"));
                lblIdNumber1.setText(rs.getString("id_number"));
                lblGender1.setText(rs.getString("gender"));
                lblCountry1.setText(rs.getString("country"));
                lblAddress1.setText(rs.getString("address"));
                lblPhone1.setText(rs.getString("phone"));
                lblEmail1.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(this, "No customer found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage());
        }
    }

    // Method to delete customer data from database
    private void deleteCustomer(String username) {
        String query = "DELETE FROM customer WHERE username = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //check password
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Customer details deleted successfully.");
                setVisible(false); // Close the window after deletion
            } else {
                JOptionPane.showMessageDialog(this, "No customer found with username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting customer data: " + e.getMessage());
        }
    }

    // Method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            // Delete button clicked
            String username = lblUsername1.getText();
            deleteCustomer(username);
        } else if (ae.getSource() == back) {
            // Back button clicked
            setVisible(false);
            // new Home(username);
        }
    }

    // Method to add hover effect to buttons
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.red);
                button.setForeground(Color.WHITE);
            }
        });
    }

    private void addHoverEffect1(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(32, 130, 213));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(32, 130, 213));
                button.setForeground(Color.WHITE);
            }
        });
    }
}
