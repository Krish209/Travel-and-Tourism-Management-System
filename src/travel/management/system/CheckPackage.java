package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckPackage extends JFrame implements ActionListener {

    private JButton book;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CheckPackage("").setVisible(true));
    }

    public CheckPackage(String username) {
        setTitle("Check Packages");
        setBounds(350, 100, 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] package1 = {"package1.jpeg", "GOLD PACKAGE", "6 days and 7 Nights", "Airport Assistance at Airport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "Summer Special", "Rs 12000 only"};
        String[] package2 = {"package2.3.jpeg", "SILVER PACKAGE", "4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "Winter Special", "Rs 25000 only"};
        String[] package3 = {"package2.2.jpeg", "BRONZE PACKAGE", "6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "Winter Special", "Rs 32000 only"};

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel p1 = createPackagePanel(package1);
        JPanel p2 = createPackagePanel(package2);
        JPanel p3 = createPackagePanel(package3);

        tabbedPane.addTab("Gold Package", null, p1);
        tabbedPane.addTab("Silver Package", null, p2);
        tabbedPane.addTab("Bronze Package", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createPackagePanel(String[] pack) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/" + pack[0]));
        Image image = icon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        panel.add(imageLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.add(detailsPanel, BorderLayout.CENTER);

        JLabel nameLabel = new JLabel(pack[1]);
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
        nameLabel.setForeground(new Color(0, 102, 153));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(nameLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel durationLabel = new JLabel(pack[2]);
        durationLabel.setFont(new Font("Serif", Font.ITALIC, 24));
        durationLabel.setForeground(new Color(204, 0, 0));
        durationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(durationLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        for (int i = 3; i < pack.length - 2; i++) {
            JLabel detailLabel = new JLabel(pack[i]);
            detailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            detailLabel.setForeground(i % 2 == 0 ? new Color(0, 102, 102) : new Color(0, 0, 255));
            detailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailsPanel.add(detailLabel);
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JLabel specialLabel = new JLabel(pack[pack.length - 2]);
        specialLabel.setFont(new Font("Arial", Font.BOLD, 25));
        specialLabel.setForeground(new Color(204, 0, 204));
        specialLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(specialLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel priceLabel = new JLabel(pack[pack.length - 1]);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 26));
        priceLabel.setForeground(new Color(255, 153, 0));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(priceLabel);
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        book = new JButton("BOOK NOW");
        book.setBounds(60, 210, 120, 35);
        book.setFont(new Font("Serif", Font.BOLD, 25));
        book.setBackground(Color.BLUE);
        book.setForeground(Color.WHITE);
        book.setFocusPainted(false);
        book.setAlignmentX(Component.CENTER_ALIGNMENT);
        book.addActionListener(this);
        addHoverEffect(book);
        book.setToolTipText("Click to book packages");

        detailsPanel.add(book);

        return panel;
    }

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == book) {
            setVisible(false);
            new BookPackage("").setVisible(true);;
        }
    }
}
