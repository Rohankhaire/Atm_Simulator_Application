package atm.simulator.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton Login, Clear, SignUP;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        setTitle("ATM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("osward", Font.BOLD, 38)); 
        text.setBounds(200, 40,400, 40);
        add(text); 
        
        JLabel CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Raleway", Font.BOLD, 30)); 
        CardNo.setBounds(120, 150,300, 40);
        add(CardNo); 
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150, 230 ,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD ,14));
        cardTextField.setBackground(Color.BLACK);
        cardTextField.setForeground(Color.WHITE);
        add(cardTextField);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 28)); 
        Pin.setBounds(120, 220,400, 40);
        add(Pin); 
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220, 230 ,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD ,14));
        pinTextField.setBackground(Color.BLACK);
        pinTextField.setForeground(Color.WHITE);
        add(pinTextField);
        
        Login = new JButton("Sign In");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLUE);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        Clear = new JButton("Clear");
        Clear.setBounds(430, 300, 100, 30);
        Clear.setBackground(Color.BLUE);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);
        
        SignUP = new JButton("Sign UP");
        SignUP.setBounds(300, 350, 230, 30);
        SignUP.setBackground(Color.BLUE);
        SignUP.setForeground(Color.WHITE);
        SignUP.addActionListener(this);
        add(SignUP);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == Login){
            Conn conn = new Conn();
            String cardno = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "Select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(cardno, pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect CardNo or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == SignUP){
            setVisible(false);
            new SignUpOne().setVisible(true);   
        }
    }
    public static void main(String args[]){
        new Login();
    }
    
}
