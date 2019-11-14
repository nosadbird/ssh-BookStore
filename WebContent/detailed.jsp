<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javabean.Bookbean" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>有家书店</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <meta name="author" content="周振">
    <meta name="keywords" content="书店,有家书店,图书">
    <meta name="description" content="有家书店是一个销售书籍的网上书店。">
    <meta name="robots" content="index,follow">
</head>
<body>
<!--页眉-->
<div id="header-wrapper">
    <%@ include file="header.jsp" %>
</div>

<!--内容-->
<div>
<%Bookbean book = (Bookbean)request.getAttribute("book");
%>
	
<% 
  if(book != null){
%>

<li id="<%=book.getBno()%>">
<table align="center">
<tr><td rowspan="4"><a href="detailedcontorll?id=<%=book.getBno()%>"><img alt="<%=book.getBname() %>" src="images/<%=book.getBno().trim()%>.jpg"></a></td><td><%=book.getBname() %></td><td>走的路越多越喜欢宅着</td></tr>
<tr><td><%=book.getBauthor() %></td><td><%=book.getBpub() %></td></tr>
<tr><td><%=book.getBprice() %></td><td>40</td></tr>
<tr><td><a href="detailedcontorll?aim=joincart&&id=<%=book.getBno().trim()%>">加入购物车</a></td><td><a href="detailedcontorll?aim=buynow&&id=<%=book.getBno().trim()%>">立即购买</a></td></tr>

<%} %>
</div>





</body>
</html>