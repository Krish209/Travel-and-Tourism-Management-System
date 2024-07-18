package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class ViewBookedPackage extends JFrame {
    private JPanel contentPane;
    private JLabel[] labels;
    private JLabel[] valueLabels;
    private static final String[] labelTexts = {
        "Username", "Name", "Package", "Number of Persons", "ID Type", "ID Number", "Phone", "Price"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBookedPackage frame = new ViewBookedPackage("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewBookedPackage(String username) {
        setTitle("View Package");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 180, 830, 490);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/viewpackage.png"));
        Image i3 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(400, 30, 380, 380);
        la1.setBorder(new LineBorder(new Color(128, 128, 128), 2));
        contentPane.add(la1);

        // Title
        JLabel lblTitle = new JLabel("VIEW PACKAGE DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        lblTitle.setForeground(new Color(34, 45, 65));
        lblTitle.setBounds(35, 20, 350, 30);
        contentPane.add(lblTitle);

        // Initialize labels
        labels = new JLabel[labelTexts.length];
        valueLabels = new JLabel[labelTexts.length];

        for (int i = 0; i < labelTexts.length; i++) {
            labels[i] = new JLabel(labelTexts[i] + " :");
            labels[i].setFont(new Font("Verdana", Font.BOLD, 16));
            labels[i].setForeground(new Color(41, 128, 185));
            labels[i].setBounds(35, 70 + 40 * i, 200, 25);
            contentPane.add(labels[i]);

            valueLabels[i] = new JLabel();
            valueLabels[i].setFont(new Font("Verdana", Font.PLAIN, 16));
            valueLabels[i].setForeground(new Color(51, 51, 51));
            valueLabels[i].setBounds(250, 70 + 40 * i, 200, 25);
            contentPane.add(valueLabels[i]);
        }

        // Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(160, 400, 120, 30);
        back.setBackground(new Color(39, 174, 96));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(39, 174, 96)));
        back.setFocusPainted(false);
        addHoverEffect(back);
        back.addActionListener(e -> setVisible(false));
        contentPane.add(back);

        // Set background color
        contentPane.setBackground(new Color(255, 248, 220));

        // Load package details
        loadPackageDetails(username);
    }

    // Load package details for the given username.
    private void loadPackageDetails(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //change password
             PreparedStatement pst = conn.prepareStatement("SELECT username, name, package, number_of_persons, id_type, id_number, phone, price FROM booked_packages WHERE username = ?")) {
            
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < labelTexts.length; i++) {
                    valueLabels[i].setText(rs.getString(i + 1));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No package found for username: " + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading package details: " + e.getMessage());
        }
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(39, 174, 96));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(39, 174, 96));
                button.setForeground(Color.WHITE);
            }
        });
    }
}
