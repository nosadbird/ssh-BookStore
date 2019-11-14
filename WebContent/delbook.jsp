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
<%if(aim != null && aim.equals("delbook")){ %>

<form action="ManagerControl">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="getdelbook"></td></tr>
	<tr><td>输入书籍编号:</td><td><input type="text" name="bno"></td></tr>
	<tr><td><input type="submit" value="确定"></td></tr>
</table>
</form>

<%}else if(aim != null && aim.equals("getdelbook")){ %>
<%Bookbean book = (Bookbean) request.getAttribute("delbook"); %>
<form action="ManagerControl">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="ensuredelbook"></td></tr>
	<tr><td>书名：</td><td>${ delbook.bname }</td></tr>
	<tr><td>编号：</td><td>${ delbook.bno }</td></tr>
	<tr><td>作者：</td><td>${ delbook.bauthor }</td></tr>
	<tr><td>价格：</td><td>${ delbook.bprice }</td></tr>
	<tr><td>出版社：</td><td>${ delbook.bpub }</td></tr>
	<tr><td>图书类型：</td><td>${ delbook.btype }</td></tr>
	<tr><td><input type="hidden" name="bno" value="${ delbook.bno }"></td></tr>
	<tr><td><input type="submit" value="确定删除"></td></tr>
</table>
</form>
<%} %>
</body>
</html>