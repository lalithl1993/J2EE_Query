package p1;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

   
    public teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

    static int count = 0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		//out.println("DATABASE");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("hi");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
		 	count=count+1;
			String s1= request.getParameter("addtr");
		    String s2=request.getParameter("sub");
		   	PreparedStatement ps=conn.prepareStatement("INSERT INTO TEACHER(TID,TNAME,TSUBJECT) VALUES(?,?,?)");
		   	//PreparedStatement ps=conn.prepareStatement("insert into teacher(tidtname,tsubject) values(?,?)");
			//ps.setInt(1, count);
		   	ps.setInt(1,count);
		   	ps.setString(2, s1);
            ps.setString(3, s2);
            int i=ps.executeUpdate(); 
            if(i!=0){  
              out.println("Record has been inserted");  
            }  
            else{  
              out.println("failed to insert the data");
             }  
            ps.close();
            
			
		}catch(Exception e){System.out.println(e);}
	}
}
