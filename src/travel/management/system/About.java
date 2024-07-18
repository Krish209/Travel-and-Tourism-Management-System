package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    public About() {
        setTitle("About");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        JLabel titleLabel = new JLabel("About");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        titleLabel.setForeground(Color.RED);
        titleLabel.setBounds(250, 10, 180, 50);
        panel.add(titleLabel);

        JTextArea aboutText = new JTextArea();
        aboutText.setText(
                "Objective:\n"
                        + "The objective of the Travel and Tourism Management System project "
                        + "is to develop a system that automates the processes and activities "
                        + "related to travel management. This application provides users with "
                        + "information about travel destinations, facilitates tour tracking, "
                        + "and manages travel agency information.\n\n"
                        + "Advantages:\n"
                        + "- Provides accurate information\n"
                        + "- Simplifies manual work and reduces documentation\n"
                        + "- Keeps information up-to-date\n"
                        + "- Provides a friendly user interface with warning messages\n"
                        + "- Facilitates traveler details management and booking confirmation\n"
                        + "\n"
                        + "This application is developed using Java Swing for the frontend and "
                        + "MySQL for the backend database.\n\n"
                        + "Developed by: BB\n"
                        + "Version: 1.0"
        );
        aboutText.setFont(new Font("Arial", Font.PLAIN, 14));
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(aboutText);
        scrollPane.setBounds(40, 70, 500, 300);
        panel.add(scrollPane);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 400, 100, 30);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String[] args) {
        new About();
    }
}
