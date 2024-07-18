package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    JPanel p1, p2;
    JLabel lblusername, lblname, lblpassword, lblsecurity, lblanswer, image, text;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    JComboBox<String> securityQuestionCombo;
    JButton create, back;
    JSeparator titleBarSeparator;

    public Signup() {
        setTitle("Signup");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        // Title bar separator
        titleBarSeparator = new JSeparator();
        titleBarSeparator.setBackground(Color.BLACK);
        titleBarSeparator.setForeground(Color.BLACK);
        add(titleBarSeparator);

        // Panel 1 (Content)
        p1 = new JPanel();
        p1.setBackground(Color.YELLOW);
        p1.setLayout(null);
        add(p1, BorderLayout.WEST);

        lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblusername.setForeground(Color.BLUE);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBackground(new Color(51, 255, 255));
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfusername);

        lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblname.setForeground(Color.BLUE);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBackground(new Color(51, 255, 255));
        tfname.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfname.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfname);

        lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblpassword.setForeground(Color.BLUE);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBackground(new Color(51, 255, 255));
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfpassword);

        lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblsecurity.setForeground(Color.BLUE);
        p1.add(lblsecurity);

        securityQuestionCombo = new JComboBox<>(new String[]{"Your Nickname?", "Your Lucky Number?", "Your Child Superhero?", "Your Childhood Name?"});
        securityQuestionCombo.setBackground(new Color(51, 255, 255));
        securityQuestionCombo.setFont(new Font("SERIF", Font.PLAIN, 18));
        securityQuestionCombo.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(securityQuestionCombo);

        lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblanswer.setForeground(Color.BLUE);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBackground(new Color(51, 255, 255));
        tfanswer.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfanswer.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(Color.BLUE);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        create.setBorder(new LineBorder(Color.BLUE));
        create.setFocusPainted(false);
        create.addActionListener(this);
        addHoverEffect(create);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        back.setBorder(new LineBorder(Color.BLUE));
        back.setFocusPainted(false);
        back.addActionListener(this);
        addHoverEffect(back);
        p1.add(back);

        // Panel 2 (Image)
        p2 = new JPanel();
        p2.setBackground(new Color(0, 255, 0));
        p2.setPreferredSize(new Dimension(450, 500));
        p2.setLayout(null);
        add(p2, BorderLayout.EAST);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        p2.add(image, BorderLayout.CENTER);

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
        resizeComponentsNormal(); // Initial layout setup
    }

    private void resizeComponentsNormal() {
        int width = getWidth();
        int height = getHeight();

        // Title bar separator
        titleBarSeparator.setBounds(0, 0, width, 2);

        // Panel 1
        p1.setBounds(0, 2, 450, height - 2);

        lblusername.setBounds(60, 20, 150, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfusername.setBounds(60, 50, 320, 30);
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 18));

        lblname.setBounds(60, 95, 150, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfname.setBounds(60, 125, 320, 30);
        tfname.setFont(new Font("SERIF", Font.PLAIN, 18));

        lblpassword.setBounds(60, 170, 150, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfpassword.setBounds(60, 200, 320, 30);
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 18));

        lblsecurity.setBounds(60, 245, 200, 25);
        lblsecurity.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        securityQuestionCombo.setBounds(60, 275, 320, 30);
        securityQuestionCombo.setFont(new Font("SERIF", Font.PLAIN, 18));

        lblanswer.setBounds(60, 320, 150, 25);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfanswer.setBounds(60, 350, 320, 30);
        tfanswer.setFont(new Font("SERIF", Font.PLAIN, 18));

        create.setBounds(60, 405, 120, 35);
        create.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        back.setBounds(260, 405, 120, 35);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 18));

        // Panel 2
        p2.setBounds(450, 2, 450, 500);
        image.setBounds(40, 50, 360, 360);
    }

    private void resizeComponentsMaximized() {
        int width = getWidth();
        int height = getHeight();

        // Title bar separator
        titleBarSeparator.setBounds(0, 0, width, 2);

        // Panel 1
        p1.setBounds(0, 2, width / 2, height - 2);

        lblusername.setBounds(80, 60, width / 2 - 200, 40);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfusername.setBounds(80, 105, width / 2 - 200, 40);
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblname.setBounds(80, 180, width / 2 - 200, 40);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfname.setBounds(80, 225, width / 2 - 200, 40);
        tfname.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfname.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblpassword.setBounds(80, 300, width / 2 - 200, 40);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfpassword.setBounds(80, 345, width / 2 - 200, 40);
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblsecurity.setBounds(80, 420, width / 2 - 200, 40);
        lblsecurity.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        securityQuestionCombo.setBounds(80, 465, width / 2 - 200, 40);
        securityQuestionCombo.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        securityQuestionCombo.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblanswer.setBounds(80, 540, width / 2 - 200, 40);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfanswer.setBounds(80, 585, width / 2 - 200, 40);
        tfanswer.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfanswer.setFont(new Font("SERIF", Font.PLAIN, 22));

        create.setBounds(160, 675, 150, 45);
        create.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        back.setBounds(410, 675, 150, 45);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 20));

        // Panel 2
        p2.setBounds(width / 2, 2, width / 2, height - 2);
        image.setBounds((width / 2 - 350) / 2, (height - 350) / 2, 360, 360);
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
        if (ae.getSource() == create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = (String) securityQuestionCombo.getSelectedItem();
            String answer = tfanswer.getText();
    
            // Check for empty fields
            if (username.isEmpty() || name.isEmpty() || password.isEmpty() || question.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String query = "insert into account (username, name, password, security, answer) values('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
    
                JOptionPane.showMessageDialog(null, "Account created successfully");
    
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,  "Error creating account: ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
       
    public static void main(String[] args) {
        new Signup();
    }
}
