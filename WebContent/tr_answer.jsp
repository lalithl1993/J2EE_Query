<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>answer</title>
</head>
<body>
<jsp:include page="0head_tr.jsp" /> 
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
	Statement statement = conn.createStatement() ;
	ResultSet resultset;
	resultset =statement.executeQuery("select * from question where id="+request.getParameter("qid")) ;
	resultset.next();
	
%>
<form method="POST" action="answer">
	<label >Question:<%=resultset.getString(4) %></label><br>

	Answer:<br><textarea  cols="50" rows="10" name="ans"></textarea><br>
	<input type="submit"  value="submit"/>
	<input type="hidden"  name="qid" value="<%=request.getParameter("qid")%>">
	<input type="hidden" name="tid" value="<%=request.getParameter("tid")%>">
	
</form>



</body>
</html>