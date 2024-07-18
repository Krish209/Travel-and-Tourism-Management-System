package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckHotels extends JFrame implements Runnable {

    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, caption;
    Thread th;

    public void run() {
        try {
            String[] hotelNames = {
                "JW Marriott Hotel",
                "Mandarin Oriental Hotel",
                "Four Seasons Hotel",
                "Radisson Hotel",
                "Classio Hotel",
                "The Bay Club Hotel",
                "Breeze Blows Hotel",
                "Quick Stop Hotel",
                "Happy Mornings Motel",
                "Moss View Hotel"
            };
            
            JLabel[] hotelLabels = {l2, l3, l4, l5, l6, l7, l8, l9, l10, l11};

            for (int i = 0; i < hotelLabels.length; i++) {
                hotelLabels[i].setVisible(true);
                caption.setText(hotelNames[i]);
                hotelLabels[i].add(caption);
                Thread.sleep(2800);
                hotelLabels[i].setVisible(false);
            }

            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CheckHotels() {

        setBounds(400, 60, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        
        th = new Thread(this);

        caption = new JLabel();
        caption.setBounds(50, 550, 1000, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);

        setLayout(null);

        l2 = createLabel("hotel1.jpg");
        l3 = createLabel("hotel2.jpg");
        l4 = createLabel("hotel3.jpg");
        l5 = createLabel("hotel4.jpg");
        l6 = createLabel("hotel5.jpg");
        l7 = createLabel("hotel6.jpg");
        l8 = createLabel("hotel7.jpg");
        l9 = createLabel("hotel8.jpg");
        l10 = createLabel("hotel9.jpg");
        l11 = createLabel("hotel10.jpg");

        th.start();
    }

    private JLabel createLabel(String imagePath) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/images/" + imagePath));
        Image img = icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0, 0, 900, 700);
        add(label);
        label.setVisible(false);
        return label;
    }

    public static void main(String args[]) {
        new CheckHotels().setVisible(true);
    }
}
