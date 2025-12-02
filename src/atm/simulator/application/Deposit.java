package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Deposit extends ATMPageTemplate implements ActionListener {

    JTextField amountField;
    JButton depositBtn, backBtn;
    String pin, cardno;

    public Deposit(String pin, String cardno) {
        super();
        this.pin = pin;
        this.cardno = cardno;

        JLabel text = new JLabel("Enter Amount to Deposit");
        text.setBounds(200, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);

        amountField = new JTextField();
        amountField.setBounds(180, 350, 320, 30);
        amountField.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(amountField);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(355, 485, 150, 30);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(170, 485, 150, 30);
        backBtn.addActionListener(this);
        image.add(backBtn);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountField.getText();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter amount to deposit");
                return;
            }

            Conn c = new Conn();
            String query = "INSERT INTO bank (cardno, pin, type, amount) VALUES ('" 
                            + cardno + "', '" + pin + "', 'Deposit', '" + amount + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited Successfully");

            setVisible(false);
            new Transaction(pin, cardno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
