<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="javabean.Bookbean" %>
<%@page import="javabean.Addressbean" %>
<html>
<head>
<title>确认支付</title>
</head>
<body>
<form action="Paycontroll" method="post">
	<table align="center">
	
	
<%Vector<Addressbean> ab = (Vector<Addressbean>) session.getAttribute("address");
if(ab != null){
	for(int i = 0;i < ab.size();i++){
%>
		<tr><td><input type="radio" name="address" value="<%=i%>"><%=ab.get(i).getDaddress()%></td></tr>
	
<%}} %>
	<tr><td><a href="addaddress.jsp">添加收货地址</a></td></tr>
	<tr class="cart-title">
       <th >编号</th>
       <th>书名</th>
       <th>单价</th>
    </tr>
	<%
	float sum = 0.0f;
	Vector<String> id = new Vector<String>();
	Vector<Bookbean> book = (Vector<Bookbean>)session.getAttribute("buybook");
	if(book != null)
		for(int i = 0;i < book.size();i++){
			id.add(book.get(i).getBno().trim());
			sum += book.get(i).getBprice();
	%>
		<tr>
           <td><%=book.get(i).getBno().trim() %></td>
           <td><%=book.get(i).getBname() %></td>
           <td><%=book.get(i).getBprice() %></td>
    	</tr>
    <%} %>
	<tr><td>总金额：<%=sum %></td></tr>
	<tr><td><input type="hidden" name="hidden" value="buynow"></td></tr>
	<tr><td><input type="submit" value="确定支付"></td><td><a href="index.jsp">取消支付</a></td></tr>
	
	</table>
</form>	

</body>
</html>