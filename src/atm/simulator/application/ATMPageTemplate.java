package atm.simulator.application;

import javax.swing.*;
import java.awt.*;

public class ATMPageTemplate extends JFrame {
    public JLabel image;

    public ATMPageTemplate() {
        setLayout(null);

        // Load ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Window settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);   // removes title bar (ATM machine style)
        setVisible(true);
    }

    // ONLY for testing. Otherwise REMOVE main().
    public static void main(String[] args) {
        new ATMPageTemplate();
    }
}
