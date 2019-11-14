<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>添加收货地址</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript">
	function check(){
		var dtel = document.getElementById("dtel").value;
		var daddress = document.getElementById("daddress").value;
		if(dtel=="" || daddress==""){
			alert("地址和电话必须填写");
			return false;
		} else if(dtel.length != 11){
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
<div style="height:800px;">
    <form action="AddAddress" method="post" onSubmit="return check()">
	   <table align="center">
	      <tr><td>收货人姓名：</td><td colspan="2"><input type="text" name="dname" id="dname" size="20"/></td></tr>
	      <tr><td>收货地址：</td><td colspan="2"><input type="text" name="daddress" id="daddress" size="20"/></td></tr>
	      <tr><td>收货人电话：</td><td colspan="2"><input type="text" name="dtel" id="dtel" size="20"/></td></tr>
	      <tr><td><input type="hidden" name="hidden" value="addaddress"/></td></tr>
	      <tr><td><input type="submit" value="确定"/></td>
	      </tr>
	   </table>
	</form>

</div>


</body>
</html>