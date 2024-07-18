package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    Thread th;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Home(username);
                }
                Thread.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        th = new Thread(this);

        setBounds(500, 250, 600, 400);
        getContentPane().setBackground(new Color(255, 255, 0));
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setForeground(new Color(0, 0, 204));
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        text.setBounds(30, 46, 700, 35);
        add(text);

        bar = new JProgressBar();
        bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        bar.setStringPainted(true);
        bar.setForeground(new Color(0, 153, 76));
        bar.setBackground(Color.LIGHT_GRAY); 
        bar.setBounds(130, 135, 300, 25);
        add(bar);

        JLabel loading = new JLabel("Loading, Please Wait....");
        loading.setFont(new Font("Raleway", Font.BOLD, 15));
        loading.setForeground(new Color(0, 0, 0));
        loading.setBounds(200, 175, 200, 20);
        add(loading);

        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        lblusername.setForeground(new Color(180, 0, 0));
        lblusername.setBounds(20, 310, 400, 40);
        add(lblusername);

        th.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
