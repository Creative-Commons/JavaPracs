package Practicals.Prac5;

import java.sql.*;
import java.util.Scanner;

public class BasicDB {
    static String DB_URL = "jdbc:mysql://127.0.0.1/college";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "scott";
    static ResultSet r;
    static Connection c;
    static Statement st;
    Scanner s = new Scanner(System.in);
    
    void CreateTable(){
        System.out.println("Enter tablename: ");
        
        String statement = "create table " + s.next() + "(";
        
        System.out.println("Enter number of columns: ");
        int num = s.nextInt();
        
        for(int i = 0; i < num; i++){
            
            System.out.println("Enter name of column " + i+1 + ": ");
            statement += s.next() + " ";
            System.out.println("Enter datatype of column " + i+1 + ": ");
            statement += s.next() + "," ;
        }
        statement += ");";
        System.out.println(statement);
        try{
            PreparedStatement create =  c.prepareStatement(statement);
            create.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
         try{
            c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = c.createStatement();
            
            r = st.executeQuery("select * from student");
            while(r.next()){
                System.out.println( r.getString("name"));
            }
            
            
            new BasicDB().CreateTable();
            
            c.close();
           
        }
          catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
