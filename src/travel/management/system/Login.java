package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {

    JPanel p1, p2;
    JLabel lblusername, lblpassword, image, text;
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton login, signup, fpassword;
    JSeparator titleBarSeparator;

    Login() {
        setTitle("Login");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        // Title bar separator
        titleBarSeparator = new JSeparator();
        titleBarSeparator.setBackground(Color.BLACK);
        titleBarSeparator.setForeground(Color.BLACK);
        add(titleBarSeparator);

        // Panel 1
        p1 = new JPanel();
        p1.setBackground(new Color(0, 255, 0));
        p1.setPreferredSize(new Dimension(450, 400));
        p1.setLayout(null);
        add(p1, BorderLayout.WEST);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/login2.png"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        p1.add(image, BorderLayout.CENTER);

        // Panel 2
        p2 = new JPanel();
        p2.setBackground(Color.YELLOW);
        p2.setLayout(null);
        add(p2);

        lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblusername.setForeground(Color.BLUE);
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBackground(new Color(51, 255, 255));
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p2.add(tfusername);

        lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblpassword.setForeground(Color.BLUE);
        p2.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBackground(new Color(51, 255, 255));
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(Color.BLUE));
        login.setFocusPainted(false);
        login.addActionListener(this);
        login.setToolTipText("New Here, first create account using signup");
        addHoverEffect(login);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(Color.BLUE));
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        addHoverEffect(signup);
        p2.add(signup);

        fpassword = new JButton("Forget Password");
        fpassword.setBackground(Color.BLUE);
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(new LineBorder(Color.BLUE));
        fpassword.setFocusPainted(false);
        fpassword.addActionListener(this);
        addHoverEffect(fpassword);
        p2.add(fpassword);

        text = new JLabel("Trouble in login...");
        text.setFont(new Font("SAN_SERIF", Font.ITALIC, 16));
        text.setForeground(Color.RED);
        p2.add(text);

        // Add component listener for resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                    // Handle normal resizing
                    resizeComponentsNormal();
                }
            }
        });

        // Add window state listener for maximizing
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    // Handle maximizing
                    resizeComponentsMaximized();
                } else {
                    // Handle restoring from maximized
                    resizeComponentsNormal();
                }
            }
        });

        setVisible(true);
        resizeComponentsNormal();
    }

    private void resizeComponentsNormal() {
        int width = getWidth();
        int height = getHeight();

        // Title bar separator
        titleBarSeparator.setBounds(0, 0, width, 2);

        // Panel 1
        p1.setBounds(0, 2, 450, height - 2);
        image.setBounds(30, -15, 380, 380);

        // Panel 2
        p2.setBounds(450, 2, width - 450, height - 2);

        lblusername.setBounds(60, 30, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfusername.setBounds(60, 60, 320, 30);
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 18));

        lblpassword.setBounds(60, 120, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfpassword.setBounds(60, 150, 320, 30);
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 18));

        login.setBounds(60, 210, 120, 35);
        login.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        signup.setBounds(260, 210, 120, 35);
        signup.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        fpassword.setBounds(130, 260, 165, 35);
        fpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 16));

        text.setBounds(150, 310, 320, 20);
        text.setFont(new Font("Tahoma", Font.ITALIC, 16));
    }

    private void resizeComponentsMaximized() {
        int width = getWidth();
        int height = getHeight();

        // Title bar separator
        titleBarSeparator.setBounds(0, 0, width, 2);

        // Panel 1
        p1.setBounds(0, 2, width / 2, height - 2);
        image.setBounds((width / 2 - 350) / 2, (height - 350) / 2 , 350, 350);

        // Panel 2
        p2.setBounds(width / 2, 0, width / 2, height - 2);

        lblusername.setBounds(80, 200, width / 2 - 200, 40);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfusername.setBounds(80, 245, width / 2 - 200, 40);
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblpassword.setBounds(80, 320, width / 2 - 200, 40);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfpassword.setBounds(80, 365, width / 2 - 200, 40);
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 22));

        login.setBounds(160, 450, 150, 45);
        login.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        signup.setBounds(410, 450, 150, 45);
        signup.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        fpassword.setBounds(240, 530, 240, 45);
        fpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        text.setBounds(280, 590, width / 2 - 290, 30);
        text.setFont(new Font("SAN_SERIF", Font.ITALIC, 20));
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
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = new String(tfpassword.getPassword());
    
                // Check if username or password is empty
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
                    return; 
                }
    
                String query = "SELECT * FROM account WHERE username = ? AND password = ?";
                Conn c = new Conn();
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    setVisible(false);
                    new Loading(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        } else if (ae.getSource() == fpassword) {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
