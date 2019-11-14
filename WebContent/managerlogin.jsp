<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>login</title>
	<script language="JavaScript" type="text/javascript">
	function check(){
		var tel = document.getElementById("id").value;
		var password = document.getElementById("password").value;
		if(tel=="" || password==""){
			alert("有未填写的空");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
<%	String mes = (String)request.getAttribute("message"); 
	if(mes != null){
%>
<script type="text/javascript" language="javascript">
alert("<%=mes%>");
</script>
<%} %>

	<div id="login">
		<form action="ManagerLoginControl" method="post" onSubmit="return check()">
		<table align="center">
			<tbody>
				<tr><td>账号：</td><td><input type="text" id="id" name="id" size="15"></td></tr>
				<tr><td>密码：</td><td><input type="password" id="password" name="password" size="15"></td></tr>
				<tr><td><input type="reset" value="重置"></td><td><input type="submit" value="确定"></td></tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>