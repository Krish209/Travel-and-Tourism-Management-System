package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Home extends JFrame {
    String username;

    public static void main(String[] args) {
        new Home("").setVisible(true);
    }

    public Home(String username) {
        super("Travel and Tourism Management System");
        this.username = username;
        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Serif", Font.BOLD, 48));
        l1.setBounds(350, 50, 1200, 100);
        NewLabel.add(l1);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        // Customer menu
        JMenu m1 = new JMenu("CUSTOMER");
        m1.setForeground(new Color(0, 0, 139));
        m1.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m1);

        JMenuItem mi1 = new JMenuItem("ADD CUSTOMER");
        mi1.setFont(new Font("Serif", Font.PLAIN, 16));
        m1.add(mi1);

        JMenuItem mi2 = new JMenuItem("UPDATE CUSTOMER DETAIL");
        mi2.setFont(new Font("Serif", Font.PLAIN, 16));
        m1.add(mi2);

        JMenuItem mi3 = new JMenuItem("VIEW CUSTOMER DETAILS");
        mi3.setFont(new Font("Serif", Font.PLAIN, 16));
        m1.add(mi3);

        JMenuItem mi4 = new JMenuItem("DELETE CUSTOMER DETAILS");
        mi4.setFont(new Font("Serif", Font.PLAIN, 16));
        m1.add(mi4);

        mi1.addActionListener(ae -> new AddCustomer(username).setVisible(true));
        mi2.addActionListener(ae -> new UpdateCustomer(username).setVisible(true));
        mi3.addActionListener(ae -> new ViewCustomers(username).setVisible(true));
        mi4.addActionListener(ae -> new DeleteCustomer(username).setVisible(true));


        // Packages menu
        JMenu m2 = new JMenu("PACKAGES");
        m2.setForeground(new Color(165, 42, 42));
        m2.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m2);

        JMenuItem mi6 = new JMenuItem("CHECK PACKAGE");
        mi6.setFont(new Font("Serif", Font.PLAIN, 16));
        m2.add(mi6);

        JMenuItem mi7 = new JMenuItem("BOOK PACKAGE");
        mi7.setFont(new Font("Serif", Font.PLAIN, 16));
        m2.add(mi7);

        JMenuItem mi5 = new JMenuItem("VIEW BOOKED PACKAGE");
        mi5.setFont(new Font("Serif", Font.PLAIN, 16));
        m2.add(mi5);

        mi6.addActionListener(ae -> new CheckPackage(username).setVisible(true));
        mi7.addActionListener(ae -> new BookPackage(username).setVisible(true));
        mi5.addActionListener(ae -> new ViewBookedPackage(username).setVisible(true));


        // Hotels menu
        JMenu m3 = new JMenu("HOTELS");
        m3.setForeground(new Color(0, 0, 139));
        m3.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m3);

        JMenuItem mi11 = new JMenuItem("CHECK HOTELS");
        mi11.setFont(new Font("Serif", Font.PLAIN, 16));
        m3.add(mi11);

        JMenuItem mi8 = new JMenuItem("BOOK HOTELS");
        mi8.setFont(new Font("Serif", Font.PLAIN, 16));
        m3.add(mi8);

        JMenuItem mi12 = new JMenuItem("VIEW BOOKED HOTEL");
        mi12.setFont(new Font("Serif", Font.PLAIN, 16));
        m3.add(mi12);

        mi11.addActionListener(ae -> new CheckHotels().setVisible(true));
        mi8.addActionListener(ae -> new BookHotel(username).setVisible(true));
        mi12.addActionListener(ae -> new ViewBookedHotel(username).setVisible(true));

        
        // Flights menu
        JMenu m8 = new JMenu("FLIGHTS");
        m8.setForeground(new Color(0, 0, 139));
        m8.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m8);

        JMenuItem mi10 = new JMenuItem("BOOK FLIGHT");
        mi10.setFont(new Font("Serif", Font.PLAIN, 16));
        m8.add(mi10);

        JMenuItem mi9 = new JMenuItem("VIEW BOOKED FLIGHTS");
        mi9.setFont(new Font("Serif", Font.PLAIN, 16));
        m8.add(mi9);

        mi9.addActionListener(ae -> new ViewBookedFlight(username).setVisible(true));
        mi10.addActionListener(ae -> new BookFlight(username).setVisible(true));


        // Destination menu
        JMenu m4 = new JMenu("DESTINATION");
        m4.setForeground(new Color(165, 42, 42));
        m4.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m4);

        JMenuItem mi13 = new JMenuItem("DESTINATION");
        mi13.setFont(new Font("Serif", Font.PLAIN, 16));
        m4.add(mi13);

        mi13.addActionListener(ae -> new Destination().setVisible(true));


        // Payment menu
        JMenu m5 = new JMenu("PAYMENT");
        m5.setForeground(new Color(0, 0, 139));
        m5.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m5);

        JMenuItem mi14 = new JMenuItem("PAY USING PAYTM");
        mi14.setFont(new Font("Serif", Font.PLAIN, 16));
        m5.add(mi14);

        mi14.addActionListener(ae -> new Payment().setVisible(true));


        // Utility menu
        JMenu m6 = new JMenu("UTILITY");
        m6.setForeground(new Color(165, 42, 42));
        m6.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m6);

        JMenuItem mi15 = new JMenuItem("NOTEPAD");
        mi15.setFont(new Font("Serif", Font.PLAIN, 16));
        m6.add(mi15);

        JMenuItem mi16 = new JMenuItem("CALCULATOR");
        mi16.setFont(new Font("Serif", Font.PLAIN, 16));
        m6.add(mi16);

        mi15.addActionListener(ae -> {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mi16.addActionListener(ae -> {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        

        // About menu
        JMenu m7 = new JMenu("ABOUT");
        m7.setForeground(new Color(0, 0, 139));
        m7.setFont(new Font("Serif", Font.BOLD, 18));
        menuBar.add(m7);

        JMenuItem mi17 = new JMenuItem("ABOUT");
        mi17.setFont(new Font("Serif", Font.PLAIN, 16));
        m7.add(mi17);

        mi17.addActionListener(ae -> new About().setVisible(true));

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        getContentPane().setBackground(new Color(255, 255, 255));
    }
}
