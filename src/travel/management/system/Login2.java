package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login2 extends JFrame {

    JPanel p1, p2, titleBar;
    JLabel lblusername, lblpassword, image, text, titleLabel;
    JTextField tfusername, tfpassword;
    JButton login, signup, fpassword, minimizeButton, maximizeButton, closeButton;
    boolean isMaximized = false;
    int lastWidth, lastHeight, lastX, lastY;

    Login2() {
        setTitle("Login");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Custom title bar
        titleBar = new JPanel();
        titleBar.setBackground(Color.darkGray);
        titleBar.setPreferredSize(new Dimension(getWidth(), 30));
        titleBar.setLayout(new BorderLayout());

        titleLabel = new JLabel("Login");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        titleLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        titleBar.add(titleLabel, BorderLayout.WEST);

        JPanel titleButtons = new JPanel();
        titleButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        titleButtons.setOpaque(false);

        minimizeButton = createTitleButton("-");
        minimizeButton.addActionListener(e -> setState(JFrame.ICONIFIED));
        titleButtons.add(minimizeButton);

        maximizeButton = createTitleButton("[]");
        maximizeButton.addActionListener(e -> toggleMaximize());
        titleButtons.add(maximizeButton);

        closeButton = createTitleButton("X");
        closeButton.addActionListener(e -> System.exit(0));
        titleButtons.add(closeButton);

        titleBar.add(titleButtons, BorderLayout.EAST);
        add(titleBar, BorderLayout.NORTH);

        getContentPane().setBackground(Color.WHITE);

        // Panel 1
        p1 = new JPanel();
        p1.setBackground(new Color(51, 153, 255));
        p1.setPreferredSize(new Dimension(450, 450));
        p1.setLayout(new BorderLayout());
        add(p1, BorderLayout.WEST);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/login2.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
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
        lblusername.setBounds(60, 50, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblusername.setForeground(new Color(51, 153, 255));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 80, 320, 30);
        tfusername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 153, 255)));
        p2.add(tfusername);

        lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 140, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblpassword.setForeground(new Color(51, 153, 255));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 170, 320, 30);
        tfpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 153, 255)));
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 230, 140, 30);
        login.setBackground(new Color(51, 153, 255));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(240, 230, 140, 30);
        signup.setBackground(new Color(51, 153, 255));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(signup);

        fpassword = new JButton("Forget Password");
        fpassword.setBounds(145, 280, 140, 30);
        fpassword.setBackground(new Color(51, 153, 255));
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(new LineBorder(new Color(51, 153, 255)));
        p2.add(fpassword);

        text = new JLabel("Trouble in login...");
        text.setBounds(145, 330, 320, 20);
        text.setFont(new Font("SAN_SERIF", Font.ITALIC, 16));
        text.setForeground(Color.RED);
        p2.add(text);

        // Adding resize listener to handle component resizing
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                resizeComponents();
            }
        });

        // Draggable title bar
        MouseAdapter ma = new MouseAdapter() {
            Point mouseDownCompCoords = null;

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        };
        titleBar.addMouseListener(ma);
        titleBar.addMouseMotionListener(ma);

        setVisible(true);
    }

    private JButton createTitleButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(45, 30));
        button.setFocusPainted(false);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.WHITE);
        button.setBorder(null);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(31, 123, 205));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.darkGray);
            }
        });
        return button;
    }

    private void resizeComponents() {
        Dimension size = getSize();
        int p1Width = size.width / 2;
        p1.setPreferredSize(new Dimension(p1Width, size.height));

        int componentWidth = p1Width - 150;
        image.setBounds(75, 50, componentWidth, componentWidth);

        p2.setPreferredSize(new Dimension(size.width - p1Width, size.height));
        lblusername.setBounds(70, 50, 100, 25);
        tfusername.setBounds(70, 80, componentWidth, 30);

        lblpassword.setBounds(70, 140, 100, 25);
        tfpassword.setBounds(70, 170, componentWidth, 30);

        login.setBounds(70, 230, 140, 30);
        signup.setBounds(250, 230, 140, 30);
        fpassword.setBounds(160, 280, 150, 30);

        text.setBounds(250, 330, 200, 20);
    }

    private void toggleMaximize() {
        if (isMaximized) {
            setBounds(lastX, lastY, lastWidth, lastHeight);
        } else {
            lastWidth = getWidth();
            lastHeight = getHeight();
            lastX = getX();
            lastY = getY();
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        isMaximized = !isMaximized;
    }

    public static void main(String[] args) {
        new Login2();
    }
}
