package Practicals.Prac6;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;

class UserFrame extends JFrame implements ActionListener{
    
    static String DB_URL = "jdbc:mysql://127.0.0.1/college";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "scott";
    static ResultSet r;
    static Connection c;
    static Statement st;
    
    JTextField uNameText;
    JPasswordField uPasswordField;
    JButton btn;
    
    
    UserFrame(){
        setTitle("Signup Form");
        JPanel c = new JPanel();
        this.add(c);
        
        JLabel uName = new JLabel("Enter username:");
        uNameText = new JTextField(30);
        c.add(uName);
        c.add(uNameText);
        
        JLabel passName = new JLabel("Enter password");
        uPasswordField = new JPasswordField(30);
        c.add(passName);
        c.add(uPasswordField);
        
        btn = new JButton("Submit");
        btn.addActionListener(this);
        c.add(btn);
        
        setBounds(20, 20, 400, 650);
        setVisible(true);
        setResizable(true);
    }
    
    public void insertUser(String u, String p){
        try{
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ins = con.prepareStatement("insert into users(username,password) values(?,?)");
            ins.setString(1, u); ins.setString(2, p);
            ins.executeUpdate();
            con.close();
        }
          catch(Exception x){
            x.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Action being performed");
        if(e.getSource() == btn){
            System.out.println("The user inputted username: "+uNameText.getText()+" and password: "+uPasswordField.getText());
            
            this.insertUser(uNameText.getText(), uPasswordField.getText());
        }
    }
}

public class SignUp{
    
    public static void main(String args[]){
        UserFrame demo = new UserFrame();
    }
}

