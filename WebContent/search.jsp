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

<%String s =(String) request.getAttribute("message");
if(s != null){
%>
<script type="text/javascript" language="javascript">
alert("${message}");
</script>
<%} %>

<!--内容-->
<div id="content-wrapper" class="container">
<%Vector<Bookbean> v = (Vector<Bookbean>)session.getAttribute("Book"); 
  if(v == null){
%>

   <h3> 什么也没搜到哦~~~换个关键词试试吧.</h3>
    
<%} else {%>
<ul align="center" id="searchlist">
<% 
	for(int i = 0; i < v.size(); i++){
 %>
<li id="<%=v.get(i).getBno().trim()%>">
<table align="center">
<tr><td rowspan="4"><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>"><img alt="<%=v.get(i).getBname() %>" src="images/<%=v.get(i).getBno().trim()%>.jpg"></a></td><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>"><%=v.get(i).getBname() %></a></td><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>">走的路越多越喜欢宅着</a></td></tr>
<tr><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>"><%=v.get(i).getBauthor() %></a></td><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>"><%=v.get(i).getBpub() %></a></td></tr>
<tr><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>"><%=v.get(i).getBprice() %></a></td><td><a href="detailedcontorll?id=<%=v.get(i).getBno().trim()%>">40</a></td></tr>
<tr><td><a href="detailedcontorll?aim=joincart&&id=<%=v.get(i).getBno().trim()%>">加入购物车</a></td><td><a href="detailedcontorll?aim=buynow&&id=<%=v.get(i).getBno().trim()%>">立即购买</a></td></tr>
</table>
</li>

<% } } %>
</ul>
</div>
<!--页脚-->

</body>
</html>