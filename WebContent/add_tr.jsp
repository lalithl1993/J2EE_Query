<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%!  static int count = 0; %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add teacher and Subject</title>
</head>
<body>
<%
try{
	ResultSet resultset; 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//System.out.println("hi");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
 	//count=count+1;
	String s1= request.getParameter("addtr");
	int s2= Integer.parseInt(request.getParameter("sub"));
	System.out.println(s2);
	Statement statement = conn.createStatement() ;
	resultset =statement.executeQuery("select max(id) from teacher") ;
    resultset.next();
    
    	count=resultset.getInt(1)+1;
   
    
	PreparedStatement ps=conn.prepareStatement("insert into teacher(id,name,password,subid) values(?,?,?,?)");
   	ps.setInt(1,count);
   	ps.setString(2, s1);
   	ps.setString(3, s1);
   	ps.setInt(4, s2);
    int i=ps.executeUpdate(); 
    if(i!=0){  
      out.println("Record has been inserted");  
    }  
    else{  
      out.println("failed to insert the data");
     }  
    ps.close();
    
	
}catch(Exception e){System.out.println(e);}
	 
%>
</body>
</html>