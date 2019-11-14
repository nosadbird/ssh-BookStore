<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>注册</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript">
	function check(){
		var tel = document.getElementById("tel").value;
		var name = document.getElementById("name").valeu;
		var sex = document.getElementById("sex").value;
		var password = document.getElementById("password").value;
		if(tel=="" || name=="" || sex=="" || password==""){
			alert("有未填写的空");
			return false;
		} else if(tel.length != 11){
			alert("手机号应为11位")
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
<!--页眉-->
<div id="header-wrapper">
    <%@ include file="header.jsp" %>
</div>

<%	String mes = (String)request.getAttribute("message"); 
	if(mes != null){
%>
<script type="text/javascript" language="javascript">
alert("<%=mes%>");
</script>
<%} %>

<!--内容-->
<div style="height:300px;margin:100px 700px 50px 0px;">
    <form action="contorller" method="post" onSubmit="return check()">
	   <table style="float:right;border:1px solid">
	      <tr><td>手机号：</td><td colspan="2"><input type="text" id="tel" name="tel" size="20"/></td></tr>
	      <tr><td>姓名：</td><td colspan="2"><input type="text" id="name" name="name" size="10"/></td></tr>
	      <tr><td>性别：</td><td colspan="2"><input type="text" id="sex" name="sex" size="5"/></td></tr>
	      <tr><td>密码：</td><td colspan="2"><input type="password" id="password" name="password" size="20"/></td></tr>
	      <tr><td><input type="hidden" name="hidden" value="register"/></td></tr>
	      <tr><td><input type="submit" value="注册"/></td>
	          <td><input type="reset" value="重置"/></td>
	      </tr>
	   </table>
	</form>
	
</div>

<!--页脚-->
     <%@ include file="footer.jsp" %>

</body>
</html>