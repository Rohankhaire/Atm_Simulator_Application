package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BalanceInquiry extends ATMPageTemplate {

    String pin, cardno;

    public BalanceInquiry(String pin, String cardno) {
        super();
        this.pin = pin;
        this.cardno = cardno;

        JLabel label = new JLabel("Your Current Balance:");
        label.setBounds(200, 300, 400, 30);
        label.setFont(new Font("System", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        image.add(label);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT SUM(CASE WHEN type='Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE cardno='" + cardno + "'");

            int balance = 0;
            if (rs.next()) balance = rs.getInt("balance");

            JLabel bal = new JLabel("₹ " + balance);
            bal.setBounds(200, 350, 400, 40);
            bal.setFont(new Font("System", Font.BOLD, 28));
            bal.setForeground(Color.GREEN);
            image.add(bal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
