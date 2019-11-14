<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javabean.Orderbean" %>
<%@page import="java.util.Vector" %>
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

<%Vector<Orderbean> order = (Vector<Orderbean>) request.getAttribute("myorder"); %>
	<table align="center">
		<tr><th>订单状态</th><th>书籍编号</th><th>书名</th><th>价格</th><th>收货人</th><th>收货地址</th><th>收货人手机号</th></tr>
<%if(order != null){
	for(int i = 0;i < order.size();i++){
	%>
		<tr><td><%if(order.get(i).getOstate()==1){ %>已支付<%}else if(order.get(i).getOstate()==2){ %>已发货<%} %></td>
			<td><%=order.get(i).getBno() %></td><td><%=order.get(i).getBname() %></td>
			<td><%=order.get(i).getBprice() %></td><td><%=order.get(i).getDname() %></td>
			<td><%=order.get(i).getDaddress() %></td><td><%=order.get(i).getDtel() %></td></tr>
<%}}else{ %>
		<tr><td>您还没有订单哦,快去下单吧</td></tr>
<%} %>
	</table>
</body>
</html>