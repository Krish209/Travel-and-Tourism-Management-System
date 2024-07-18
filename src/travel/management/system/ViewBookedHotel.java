package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class ViewBookedHotel extends JFrame {
    private JPanel contentPane;
    private JLabel[] labels;
    private JLabel[] valueLabels;
    private static final String[] labelTexts = {
        "Username:", "Name:", "Hotel Name:", "Number of Persons:", "Number of Days:", "AC / Non-AC:", "Food Included (Yes/No):", "ID Type:", "ID Number:", "Phone:", "Total Cost:"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBookedHotel frame = new ViewBookedHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewBookedHotel(String username) {
        setTitle("View Booked Hotel Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 830, 600);
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setLayout(null);

        // Image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/viewhotel.jpg"));
        Image i3 = i1.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(430, 70, 350, 450);
        la1.setBorder(new LineBorder(new Color(128, 128, 128), 2));
        contentPane.add(la1);

        // Title
        JLabel lblTitle = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 26));
        lblTitle.setForeground(new Color(54, 69, 79));
        lblTitle.setBounds(35, 20, 450, 30);
        contentPane.add(lblTitle);

        // Initialize labels
        labels = new JLabel[labelTexts.length];
        valueLabels = new JLabel[labelTexts.length];

        for (int i = 0; i < labelTexts.length; i++) {
            labels[i] = new JLabel(labelTexts[i]);
            labels[i].setFont(new Font("Serif", Font.PLAIN, 18));
            labels[i].setForeground(new Color(54, 69, 79));
            labels[i].setBounds(35, 70 + 40 * i, 200, 25);
            contentPane.add(labels[i]);

            valueLabels[i] = new JLabel();
            valueLabels[i].setFont(new Font("Serif", Font.PLAIN, 18));
            valueLabels[i].setForeground(new Color(0, 0, 139));
            valueLabels[i].setBounds(250, 70 + 40 * i, 300, 25);
            contentPane.add(valueLabels[i]);
        }

        // Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(150, 520, 120, 30);
        back.setBackground(new Color(54, 69, 79));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(54, 69, 79)));
        back.setFocusPainted(false);
        addHoverEffect(back);
        back.addActionListener(e -> setVisible(false));
        contentPane.add(back);

        // Set background color
        contentPane.setBackground(new Color(230, 230, 250));

        // Load hotel details
        loadHotelDetails(username);
    }

    // Load hotel details for the given username.
    private void loadHotelDetails(String username) {
        Conn c = new Conn();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //change password
             PreparedStatement pst = conn.prepareStatement("SELECT username, name, hotel_name, totalPersons, numberOfDays, ac, food, id_type, id_number, phone, totalPrice FROM booked_hotels WHERE username = ?")) {
            
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < labelTexts.length; i++) {
                    valueLabels[i].setText(rs.getString(i + 1));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No booking found for the username: " + username, "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading hotel details: " + e.getMessage());
        }
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(54, 69, 79));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(54, 69, 79));
                button.setForeground(Color.WHITE);
            }
        });
    }
}
