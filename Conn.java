package bank.management.system;
import java.sql.*;      //sql library
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
         //    Class.forName(com.mysql.cj.jdbc.Driver);       //for driver register
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Oraclesql*5");    
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
