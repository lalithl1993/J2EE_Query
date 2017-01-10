package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
			//HttpSession session=request.getSession();
			 HttpSession session=request.getSession(false);
	        //String pasword=(String)session.getAttribute("UserPassword");  
			 
	        String un=(String)session.getAttribute("trusername"); 
	        System.out.print("name= "+un);
			String oldpw= request.getParameter("oldpw");
		    String nwpw=request.getParameter("nwpw");
		    String repw=request.getParameter("repw");
		    System.out.println("hiiiiiiii");
		    if ((nwpw.equals("") || repw.equals(""))||(!nwpw.equals(repw)))
            {
		    	out.println("Password incorrect");
		    	RequestDispatcher rs = request.getRequestDispatcher("changepassword.jsp");
		        rs.include(request, response);
		        System.out.println("pass check error");
            }
		    else 
		    {
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
				PreparedStatement ps=conn.prepareStatement("update teacher set password= ? where name=? and password=?");
				ps.setString(1,nwpw);
				 System.out.println("pass check success");
			   	ps.setString(2,un);
	            ps.setString(3, oldpw);
	            //System.out.println("hiiiiiiii4");
	            int i=ps.executeUpdate(); 
	            out.println("<body>");
	            if(i!=0){  
	              out.println("Password has been updated");  
	              out.println("<br><a href=\"teacher.jsp\">back</a>");
	            }  
	            else{  
	              out.println("failed to update the password");
	              out.println("<br><a href=\"teacher.jsp\">back</a>");
	            } 
	            out.println("</body>");
	            ps.close();
		    }
		}catch(Exception e)
		{System.out.println(e);
		}
	}
}
	