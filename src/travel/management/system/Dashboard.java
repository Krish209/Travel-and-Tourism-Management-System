package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Dashboard extends JFrame implements ActionListener {

    JPanel p1, p2, p3;
    JLabel icon, heading, image, text;
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkPackages,
            bookPackage, viewPackage, viewHotels, bookHotel, viewBookedHotel, destinations,
            payments, calculator, notepad, about;

    Dashboard() {
        // Frame settings
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel 1 (Header)
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 60);
        add(p1);

        // Dashboard icon
        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/logo1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        icon = new JLabel(i3);
        icon.setBounds(10, 5, 50, 50);
        p1.add(icon);

        // Dashboard heading
        heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        p1.add(heading);

        // Panel 2 (Sidebar)
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(0, 10, 300, 900);
        add(p2);

        // Buttons in Sidebar
        addPersonalDetails = createButton("Add Personal Details", 50);
        updatePersonalDetails = createButton("Update Personal Details", 100);
        viewPersonalDetails = createButton("View Personal Details", 150);
        deletePersonalDetails = createButton("Delete Personal Details", 200);
        checkPackages = createButton("Check Packages", 250);
        bookPackage = createButton("Book Package", 300);
        viewPackage = createButton("View Package", 350);
        viewHotels = createButton("View Hotels", 400);
        bookHotel = createButton("Book Hotel", 450);
        viewBookedHotel = createButton("View Booked Hotel", 500);
        destinations = createButton("Destinations", 550);
        payments = createButton("Payments", 600);
        calculator = createButton("Calculator", 650);
        notepad = createButton("Notepad", 700);
        about = createButton("About", 750);

        // Panel 3 (image)
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(0, 0, 102));
        p3.setBounds(300, 60, 1600, 60);
        add(p3);

        // Background Image
        ImageIcon i4 = new ImageIcon(getClass().getClassLoader().getResource("travel/management/system/images/image6.png"));
        Image i5 = i4.getImage().getScaledInstance(1350, 800, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        image = new JLabel(i6);
        image.setBounds(300, 0, 1350, 800);
        p3.add(image);

        // Text label on top of the background image
        text = new JLabel("Travel and Tourism Management System");
        text.setBounds(70, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("raleway", Font.PLAIN, 40));
        image.add(text);

        setVisible(true);
    }

    // Method to create buttons with common settings
    private JButton createButton(String text, int y) {
        JButton button = new JButton(text);
        button.setBounds(0, y, 300, 50);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.BLUE));
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.addActionListener(this);
        addHoverEffect(button);
        p2.add(button);
        return button;
    }

    // Method to add hover effect to buttons
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            Color originalColor = button.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(originalColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    // Action event handling
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            // setVisible(false);
            new AddCustomer("");
        } else if (ae.getSource() == updatePersonalDetails) {
            // setVisible(false);
            new UpdateCustomer("");
        } else if (ae.getSource() == viewPersonalDetails) {
            // setVisible(false);
            new ViewCustomers("");
        } else if (ae.getSource() == deletePersonalDetails) {
            // setVisible(false);
            new DeleteCustomer("");
        } else if (ae.getSource() == checkPackages) {
            // setVisible(false);
            new CheckPackage("");
        } else if (ae.getSource() == bookPackage) {
            // setVisible(false);
            new BookPackage("");
        } else if (ae.getSource() == viewPackage) {
            // setVisible(false);
            new ViewBookedPackage("");
        } else if (ae.getSource() == viewHotels) {
            // setVisible(false);
            new ViewBookedHotel("");
        } else if (ae.getSource() == bookHotel) {
            // setVisible(false);
            new BookHotel("");
        } else if (ae.getSource() == viewBookedHotel) {
            // setVisible(false);
            new BookHotel("");
        } else if (ae.getSource() == destinations) {
            // setVisible(false);
            new Destination();
        } else if (ae.getSource() == payments) {
            // setVisible(false);
            new Payment();
        } else if (ae.getSource() == calculator) {
            // setVisible(false);
            Runtime.getRuntime().exec("notepad.exe");
        } else if (ae.getSource() == notepad) {
            // setVisible(false);
            Runtime.getRuntime().exec("calc.exe");
        } else if (ae.getSource() == about) {
            // setVisible(false);
            new About();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard();
        });
    }
}
