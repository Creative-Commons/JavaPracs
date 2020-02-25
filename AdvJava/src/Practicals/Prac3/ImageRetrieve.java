package Practicals.Prac3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageRetrieve{
    public static void main(String args[]){
        try{
            Connection con = new DatabaseConnect().DatabaseConnected();
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from member");
            while(rs.next()){
                System.out.println("Image "+ rs.getString("photo") );
                new FrameShow(rs.getString("photo"));  
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class FrameShow extends JFrame{
    JPanel jp = new JPanel();
    JLabel jl;
    ImageIcon img;
    
    FrameShow(String path){
        img = new ImageIcon(path);
        jl = new JLabel("", img, JLabel.CENTER);
        jp.add(jl);
        this.add(jp);
        this.setBounds(200, 200, 200, 200);
        this.setVisible(true);
    }
}
