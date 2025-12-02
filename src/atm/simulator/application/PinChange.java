package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends ATMPageTemplate implements ActionListener {

    JPasswordField t1, t2;
    JButton changeBtn, backBtn;
    String pin, cardno;

    public PinChange(String pin, String cardno) {
        super();
        this.pin = pin;
        this.cardno = cardno;

        JLabel l1 = new JLabel("NEW PIN:");
        l1.setBounds(150, 300, 200, 30);
        l1.setForeground(Color.WHITE);
        image.add(l1);

        t1 = new JPasswordField();
        t1.setBounds(300, 300, 200, 30);
        image.add(t1);

        JLabel l2 = new JLabel("Confirm PIN:");
        l2.setBounds(150, 350, 200, 30);
        l2.setForeground(Color.WHITE);
        image.add(l2);

        t2 = new JPasswordField();
        t2.setBounds(300, 350, 200, 30);
        image.add(t2);

        changeBtn = new JButton("Change PIN");
        changeBtn.setBounds(355, 485, 150, 30);
        changeBtn.addActionListener(this);
        image.add(changeBtn);

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

        String newPin = new String(t1.getPassword());
        String confirmPin = new String(t2.getPassword());

        if (!newPin.equals(confirmPin)) {
            JOptionPane.showMessageDialog(null, "PINs do not match");
            return;
        }

        try {
            Conn c = new Conn();

            c.s.executeUpdate("UPDATE login SET pin='" + newPin + "' WHERE cardno='" + cardno + "'");
            c.s.executeUpdate("UPDATE bank SET pin='" + newPin + "' WHERE cardno='" + cardno + "'");

            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

            setVisible(false);
            new Transaction(newPin, cardno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
