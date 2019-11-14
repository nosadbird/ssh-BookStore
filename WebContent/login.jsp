<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>登录</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript">
	function check(){
		var tel = document.getElementById("tel").value;
		var password = document.getElementById("password").value;
		if(tel=="" || password==""){
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
<div style="height:400px;">
    <form action="contorller" method="post" onSubmit="return check()">
	   <table style="float:right;border:1px solid;margin:100px 700px 50px 0px;">
	      <tr><td>手机号：</td><td colspan="2"><input type="text" name="tel" id="tel" size="20"/></td></tr>
	      <tr><td>密码：</td><td colspan="2"><input type="password" name="password" id="password" size="20"/></td></tr>
	      <tr><td><input type="hidden" name="hidden" value="login"/></td></tr>
	      <tr><td><input type="submit" value="登录"/></td>
	          <td><input type="reset" value="重置"/></td>
	          <td><a href="register.jsp" title="无账号？注册？">注册</a></td>
	      </tr>
	   </table>
	</form>

</div>

<!--页脚-->
     <%@ include file="footer.jsp" %>

</body>
</html>