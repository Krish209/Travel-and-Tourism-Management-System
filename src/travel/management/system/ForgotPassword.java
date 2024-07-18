package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class ForgotPassword extends JFrame implements ActionListener {

    JPanel p1, p2;
    JLabel lblusername, lblname, lblquestion, lblanswer, lblpassword, image, text;
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    JSeparator titleBarSeparator;

    ForgotPassword() {
        setTitle("Forgot Password");
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
        p1.setBackground(new Color(115, 230, 0));
        p1.setLayout(null);
        add(p1);

        lblusername = new JLabel("Username");
        lblusername.setForeground(Color.BLUE);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBackground(new Color(51, 255, 255));
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(tfusername);

        lblname = new JLabel("Name");
        lblname.setForeground(Color.BLUE);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBackground(new Color(51, 255, 255));
        tfname.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(tfname);

        lblquestion = new JLabel("Security Question");
        lblquestion.setForeground(Color.BLUE);
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBackground(new Color(51, 255, 255));
        tfquestion.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(tfquestion);

        lblanswer = new JLabel("Answer");
        lblanswer.setForeground(Color.BLUE);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBackground(new Color(51, 255, 255));
        tfanswer.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(tfanswer);

        lblpassword = new JLabel("Password");
        lblpassword.setForeground(Color.BLUE);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBackground(new Color(51, 255, 255));
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        p1.add(tfpassword);

        search = new JButton("Search");
        search.setBackground(new Color(230, 130, 0));
        search.setForeground(Color.WHITE);
        search.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        search.setBorder(new LineBorder(new Color(230, 130, 0)));
        search.setFocusPainted(false);
        search.addActionListener(this);
        addHoverEffect1(search);
        p1.add(search);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(new Color(230, 130, 0));
        retrieve.setForeground(Color.WHITE);
        retrieve.setBorder(new LineBorder(new Color(230, 130, 0)));
        retrieve.setFocusPainted(false);
        retrieve.addActionListener(this);
        addHoverEffect1(retrieve);
        p1.add(retrieve);

        back = new JButton("Back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLUE));
        back.setFocusPainted(false);
        back.addActionListener(this);
        addHoverEffect(back);
        p1.add(back);

        // Panel 2 (Image)
        p2 = new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setPreferredSize(new Dimension(450, 500));
        p2.setLayout(null);
        add(p2);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/forgot4.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
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
        p1.setBounds(-10, 2, 545, height - 2);

        lblusername.setBounds(60, 20, 150, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfusername.setBounds(60, 50, 320, 30);
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 18));
        search.setBounds(400, 50, 100, 30);
        search.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        
        lblname.setBounds(60, 95, 150, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfname.setBounds(60, 125, 320, 30);
        tfname.setFont(new Font("SERIF", Font.PLAIN, 18));
        
        lblquestion.setBounds(60, 170, 200, 25);
        lblquestion.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfquestion.setBounds(60, 200, 320, 30);
        tfquestion.setFont(new Font("SERIF", Font.PLAIN, 18));
        
        lblanswer.setBounds(60, 245, 150, 25);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfanswer.setBounds(60, 275, 320, 30);
        tfanswer.setFont(new Font("SERIF", Font.PLAIN, 18));
        
        retrieve.setBounds(400, 275, 100, 30);
        retrieve.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        
        lblpassword.setBounds(60, 320, 150, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tfpassword.setBounds(60, 350, 320, 30);
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 18));
        
        back.setBounds(160, 405, 120, 35);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        
        // Panel 2
        p2.setBounds(545, 2, 450, 500);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/forgot4.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        p2.add(image, BorderLayout.CENTER);
        
        image.setBounds(20, 55, 300, 300);
    }

    private void resizeComponentsMaximized() {
        int width = getWidth();
        int height = getHeight();

        // Title bar separator
        titleBarSeparator.setBounds(0, 0, width, 2);

        // Panel 1
        p1.setBounds(0, 2, width / 2 + 120, height - 2);

        lblusername.setBounds(80, 60, width / 2 - 200, 40);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfusername.setBounds(80, 105, width / 2 - 200, 40);
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 22));
        search.setBounds(680, 98, 140, 50);
        search.setFont(new Font("SAN_SERIF", Font.BOLD, 30));

        lblname.setBounds(80, 180, width / 2 - 200, 40);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfname.setBounds(80, 225, width / 2 - 200, 40);
        tfname.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfname.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblquestion.setBounds(80, 300, width / 2 - 200, 40);
        lblquestion.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfquestion.setBounds(80, 345, width / 2 - 200, 40);
        tfquestion.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfquestion.setFont(new Font("SERIF", Font.PLAIN, 22));

        lblanswer.setBounds(80, 420, width / 2 - 200, 40);
        lblanswer.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfanswer.setBounds(80, 465, width / 2 - 200, 40);
        tfanswer.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfanswer.setFont(new Font("SERIF", Font.PLAIN, 22));

        retrieve.setBounds(680, 460, 140, 50);
        retrieve.setFont(new Font("SAN_SERIF", Font.BOLD, 30));

        lblpassword.setBounds(80, 540, width / 2 - 200, 40);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        tfpassword.setBounds(80, 585, width / 2 - 200, 40);
        tfpassword.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(153, 0, 153)));
        tfpassword.setFont(new Font("SERIF", Font.PLAIN, 22));

        back.setBounds(300, 665, 140, 50);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 30));

        // Panel 2
        p2.setBounds(width / 2 + 100, 2, width / 2, height - 2);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/forgot4.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        p2.add(image, BorderLayout.CENTER);
        image.setBounds((width / 2 - 360) / 2, (height - 360) / 2, 600, 600);
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

    private void addHoverEffect1(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(230, 130, 0));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(230, 130, 0));
                button.setForeground(Color.WHITE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String username = tfusername.getText();
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM account WHERE username = ?";

                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            String answer = tfanswer.getText();
            String username = tfusername.getText();
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM account WHERE username = ? AND answer = ?";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, answer);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid answer");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgotPassword();
    }
}
