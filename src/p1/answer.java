package p1;

import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    int count=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
		 	//count=count+1;
			//String s1= request.getParameter("addtr");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("hi");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
			String s1=request.getParameter("qid");
			String s2=request.getParameter("tid");
			String s3= request.getParameter("ans");
			System.out.println(s2);
			Statement statement1 = conn.createStatement() ;
			ResultSet resultset =statement1.executeQuery("select max(id) from answer") ;
		    if(resultset.next())
		    {
		    	count=resultset.getInt(1)+1;
		    }
		    else
		    {
		        count=1;
		    }
		    Statement statement2 = conn.createStatement() ;
		    ResultSet resultset2 =statement2.executeQuery("update question set status=1 where id="+s1+"");
		    resultset2.next();
	
			PreparedStatement ps=conn.prepareStatement("insert into answer(id,ques_id,teach_id,answer) values(?,?,?,?)");
		   	ps.setInt(1,count);
		   	ps.setString(2, s1);
		   	ps.setString(3, s2);
		   	ps.setString(4, s3);
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
