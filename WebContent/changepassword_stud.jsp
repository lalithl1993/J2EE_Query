<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
</head>
<body>
<jsp:include page="0head_stud.jsp" /> 
<form action="stud_cpwd" method="GET">
Enter old password:<input type="password" name="oldpw" required/><br>
Enter new password:<input type="password" name="nwpw" required/><br>
Enter confirm password:<input type="password" name="repw" required/><br>
<input type="submit" value="submit">
</form>
</body>
</html>