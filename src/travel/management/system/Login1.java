package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login1 extends JFrame {

    JPanel p1, p2;
    JLabel lblusername, lblpassword, image, text;
    JTextField tfusername, tfpassword;
    JButton login, signup, fpassword;

    Login1() {
        setTitle("Login");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.WHITE);

        // Panel 1
        p1 = new JPanel();
        p1.setBackground(new Color(51, 153, 255));
        p1.setPreferredSize(new Dimension(450, 400));
        p1.setLayout(new BorderLayout());
        add(p1, BorderLayout.WEST);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/login2.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        p1.add(image, BorderLayout.CENTER);

        // Panel 2
        p2 = new JPanel();
        p2.setBackground(new Color(255, 255, 255));
        p2.setPreferredSize(new Dimension(450, 400));
        p2.setLayout(null);
        add(p2, BorderLayout.CENTER);

        lblusername = new JLabel("Username");
        lblusername.setBounds(60, 30, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblusername.setForeground(new Color(51, 153, 255));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 55, 320, 30);
        tfusername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 153, 255)));
        p2.add(tfusername);

        lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 120, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblpassword.setForeground(new Color(51, 153, 255));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 145, 320, 30);
        tfpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 153, 255)));
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(51, 153, 255));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(250, 200, 130, 30);
        signup.setBackground(new Color(51, 153, 255));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(signup);

        fpassword = new JButton("Forget Password");
        fpassword.setBounds(145, 250, 140, 30);
        fpassword.setBackground(new Color(51, 153, 255));
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(fpassword);

        text = new JLabel("Trouble in login...");
        text.setBounds(145, 300, 320, 20);
        text.setFont(new Font("SAN_SERIF", Font.ITALIC, 16));
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login1();
    }
}
