<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javabean.Orderbean" %>
<%@page import="java.util.Vector" %>
<%@page import="javabean.Userbean" %>
<html>
<head>
<title>我的订单</title>
<link href="style.css" rel="stylesheet" type="text/css">
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

<%Userbean user = (Userbean) session.getAttribute("user"); %>
	<table align="center">
<%if(user != null){%>
	<tr><td>用户名：</td><td><%= user.getUsername()%></td></tr>
	<tr><td>性别：</td><td><%=user.getSex()%></td></tr>
	<tr><td>手机号：</td><td><%=user.getTel()%></td></tr>
<%}%>
	</table>
</body>
</html>