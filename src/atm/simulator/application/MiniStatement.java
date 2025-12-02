package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pin, cardno;

    public MiniStatement(String pin, String cardno) {
        this.pin = pin;
        this.cardno = cardno;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel heading = new JLabel("Mini Statement");
        heading.setBounds(100, 20, 200, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 70, 360, 400);
        add(scroll);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE cardno='" + cardno + "' ORDER BY date DESC LIMIT 10");

            while (rs.next()) {
                area.append(rs.getString("date") + "   " + rs.getString("type") + "   ₹" + rs.getInt("amount") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 500);
        setLocation(600, 200);
        setVisible(true);
    }
}
