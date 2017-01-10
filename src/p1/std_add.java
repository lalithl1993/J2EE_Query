package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class std_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("hi");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
		 	String usn=request.getParameter("usn");
			String name=request.getParameter("name");
			
			
			int count;
		   	Statement statement = conn.createStatement() ;
		    ResultSet rs  =statement.executeQuery("select max(id) from student") ;
		    if(rs.next())
		    {
		    	System.out.println("in ifff");
		    	count=rs.getInt(1)+1;
		    }
		    else
		    {
		    	count=1;
		    }
		    
		    
		    
		    
		   	PreparedStatement ps=conn.prepareStatement("insert into student(id,name,usn,password) VALUES(?,?,?,?)");
		   
		   	ps.setInt(1,count);
		   	ps.setString(2, name);
            ps.setString(3,usn );
            ps.setString(4, name);
            int i=ps.executeUpdate(); 
            out.println("<body>");
            if(i!=0){  
              out.println("Record has been inserted");  
              out.println("<br><a href=\"teacher.jsp\">back</a>");
            }  
            else{  
              out.println("failed to insert the data");
              out.println("<br><a href=\"teacher.jsp\">back</a>");
             }  
            out.println("</body>");
            ps.close();
            
			
		}catch(Exception e){System.out.println(e);}
	}

}
