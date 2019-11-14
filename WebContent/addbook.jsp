<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<html>
<head>
<title></title>
</head>
<body>
<%	String mes = (String)request.getAttribute("message"); 
	if(mes != null){
%>
<script type="text/javascript" language="javascript">
alert("<%=mes%>");
</script>
<%} %>
<%@ include file="managerheader.jsp" %>
<form action="ManagerControl" method="post">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="ensureaddbook"></td></tr>
	<tr><td>书名：</td><td><input type="text" name="bname"></td></tr>
	<tr><td>编号：</td><td><input type="text" name="bno"></td></tr>
	<tr><td>作者：</td><td><input type="text" name="bauthor"></td></tr>
	<tr><td>价格：</td><td><input type="text" name="bprice"></td></tr>
	<tr><td>出版社：</td><td><input type="text" name="bpub"></td></tr>
	<tr><td>图书类型：</td><td><input type="text" name="btype"></td></tr>
	<tr><td><input type="submit" value="确定添加"></td></tr>
</table>
</form>
</body>
</html>