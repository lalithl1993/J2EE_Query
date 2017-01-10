package p2;
import java.sql.*; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate2 {
	public static boolean checkUser(String stuser,String stpw) 
    {
     boolean st =false;
     try{

	 //loading drivers for mysql
        Class.forName("oracle.jdbc.driver.OracleDriver");
	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
        PreparedStatement ps =con.prepareStatement
                            ("select * from student where usn=? and password=?");
        ps.setString(1, stuser);
        ps.setString(2, stpw);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}
