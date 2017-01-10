<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%! ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add teacher</title>
<script type="text/javascript">
var flag= new Array();
flag[0]=false;
</script>
<script type="text/javascript" src="all_valid.js"></script>
<script type="text/javascript" src="vname.js"></script>
</head>
<body>
<jsp:include page="0head_admin.jsp" /> 
<form action="add_tr.jsp" method="POST" onsubmit="return all_valid();">
<table>
<tr>
<td>Teacher Name:<input type="text" name="addtr" onblur="vname(this.value,'sub',0)"></td><td><span id="sub"></span></td>
</tr>
</table>


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
<input type="submit" value="SUBMIT">
</form>
</body>
</html>