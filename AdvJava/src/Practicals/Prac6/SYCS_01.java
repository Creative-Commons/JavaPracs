package Practicals.Prac6;
import java.sql.*;

public class SYCS_01 {

    static String DB_URL = "jdbc:mysql://127.0.0.1/college";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "scott";
    static ResultSet r;
    
    public static void main(String[] args) {
         try{
            Connection c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement s = c.createStatement();
            
            
            PreparedStatement ins = c.prepareStatement("insert into student(name, class) values(?,?)");  
            ins.setString(1, "San");
            ins.setString(2,"SYCS");
            ins.executeUpdate();
            
            r = s.executeQuery("select * from student");
            while(r.next()){
                System.out.println( r.getString("name"));
            }
            
            c.close();
           
        }
          catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
