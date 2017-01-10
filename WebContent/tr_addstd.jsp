<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add student</title>
<script type="text/javascript">
var flag= new Array();
flag[0]=false;
</script>
<script type="text/javascript" src="all_valid.js"></script>
<script type="text/javascript" src="vname.js"></script>
</head>
<body>
<jsp:include page="0head_tr.jsp" /> 
<form action="std_add" method="post" onsubmit="return all_valid();">
<table>
<tr><td>USN:<input type="text" name="usn" required/></td></tr>

<tr><td>NAME:<input type="text" name="name"onblur="vname(this.value,'sub',0)"></td><td><span id="sub"></span></td>
</tr>
</table>

<input type="submit" value="go"/>
</form>
</body>
</html>