<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import='java.sql.*' %>
    <%@ page import='java.io.*' %>
    <%! ResultSet resultset; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ask</title>
</head>
<body>
<jsp:include page="0head_stud.jsp" /> 
<form method="post" action="ask">
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//System.out.println("hi");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","queryms","123");
   	Statement statement = conn.createStatement() ;
    resultset =statement.executeQuery("select * from subject") ;
%>

Select Subject:
<select name="sub">
<%  while(resultset.next()){ %>
	<option value="<%= resultset.getInt(1) %>"><%= resultset.getString(2)%></option>
        <% } %>
</select> 

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

<br>
Question:<br>
<textarea rows="10" cols="50" required name="question"></textarea><br>
<% 
//HttpSession session1=request.getSession(true);  
String un=(String)session.getAttribute("stusername"); 

System.out.println("im in if"+un);

%>
<input type="hidden" name="student" value="<%=un%>">
<input type="submit" value="SUBMIT">

</form>
</body>
</html>