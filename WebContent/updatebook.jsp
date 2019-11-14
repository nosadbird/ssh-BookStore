<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<%@ page import="javabean.Bookbean" %>
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

<%String aim = request.getParameter("aim"); %>
<%if(aim != null && aim.equals("updatebook")){ %>

<form action="ManagerControl">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="getupdatebook"></td></tr>
	<tr><td>输入书籍编号:</td><td><input type="text" name="bno"></td></tr>
	<tr><td><input type="submit" value="确定"></td></tr>
</table>
</form>

<%}else if(aim != null && aim.equals("getupdatebook")){ %>
<%Bookbean book = (Bookbean) request.getAttribute("updatebook"); %>
<% if(book != null){%>
<form action="ManagerControl" method="post">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="ensureupdatebook"></td></tr>
	<tr><td>书名：</td><td><input type="text" name="bname" value="${ updatebook.bname }"></td></tr>
	<tr><td>编号：</td><td>${ updatebook.bno }</tr>
	<tr><td>作者：</td><td><input type="text" name="bauthor" value="${ updatebook.bauthor }"></td></tr>
	<tr><td>价格：</td><td><input type="text" name="bprice" value="${ updatebook.bprice }"></td></tr>
	<tr><td>出版社：</td><td><input type="text" name="bpub" value="${ updatebook.bpub }"></td></tr>
	<tr><td>图书类型：</td><td><input type="text" name="btype" value="${ updatebook.btype }"></td></tr>
	<tr><td><input type="hidden" name="bno" value="${ updatebook.bno }"></td></tr>
	<tr><td><input type="submit" value="确定修改"></td></tr>
</table>
</form>
<%}else{ %>
	<tr><td>无该本书</td></tr>
<%} }%>
</body>
</html>