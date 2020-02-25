package Practicals.Prac6;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

class LoginForm extends JFrame implements ActionListener{
    
    static String URL = "jdbc:mysql://127.0.0.1/users";
    static String username = "root";
    static String password = "scott";
    
    JTextField uNameText = new JTextField(30);
    JPasswordField uPassword = new JPasswordField(30);
    JButton submit = new JButton("submit");
    
    LoginForm(){
        setTitle("Sign Up");
        JPanel c = new JPanel();
        this.add(c);
        setVisible(true);
        setBounds(20, 20, 420, 360);
        setResizable(false);
        JLabel uName = new JLabel("Username: ");
        JLabel uPasswordL = new JLabel("Password: ");
        
        c.add(uName); c.add(uNameText);
        c.add(uPasswordL); c.add(uPassword);
        submit.addActionListener(this);
        c.add(submit);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
           System.out.println("Username: " + uNameText.getText() + " Password: " + uPassword.getText());
           if((uNameText.getText().length() < 3) && uPassword.getText().length() < 3){
            if((!(uNameText.getText().trim().isEmpty())) && (!(uPassword.getText().trim().isEmpty()))){
                 try{
                 Connection con =  DriverManager.getConnection(URL, username, password);
                 Statement st = con.createStatement();
                 PreparedStatement stm = con.prepareStatement("insert into log_users values(?,?)");
                 stm.setString(1, uNameText.getText());
                 stm.setString(2, uPassword.getText());
                 stm.executeUpdate();
                 System.out.println("Succesfull input");
                 con.close();                }
                 catch(Exception ex){
                     ex.printStackTrace();
                 }
             }
            else{
                System.out.println("ERROR IN INPUT");
            }
           }
           else{
               System.out.println("ERROR IN INPUT");
           }
        }
    }
}


public class swing extends LoginForm{
    
public static void main(String args[]){
        LoginForm form_1 = new LoginForm();
    }
}
