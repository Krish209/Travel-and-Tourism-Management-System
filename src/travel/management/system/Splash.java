package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow implements Runnable {
    Thread thread;

    Splash() {
        ImageIcon i1 = new ImageIcon(
                getClass().getClassLoader().getResource("Travel/Management/System/images/image1.png"));
        Image i2 = i1.getImage().getScaledInstance(790, 660, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        // image.setBounds(100, 500, 790, 660);
        add(image);

        setVisible(true);
        // new Conn();
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Splash splash = new Splash();

        int x = 1;
        for (int i = 1; i < 400; i += 6) {
            splash.setLocation(900 - x, 580 - x);
            splash.setSize(2 * i - 30, 9 * i / 5 - 90);
            x += 8;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
