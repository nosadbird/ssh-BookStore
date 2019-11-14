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

<%int over = 0;
  int wait = 0;
  float sum = 0.0f;
%>

<%Vector<Orderbean> order = (Vector<Orderbean>) request.getAttribute("order"); %>
<%if(order != null){ 
	for(int i = 0;i < order.size();i++){
		sum += order.get(i).getBprice();
		if(order.get(i).getOstate() == 1){
			wait += 1;
		}else if(order.get(i).getOstate() == 2){
			over += 1;
		}
	
}} %>
<table align="center">
	<tr><th>共产生订单</th><th>已发货</th><th>已支付代发货</th><th>总销售额</th><th></th></tr>
	<tr><td><%=order.size() %></td><td><%=over %></td><td><%=wait %></td><td><%=sum %></td><td></td></tr>
</table>
</body>
</html>