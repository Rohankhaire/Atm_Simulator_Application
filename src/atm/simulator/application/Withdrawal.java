package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawal extends ATMPageTemplate implements ActionListener {

    JTextField amountField;
    JButton withdrawBtn, backBtn;
    String pin, cardno;

    public Withdrawal(String pin, String cardno) {
        super();
        this.pin = pin;
        this.cardno = cardno;

        JLabel text = new JLabel("Enter Amount to Withdraw");
        text.setBounds(200, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);

        amountField = new JTextField();
        amountField.setBounds(180, 350, 320, 30);
        amountField.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(amountField);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(355, 485, 150, 30);
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(170, 485, 150, 30);
        backBtn.addActionListener(this);
        image.add(backBtn);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backBtn) {
            setVisible(false);
            new Transaction(pin, cardno).setVisible(true);
            return;
        }

        String amount = amountField.getText();

        try {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("SELECT SUM(CASE WHEN type='Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE cardno='" + cardno + "' AND pin='" + pin + "'");
            int balance = 0;
            if (rs.next()) balance = rs.getInt("balance");

            if (Integer.parseInt(amount) > balance) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            c.s.executeUpdate("INSERT INTO bank (cardno, pin, type, amount) VALUES ('" 
                              + cardno + "', '" + pin + "', 'Withdrawal', '" + amount + "')");

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn Successfully");

            setVisible(false);
            new Transaction(pin, cardno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
