package travel.management.system;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Destination extends JFrame implements Runnable {

    private List<ImageIcon> icons;
    private List<JLabel> labels;
    private Thread th;

    public Destination() {
        initializeUI();
        loadImages();
        startThread();
    }

    private void initializeUI() {
        setTitle("Destination Images");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        labels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel();
            label.setBounds(0, 0, 900, 700);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            labels.add(label);
            panel.add(label);
            label.setVisible(false);
        }

        setVisible(true);
    }

    private void loadImages() {
        String[] extensions = {".jpg", ".png", ".jpeg"};
        icons = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            boolean imageLoaded = false;
            for (String ext : extensions) {
                String imagePath = "/travel/management/system/images/dest" + i + ext;
                URL imageUrl = getClass().getResource(imagePath);
                if (imageUrl != null) {
                    ImageIcon icon = new ImageIcon(imageUrl);
                    Image image = icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
                    icons.add(new ImageIcon(image));
                    imageLoaded = true;
                    break;
                }
            }
            if (!imageLoaded) {
                System.out.println("Image not found for dest" + i + " with any extension");
            }
        }
    }

    private void startThread() {
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < labels.size(); i++) {
                    final int index = i;
                    SwingUtilities.invokeLater(() -> {
                        labels.get(index).setIcon(icons.get(index));
                        labels.get(index).setVisible(true);
                    });
                    Thread.sleep(2800);
                    SwingUtilities.invokeLater(() -> labels.get(index).setVisible(false));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Destination::new);
    }
}
