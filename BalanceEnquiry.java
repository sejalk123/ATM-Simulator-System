package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinchange;

    BalanceEnquiry(String pinnumber) {
        setLayout(null);
        this.pinchange = pinchange;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 740);
        add(image);

        back = new JButton("BACK");
        back.setBounds(255, 425, 140, 20);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
        text.setBounds(130, 230, 500, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 12));
        image.add(text);

        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinchange).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
