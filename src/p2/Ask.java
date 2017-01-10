package p2;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ask
 */

public class Ask extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String sub=request.getParameter("sub");
		String question=request.getParameter("question");
		//StringBuffer question = new StringBuffer(request.getParameter("question"));
		System.out.println(question);
		String std=request.getParameter("student");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
			
			Statement statement = conn.createStatement() ;
			ResultSet resultset =statement.executeQuery("select max(id) from question") ;
		    resultset.next();
		    
		    int	count=resultset.getInt(1)+1;
		   
		    
			resultset =statement.executeQuery("select id from student where usn=\'"+std+"\'") ;
		    resultset.next();
		    
		    int	sid=resultset.getInt(1);

			
			
			PreparedStatement ps=conn.prepareStatement("insert into question(id,stud_id,subid,question,status) values(?,?,?,?,?)");
			ps.setInt(1,count);
		   	ps.setInt(2, sid);
            ps.setString(3, sub);
            ps.setString(4, question);
            ps.setInt(5, 0);
            int i=ps.executeUpdate(); 
            out.println("<body>");
            if(i!=0){  
                out.println("Record has been inserted");  
                out.println("<br><a href=\"student.jsp\">back</a>");
              }  
              else{  
                out.println("failed to insert the data");
                out.println("<br><a href=\"student.jsp\">back</a>");
               }  
            out.println("</body>");
              ps.close();
              
          	
		}
		catch(Exception e)
		{
			
		}
	}

}
