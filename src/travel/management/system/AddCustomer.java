package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddCustomer extends JFrame implements ActionListener {

    JPanel p1, p2;
    JLabel lblusername, lblid, lblnumber, lblname, lblgender, lblcountry, lbladdress, lblphone, lblemail, image;
    JTextField tfusername, tfnumber, tfname, tfcountry, tfaddress, tfphone, tfemail;
    JComboBox<String> idComboBox;
    JRadioButton r1, r2;
    JButton add, back;
    JSeparator titleBarSeparator;

    public AddCustomer(String username) {
        setTitle("Add Customer");
        setSize(900, 620);
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
        add(p1);

        lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblusername.setForeground(Color.BLUE);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBackground(new Color(51, 255, 255));
        tfusername.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfusername.setFont(new Font("SERIF", Font.PLAIN, 18));
        tfusername.setText(username);
        p1.add(tfusername);

        lblid = new JLabel("ID");
        lblid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblid.setForeground(Color.BLUE);
        p1.add(lblid);

        idComboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        idComboBox.setBackground(new Color(51, 255, 255));
        idComboBox.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(idComboBox);

        lblnumber = new JLabel("ID Number");
        lblnumber.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblnumber.setForeground(Color.BLUE);
        p1.add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBackground(new Color(51, 255, 255));
        tfnumber.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfnumber.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblname.setForeground(Color.BLUE);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBackground(new Color(51, 255, 255));
        tfname.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfname.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblgender.setForeground(Color.BLUE);
        p1.add(lblgender);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.YELLOW);
        r1.setFont(new Font("SERIF", Font.PLAIN, 18));
        r1.setFocusPainted(false);
        p1.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.YELLOW);
        r2.setFont(new Font("SERIF", Font.PLAIN, 18));
        r2.setFocusPainted(false);
        p1.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblcountry.setForeground(Color.BLUE);
        p1.add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBackground(new Color(51, 255, 255));
        tfcountry.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfcountry.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfcountry);

        lbladdress = new JLabel("Permanent Address");
        lbladdress.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lbladdress.setForeground(Color.BLUE);
        p1.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBackground(new Color(51, 255, 255));
        tfaddress.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfaddress.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfaddress);

        lblphone = new JLabel("Phone No.");
        lblphone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblphone.setForeground(Color.BLUE);
        p1.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBackground(new Color(51, 255, 255));
        tfphone.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfphone.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfphone);

        lblemail = new JLabel("Email Address");
        lblemail.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        lblemail.setForeground(Color.BLUE);
        p1.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBackground(new Color(51, 255, 255));
        tfemail.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));
        tfemail.setFont(new Font("SERIF", Font.PLAIN, 18));
        p1.add(tfemail);

        add = new JButton("Add");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add.setBorder(new LineBorder(Color.BLUE));
        add.setFocusPainted(false);
        add.addActionListener(this);
        addHoverEffect(add);
        p1.add(add);

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
        p2.setPreferredSize(new Dimension(450, 600));
        p2.setLayout(null);
        add(p2);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Travel/Management/System/images/addcustomer.png"));
        Image i2 = i1.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        p2.add(image);

        // Add component listener for resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponentsNormal();
            }
        });

        // Add window state listener for maximizing
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    resizeComponentsMaximized();
                } else {
                    resizeComponentsNormal();
                }
            }
        });

        resizeComponentsNormal();
        setVisible(true);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(0, 0, 128));
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.BLUE);
            }
        });
    }

    private void resizeComponentsNormal() {
        titleBarSeparator.setBounds(0, 0, getWidth(), 1);

        p1.setBounds(0, 0, 450, getHeight());
        p2.setBounds(450, 0, 450, getHeight());

        int margin = 30;
        int labelWidth = 150;
        int fieldWidth = 450 - labelWidth - 3 * margin;
        int height = 25;

        lblusername.setBounds(margin, margin, labelWidth, margin);
        tfusername.setBounds(margin + labelWidth, margin, fieldWidth, margin);

        lblid.setBounds(margin, 2 * margin + height, labelWidth, margin);
        idComboBox.setBounds(margin + labelWidth, 2 * margin + height, fieldWidth, margin + 5);
        idComboBox.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, new Color(153, 0, 153)));

        lblnumber.setBounds(margin, 3 * margin + 2 * height, labelWidth, margin);
        tfnumber.setBounds(margin + labelWidth, 3 * margin + 2 * height, fieldWidth, margin);

        lblname.setBounds(margin, 4 * margin + 3 * height, labelWidth, margin);
        tfname.setBounds(margin + labelWidth, 4 * margin + 3 * height, fieldWidth, margin);

        lblgender.setBounds(margin, 5 * margin + 4 * height, labelWidth, height);
        r1.setBounds(margin + labelWidth + 10 , 5 * margin + 4 * height, 70, height);
        r2.setBounds(margin + labelWidth + 110, 5 * margin + 4 * height, 100, height);

        lblcountry.setBounds(margin, 6 * margin + 5 * height - 5, labelWidth, margin);
        tfcountry.setBounds(margin + labelWidth, 6 * margin + 5 * height - 5, fieldWidth, margin);

        lbladdress.setBounds(margin, 7 * margin + 6 * height - 5, labelWidth, margin);
        tfaddress.setBounds(margin + labelWidth, 7 * margin + 6 * height - 5, fieldWidth, margin);

        lblphone.setBounds(margin, 8 * margin + 7 * height - 5, labelWidth, margin);
        tfphone.setBounds(margin + labelWidth, 8 * margin + 7 * height - 5, fieldWidth, margin);

        lblemail.setBounds(margin, 9 * margin + 8 * height - 5, labelWidth, margin);
        tfemail.setBounds(margin + labelWidth, 9 * margin + 8 * height -5, fieldWidth, margin);

        add.setBounds(margin + 40, 10 * margin + 9 * height, 100, margin);
        back.setBounds(3 * margin + 140, 10 * margin + 9 * height, 100, margin);

        image.setBounds(45, 100, 360, 360);
    }

    private void resizeComponentsMaximized() {
        titleBarSeparator.setBounds(0, 0, getWidth(), 1);

        p1.setBounds(0, 0, getWidth() / 2, getHeight());
        p2.setBounds(getWidth() / 2, 0, getWidth() / 2, getHeight());

        int margin = 30;
        int labelWidth = 150;
        int fieldWidth = getWidth() / 2 - labelWidth - 3 * margin;
        int height = 30;

        lblusername.setBounds(margin, margin, labelWidth, height);
        tfusername.setBounds(margin + labelWidth, margin, fieldWidth, height);

        lblid.setBounds(margin, 2 * margin + height, labelWidth, height);
        idComboBox.setBounds(margin + labelWidth, 2 * margin + height, fieldWidth, height);

        lblnumber.setBounds(margin, 3 * margin + 2 * height, labelWidth, height);
        tfnumber.setBounds(margin + labelWidth, 3 * margin + 2 * height, fieldWidth, height);

        lblname.setBounds(margin, 4 * margin + 3 * height, labelWidth, height);
        tfname.setBounds(margin + labelWidth, 4 * margin + 3 * height, fieldWidth, height);

        lblgender.setBounds(margin, 5 * margin + 4 * height, labelWidth, height);
        r1.setBounds(margin + labelWidth, 5 * margin + 4 * height, 70, height);
        r2.setBounds(margin + labelWidth + 80, 5 * margin + 4 * height, 100, height);

        lblcountry.setBounds(margin, 6 * margin + 5 * height, labelWidth, height);
        tfcountry.setBounds(margin + labelWidth, 6 * margin + 5 * height, fieldWidth, height);

        lbladdress.setBounds(margin, 7 * margin + 6 * height, labelWidth, height);
        tfaddress.setBounds(margin + labelWidth, 7 * margin + 6 * height, fieldWidth, height);

        lblphone.setBounds(margin, 8 * margin + 7 * height, labelWidth, height);
        tfphone.setBounds(margin + labelWidth, 8 * margin + 7 * height, fieldWidth, height);

        lblemail.setBounds(margin, 9 * margin + 8 * height, labelWidth, height);
        tfemail.setBounds(margin + labelWidth, 9 * margin + 8 * height, fieldWidth, height);

        add.setBounds(margin + 10, 10 * margin + 9 * height, 100, height);
        back.setBounds(3 * margin + 110, 10 * margin + 9 * height, 100, height);

        image.setBounds((p2.getWidth() - 360) / 2, (p2.getHeight() - 360) / 2, 360, 360);
    }

    private boolean checkUsernameExists(String username) {
        String query = "SELECT * FROM customer WHERE username = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //check password
             PreparedStatement pstmt = con.prepareStatement(query)) {
    
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = tfusername.getText();
            String id = (String) idComboBox.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = r1.isSelected() ? "Male" : "Female";
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
    
            // Check for empty fields
            if (username.isEmpty() || number.isEmpty() || name.isEmpty() || country.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
                return;
            }
    
            // Check if the username already exists
            if (checkUsernameExists(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please choose another username.");
                return;
            }
    
            String query = "INSERT INTO customer (username, id_type, id_number, name, gender, country, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel_Management", "root", "password"); //change password
                 PreparedStatement pstmt = con.prepareStatement(query)) {
    
                pstmt.setString(1, username);
                pstmt.setString(2, id);
                pstmt.setString(3, number);
                pstmt.setString(4, name);
                pstmt.setString(5, gender);
                pstmt.setString(6, country);
                pstmt.setString(7, address);
                pstmt.setString(8, phone);
                pstmt.setString(9, email);
    
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
    
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add customer");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
