<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<%@ page import="javabean.Bookbean" %>
<%@ page import="java.util.Vector" %>
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


<form action="ManagerControl">
<table align="center">
	<tr><td><input type="hidden" name="aim" value="viewonebook"></td></tr>
	<tr><td>输入书籍编号:</td><td><input type="text" name="bno"></td></tr>
	<tr><td><input type="submit" value="确定"></td></tr>
</table>
</form>

<%String aim = request.getParameter("aim"); %>
<table align="center">
<tr><th>编号</th><th>书名</th><th>作者</th><th>价格</th><th>出版社</th><th>图书类型</th></tr>
<%if(aim != null && aim.equals("viewbook")){ %>

<%Vector<Bookbean> book = (Vector<Bookbean>) request.getAttribute("book"); %>
<%if(book != null){ 
	for(int i = 0;i < book.size();i++){
%>

<tr><td><%=book.get(i).getBno() %></td><td><%=book.get(i).getBname() %></td>
<td><%=book.get(i).getBauthor() %></td><td><%= book.get(i).getBprice()%></td>
<td><%=book.get(i).getBpub() %></td><td><%= book.get(i).getBtype()%></td></tr>

<%}} %>
<%}else if(aim != null && aim.equals("viewonebook")){ %>
<%Bookbean book = (Bookbean) request.getAttribute("viewonebook"); %>
<% if(book != null){%>

<tr><td><%=book.getBno() %></td><td><%=book.getBname() %></td>
<td><%=book.getBauthor() %></td><td><%= book.getBprice()%></td>
<td><%=book.getBpub() %></td><td><%= book.getBtype()%></td></tr>

<%}else{ %>
	<tr><td>无该本书</td></tr>
<% } }%>
</table>
</body>
</html>