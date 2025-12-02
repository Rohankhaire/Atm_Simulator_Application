package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField NameTextField, ParentNameField, EmailField, MaritalstatusField, AddressField, CityField, StateField, PinCodeField;  
    JButton Next;
    JRadioButton male, Female, Other;
    JDateChooser datechooser;
    
    SignUpOne() {

        setLayout(null);

        Random ran = new Random();
        random = ran.nextInt(9000) + 1000;

        JLabel FormNo = new JLabel("APPLICATION FORM NO: " + random);
        FormNo.setFont(new Font("Raleway", Font.BOLD, 38));
        FormNo.setBounds(140, 20, 600, 40);
        add(FormNo);

        JLabel PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290, 80, 400, 30);
        add(PersonalDetails);

        JLabel Name = new JLabel("Name :");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140, 100, 30);
        add(Name);

        NameTextField = new JTextField();
        NameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        NameTextField.setBounds(300, 140, 400, 30);
        NameTextField.setBackground(Color.lightGray);
        add(NameTextField);

        JLabel ParentName = new JLabel("Parent's Name :");
        ParentName.setFont(new Font("Raleway", Font.BOLD, 20));
        ParentName.setBounds(100, 190, 200, 30);
        add(ParentName);

        ParentNameField = new JTextField();
        ParentNameField.setFont(new Font("Raleway", Font.BOLD, 14));
        ParentNameField.setBounds(300, 190, 400, 30);
        ParentNameField.setBackground(Color.lightGray);
        add(ParentNameField);

        JLabel DOB = new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 200, 30);
        add(datechooser);

        JLabel Gender = new JLabel("Gender :");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 200, 30);
        add(Gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 70, 30);
        add(male);

        Female = new JRadioButton("Female");
        Female.setBounds(380, 290, 80, 30);
        add(Female);

        Other = new JRadioButton("Other");
        Other.setBounds(470, 290, 80, 30);
        add(Other);

        // FIX: Only one gender selectable
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(Female);
        genderGroup.add(Other);

        JLabel Email = new JLabel("Email :");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 340, 200, 30);
        add(Email);

        EmailField = new JTextField();
        EmailField.setFont(new Font("Raleway", Font.BOLD, 14));
        EmailField.setBounds(300, 340, 400, 30);
        EmailField.setBackground(Color.lightGray);
        add(EmailField);

        JLabel Maritalstatus = new JLabel("Marital Status :");
        Maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        Maritalstatus.setBounds(100, 390, 200, 30);
        add(Maritalstatus);

        MaritalstatusField = new JTextField();
        MaritalstatusField.setFont(new Font("Raleway", Font.BOLD, 14));
        MaritalstatusField.setBounds(300, 390, 400, 30);
        MaritalstatusField.setBackground(Color.lightGray);
        add(MaritalstatusField);

        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        add(Address);

        AddressField = new JTextField();
        AddressField.setFont(new Font("Raleway", Font.BOLD, 14));
        AddressField.setBounds(300, 440, 400, 30);
        AddressField.setBackground(Color.lightGray);
        add(AddressField);

        JLabel City = new JLabel("City :");
        City.setFont(new Font("Raleway", Font.BOLD, 20));
        City.setBounds(100, 490, 200, 30);
        add(City);

        CityField = new JTextField();
        CityField.setFont(new Font("Raleway", Font.BOLD, 14));
        CityField.setBounds(300, 490, 400, 30);
        CityField.setBackground(Color.lightGray);
        add(CityField);

        JLabel State = new JLabel("State :");
        State.setFont(new Font("Raleway", Font.BOLD, 20));
        State.setBounds(100, 540, 200, 30);
        add(State);

        StateField = new JTextField();
        StateField.setFont(new Font("Raleway", Font.BOLD, 14));
        StateField.setBounds(300, 540, 400, 30);
        StateField.setBackground(Color.lightGray);
        add(StateField);

        JLabel PinCode = new JLabel("PinCode :");
        PinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        PinCode.setBounds(100, 590, 200, 30);
        add(PinCode);

        PinCodeField = new JTextField();
        PinCodeField.setFont(new Font("Raleway", Font.BOLD, 14));
        PinCodeField.setBounds(300, 590, 400, 30);
        PinCodeField.setBackground(Color.lightGray);
        add(PinCodeField);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        Next = new JButton("Next");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setFont(new Font("Raleway", Font.BOLD, 14));
        Next.setBounds(620, 660, 80, 30);
        Next.addActionListener(this);
        add(Next);
    }

    public void actionPerformed(ActionEvent ae) {

    String FORMNO = "" + random;
    String Name = NameTextField.getText();
    String ParentName = ParentNameField.getText();
    String DOB = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
    String Email = EmailField.getText();
    String Maritalstatus = MaritalstatusField.getText();
    String Address = AddressField.getText();
    String City = CityField.getText();
    String State = StateField.getText();
    String PinCode = PinCodeField.getText();

    String Gender = null;
    if (male.isSelected()) Gender = "Male";
    else if (Female.isSelected()) Gender = "Female";
    else if (Other.isSelected()) Gender = "Other";

    // VALIDATION → STOP if missing any critical field
    if (Name.isEmpty() || ParentName.isEmpty() || DOB.isEmpty() ||
        Gender == null || Email.isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Fill all required fields");
        return; // STOP processing
    }

    try {
        Conn c = new Conn();
        String query = "INSERT INTO signup (formno, name, parentname, dob, gender, email, maritalstatus, address, city, state, pincode) " +
               "VALUES ('" + FORMNO + "', '" + Name + "', '" + ParentName + "', '" + DOB + "', '" + Gender + "', '" + Email + "', '" +
               Maritalstatus + "', '" + Address + "', '" + City + "', '" + State + "', '" + PinCode + "')";
        c.s.executeUpdate(query);

        setVisible(false);
        new SignUpTwo(FORMNO).setVisible(true);

    } catch (Exception e) {
        System.out.println(e);
    }
}

    public static void main(String args[]) {
        new SignUpOne();
    }
}
