package atm.simulator.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener{


    JTextField PanField, AadharField, EducationField, OccupationField;
    JComboBox<String> ReligionCombo, CategoryCombo, IncomeCombo;
    JButton Next;
    String FormNo;
    
    SignUpTwo(String FormNo) {
        
        this.FormNo = FormNo;
        
        setTitle("New Account Application Form - 2 ");
        
        setLayout(null);

        JLabel AddDetails = new JLabel("Page 2 : Additional Details");
        AddDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        AddDetails.setBounds(250, 20, 400, 40);
        add(AddDetails);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 250 , 200, 30);
        add(religion);

        String religionVal[] = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        ReligionCombo = new JComboBox<>(religionVal);
        ReligionCombo.setBounds(300, 250 , 400, 30);
        add(ReligionCombo);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 300 , 200, 30);
        add(category);

        String categoryVal[] = {"General", "OBC", "SC", "ST", "Other"};
        CategoryCombo = new JComboBox<>(categoryVal);
        CategoryCombo.setBounds(300, 300, 400, 30);
        add(CategoryCombo);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 350, 200, 30);
        add(income);

        String incomeVal[] = {"No Income", "< 1,50,000", "1,50,000 - 2,50,000", "2,50,000 - 5,00,000", "> 5,00,000"};
        IncomeCombo = new JComboBox<>(incomeVal);
        IncomeCombo.setBounds(300, 350 , 400, 30);
        add(IncomeCombo);

        JLabel education = new JLabel("Education :");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 400, 200, 30);
        add(education);

        EducationField = new JTextField();
        EducationField.setFont(new Font("Raleway", Font.BOLD, 14));
        EducationField.setBounds(300, 400, 400, 30);
        add(EducationField);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 450 , 200, 30);
        add(occupation);

        OccupationField = new JTextField();
        OccupationField.setFont(new Font("Raleway", Font.BOLD, 14));
        OccupationField.setBounds(300, 450 , 400, 30);
        add(OccupationField);

        JLabel pan = new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 500 , 200, 30);
        add(pan);

        PanField = new JTextField();
        PanField.setFont(new Font("Raleway", Font.BOLD, 14));
        PanField.setBounds(300, 500 , 400, 30);
        add(PanField);

        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 550 , 200, 30);
        add(aadhar);

        AadharField = new JTextField();
        AadharField.setFont(new Font("Raleway", Font.BOLD, 14));
        AadharField.setBounds(300, 550 , 400, 30);
        add(AadharField);

        Next = new JButton("Next");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(620, 620 , 80, 30);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 900);
        setLocation(350, 30);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent ae) {

    String religion = (String) ReligionCombo.getSelectedItem();
    String category = (String) CategoryCombo.getSelectedItem();
    String income = (String) IncomeCombo.getSelectedItem();
    String education = EducationField.getText();
    String occupation = OccupationField.getText();
    String pan = PanField.getText();
    String aadhar = AadharField.getText();

    // Basic validation
    if (pan.isEmpty() || aadhar.isEmpty()) {
        JOptionPane.showMessageDialog(null, "PAN Number and Aadhar Number are required.");
        return;
    }

    try {
        Conn c = new Conn();

        String query = 
            "INSERT INTO signuptwo (religion, category, income, education, occupation, pan, aadhar) " +
            "VALUES ('" + religion + "', '" + category + "', '" + income + "', '" + 
                     education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "')";

        c.s.executeUpdate(query);

        // Page navigation
       setVisible(false);
        new SignUpThree(FormNo).setVisible(true);


    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    public static void main(String args[]) {
        new SignUpTwo(" ");
    }
}
