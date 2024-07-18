package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname, image;
    JTextField tfid, tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfgender;
    JButton update, back;

    UpdateCustomer(String username) {
        setTitle("Update Customer");
        setBounds(350, 140, 850, 550);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 240, 240));

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(40, 20, 400, 30);
        text.setForeground(new Color(70, 130, 180));
        text.setFont(new Font("Verdana", Font.BOLD, 22));
        add(text);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(50, 70, 170, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(160, 70, 230, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 110, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(160, 110, 230, 25);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel lblid = new JLabel("ID Type:");
        lblid.setBounds(50, 150, 170, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(160, 150, 230, 25);
        tfid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfid.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfid);

        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setBounds(50, 190, 170, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(160, 190, 230, 25);
        tfnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfnumber.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfnumber);

        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(50, 230, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(160, 230, 230, 25);
        tfgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfgender.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfgender);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(50, 270, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(160, 270, 230, 25);
        tfcountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfcountry.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 310, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(160, 310, 230, 25);
        tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfaddress.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(50, 350, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(160, 350, 230, 25);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfphone.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 390, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(160, 390, 230, 25);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfemail.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 0, 153)));
        add(tfemail);

        update = new JButton("Update");
        update.setBounds(70, 450, 100, 35);
        update.setBackground(new Color(70, 130, 180)); // Steel blue color
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 18));
        update.setBorder(new LineBorder(new Color(70, 130, 180)));
        update.setFocusPainted(false);
        update.addActionListener(this);
        addHoverEffect(update);
        add(update);

        back = new JButton("Back");
        back.setBounds(230, 450, 100, 35);
        back.setBackground(new Color(70, 130, 180)); // Steel blue color
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBorder(new LineBorder(new Color(70, 130, 180)));
        back.setFocusPainted(false);
        back.addActionListener(this);
        addHoverEffect(back);
        add(back);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("travel/management/system/images/updatecustomer3.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(450, 50, 350, 400);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id_type"));
                tfnumber.setText(rs.getString("id_number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching customer details");
            e.printStackTrace();
        }

        setVisible(true);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(70, 130, 180));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
                button.setForeground(Color.WHITE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String username = labelusername.getText();
            String idType = tfid.getText();
            String idNumber = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE customer SET id_type = ?, id_number = ?, gender = ?, country = ?, address = ?, phone = ?, email = ? WHERE username = ?";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, idType);
                pstmt.setString(2, idNumber);
                pstmt.setString(3, gender);
                pstmt.setString(4, country);
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, username);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully!");
                setVisible(false);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating customer details");
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            // new Dashboard().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
