package Practicals.Prac3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
    Connection con = null;
    
    Connection DatabaseConnected() throws Exception{
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/library";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "scott";
        Connection c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return c;
    }
}