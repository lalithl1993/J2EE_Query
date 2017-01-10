<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view queries</title>
</head>
<body>
<jsp:include page="0head_tr.jsp" /> 
<%

try
{
	
	System.out.println("enter jsp");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
	Statement statement = conn.createStatement() ;
	//System.out.println("connection done");
	ResultSet resultset;
	//System.out.println("enter jsp");
	//System.out.println("select subid from teacher where name="+(String)session.getAttribute("trusername"));
	resultset =statement.executeQuery("select * from teacher where name=\'"+(String)session.getAttribute("trusername")+"\'") ;
	
	resultset.next();
	int tid=resultset.getInt(1);
	int subid=resultset.getInt(4);
	resultset =statement.executeQuery("select * from question where subid="+subid+" and status=0");
    while(resultset.next())
    {
    	out.println("Question:<br><a href=\'tr_answer.jsp?qid="+resultset.getString(1)+"&tid="+tid+"\'>"+resultset.getString(4)+"</a><br><hr>");
    }
	
}
catch(Exception e)
{
	System.out.println(e);
}
%>
</body>
</html>