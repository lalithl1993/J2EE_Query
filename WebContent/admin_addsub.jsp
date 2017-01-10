<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
<script type="text/javascript">
var flag= new Array();
flag[0]=false;
</script>
<script type="text/javascript" src="all_valid.js"></script>
<script type="text/javascript" src="vname.js"></script>
</head>
<body>
<jsp:include page="0head_admin.jsp" /> 
<form action="ad_sub.jsp" method="POST" name="form1" onsubmit="return all_valid();">
<h1>Add Subject</h1>
<table>
<tr>
<td>Subject Name:<input type="text" name="subname" required onblur="vname(this.value,'sub',0)"></td><td><span id="sub"></span></td>
</tr>
</table>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>