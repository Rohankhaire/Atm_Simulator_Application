package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton saving, current, fixed, recurring;
    JCheckBox atmCard, internetBanking, mobileBanking, smsAlert, chequeBook, eStatement;
    JButton submit, cancel;
    String formno;

    public SignUpThree(String formno) {
        this.formno = formno;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);

        JLabel heading = new JLabel("Page 3 : Account Details");
        heading.setFont(new Font("Raleway", Font.BOLD, 24));
        heading.setBounds(250, 30, 400, 40);
        add(heading);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(100, 140, 200, 20);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBounds(350, 140, 200, 20);
        add(current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(100, 170, 200, 20);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(350, 170, 250, 20);
        add(recurring);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(saving);
        accGroup.add(current);
        accGroup.add(fixed);
        accGroup.add(recurring);

        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 220, 300, 30);
        add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(100, 260, 200, 20);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(350, 260, 200, 20);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(100, 290, 200, 20);
        add(mobileBanking);

        smsAlert = new JCheckBox("SMS Alerts");
        smsAlert.setBounds(350, 290, 200, 20);
        add(smsAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(100, 320, 200, 20);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBounds(350, 320, 200, 20);
        add(eStatement);

        submit = new JButton("Submit");
        submit.setBounds(250, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 400, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 600);
        setLocation(350, 80);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String accType = null;
            if (saving.isSelected()) accType = "Saving Account";
            else if (current.isSelected()) accType = "Current Account";
            else if (fixed.isSelected()) accType = "Fixed Deposit Account";
            else if (recurring.isSelected()) accType = "Recurring Deposit Account";

            if (accType == null) {
                JOptionPane.showMessageDialog(null, "Select Account Type");
                return;
            }

            // Generate card no and pin
            Random ran = new Random();
            String cardno = "" + (Math.abs(ran.nextLong()) % 90000000L + 5040936000000000L);
            String pin = "" + (ran.nextInt(9000) + 1000);

            // Collect services
            String facility = "";
            if (atmCard.isSelected()) facility += "ATM Card ";
            if (internetBanking.isSelected()) facility += "Internet Banking ";
            if (mobileBanking.isSelected()) facility += "Mobile Banking ";
            if (smsAlert.isSelected()) facility += "SMS Alerts ";
            if (chequeBook.isSelected()) facility += "Cheque Book ";
            if (eStatement.isSelected()) facility += "E-Statement ";

            try {
                Conn c = new Conn();

                String q1 = "INSERT INTO signupthree (formno, accounttype, cardno, pin, facility) " +
                        "VALUES ('" + formno + "', '" + accType + "', '" + cardno + "', '" + pin + "', '" + facility + "')";

                String login = "INSERT INTO login (formno, cardno, pin) VALUES ('" + formno + "', '" + cardno + "', '" + pin + "')";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(login);

                JOptionPane.showMessageDialog(null,
                        "Your Account has been created!\nCard Number: " + cardno + "\nPIN: " + pin);

//                setVisible(false);
//                new Deposit(pin).setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
        else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("1234");
    }
}
