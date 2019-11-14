<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<%@ page import="javabean.Orderbean" %>
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
<table align="center">
<tr><th>购买人手机号</th><th>书籍编号</th><th>书名</th><th>价格</th><th>收货人</th><th>收货地址</th><th>收货人手机号</th><th>订单状态</th><th>处理</th></tr>
<%Vector<Orderbean> order = (Vector<Orderbean>) request.getAttribute("order"); %>
<%if(order != null){ 
	for(int i = 0;i < order.size();i++){
%>

	<tr><td><%=order.get(i).getUtel() %></td><td><%=order.get(i).getBno() %></td>
	<td><%=order.get(i).getBname() %></td>
	<td><%=order.get(i).getBprice() %></td><td><%=order.get(i).getDname() %></td>
	<td><%=order.get(i).getDaddress() %></td><td><%=order.get(i).getDtel() %></td>
	<%if(order.get(i).getOstate() == 2){ %>
	<td>已发货</td>
	<%} else if(order.get(i).getOstate() == 1){%>
	<td>已支付</td><td><a href="ManagerControl?aim=send&bno=<%=order.get(i).getBno()%>">发货</a></td>
	<%} %>
	</tr>
<%}} %>
</table>
</body>
</html>