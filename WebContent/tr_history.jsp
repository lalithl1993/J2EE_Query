<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%!  static int count = 0; %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>teacher history</title>
</head>
<body>
<jsp:include page="0head_tr.jsp" /> 
<%
try{
	ResultSet resultset;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//System.out.println("hi");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
	Statement statement = conn.createStatement() ;
	
	ResultSet resultset1 =statement.executeQuery("select id from teacher where name=\'"+(String)session.getAttribute("trusername")+"\'") ;
	
	resultset1.next();
	

		int tid=resultset1.getInt(1);
	
	

	resultset =statement.executeQuery("select * from answer where teach_id=\'"+tid+"\'") ;
    while(resultset.next())
    {	
   
    	out.print("Question:<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+resultset.getString("answer")+"<br>");
    	
    	
    	ResultSet resultset2;
    	Statement statement2 = conn.createStatement() ;
    	resultset2=statement2.executeQuery("select * from question where id="+resultset.getInt("ques_id"));
    	//System.out.println("select * from answer where id=\'"+resultset.getInt(1)+"\'");
    	if(resultset2.next())
    	{
    		out.println("answer:<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+resultset2.getString("question")+"<br><hr>");
    	}
    	else
    	{
    		out.println("answer:<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsppending<br><hr>");
    	}
    	
    	
    	
    	/*
    	resultset2=statement.executeQuery("select * from question where id="+resultset.getInt(2));
    	if(resultset2.next())
    	{
    		out.println("answer:<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+resultset2.getString(4)+"<br><hr>");
    	}
    	else
    	{
    		out.println("answer:<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsppending<br><hr>");
    	}*/
    }
   
    
	
}catch(Exception e){System.out.println(e);}
	 
%>
</body>
</html>