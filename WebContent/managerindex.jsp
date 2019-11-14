<%@ page contentType= "text/html;charset= UTF-8"
		pageEncoding= "UTF-8"%>
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
</body>
</html>