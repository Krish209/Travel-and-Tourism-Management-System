package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ViewBookedFlight extends JFrame {

    private JLabel[] labels;
    private JLabel[] valueLabels;
    private static final String[] labelTexts = {
        "Username", "Name", "Flight Name", "Price",
        "Number of Persons", "From Date", "To Date", "Total Price"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBookedFlight frame = new ViewBookedFlight("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewBookedFlight(String username) {
        setTitle("View Flight Ticket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 180, 850, 500);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 248, 220));

        // Image setup (if needed)
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/flight.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(430, 40, 360, 380);
        imageLabel.setBorder(new LineBorder(new Color(128, 128, 128), 2));
        contentPane.add(imageLabel);

        // Title
        JLabel titleLabel = new JLabel("VIEW FLIGHT TICKET DETAILS");
        titleLabel.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        titleLabel.setForeground(new Color(34, 45, 65));
        titleLabel.setBounds(35, 20, 400, 30);
        contentPane.add(titleLabel);

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
            valueLabels[i].setBounds(250, 70 + 40 * i, 400, 25);
            contentPane.add(valueLabels[i]);
        }

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        backButton.setBounds(160, 400, 120, 30);
        backButton.setBackground(new Color(39, 174, 96));
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(new LineBorder(new Color(39, 174, 96)));
        backButton.setFocusPainted(false);
        addHoverEffect(backButton);
        backButton.addActionListener(e -> setVisible(false));
        contentPane.add(backButton);

        // Load flight ticket details
        loadFlightTicketDetails(username);
    }

    // Load flight ticket details for the given username.
    private void loadFlightTicketDetails(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //change password
             PreparedStatement pst = conn.prepareStatement("SELECT username, name, flight_name, price, numberOfPersons, from_date, to_date, totalPrice FROM booked_flights WHERE username = ?")) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < labelTexts.length; i++) {
                    valueLabels[i].setText(rs.getString(i + 1));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No flight ticket found for username: " + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading flight ticket details: " + e.getMessage());
        }
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(39, 174, 96));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(39, 174, 96));
                button.setForeground(Color.WHITE);
            }
        });
    }
}
