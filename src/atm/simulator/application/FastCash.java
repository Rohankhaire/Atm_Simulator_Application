package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends ATMPageTemplate implements ActionListener {

    JButton b100, b500, b1000, b2000, b5000, backBtn;
    String pin, cardno;

    public FastCash(String pin, String cardno) {
        super();
        this.pin = pin;
        this.cardno = cardno;

        JLabel label = new JLabel("Select Fast Cash Amount");
        label.setBounds(200, 300, 400, 30);
        label.setFont(new Font("System", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        image.add(label);

        b100 = new JButton("Rs 100");
        b500 = new JButton("Rs 500");
        b1000 = new JButton("Rs 1000");
        b2000 = new JButton("Rs 2000");
        b5000 = new JButton("Rs 5000");
        backBtn = new JButton("Back");

        JButton[] arr = {b100, b500, b1000, b2000, b5000, backBtn};
        int y = 415;
        for (JButton btn : arr) {
            btn.setBounds((btn == backBtn ? 355 : 170), y, 150, 30);
            btn.addActionListener(this);
            image.add(btn);
            if (btn != b500) y += 35;
        }
    }

    public void withdraw(int amount) throws Exception {
        Conn c = new Conn();

        ResultSet rs = c.s.executeQuery("SELECT SUM(CASE WHEN type='Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE cardno='" + cardno + "'");
        int balance = 0;
        if (rs.next()) balance = rs.getInt("balance");

        if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        }

        c.s.executeUpdate("INSERT INTO bank (cardno, pin, type, amount) VALUES ('" 
                          + cardno + "', '" + pin + "', 'Withdrawal', '" + amount + "')");

        JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn Successfully");
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b100) withdraw(100);
            else if (ae.getSource() == b500) withdraw(500);
            else if (ae.getSource() == b1000) withdraw(1000);
            else if (ae.getSource() == b2000) withdraw(2000);
            else if (ae.getSource() == b5000) withdraw(5000);
            else if (ae.getSource() == backBtn) {
                setVisible(false);
                new Transaction(pin, cardno).setVisible(true);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
