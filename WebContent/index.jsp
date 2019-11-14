<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

<%	String mes = (String)request.getAttribute("message"); 
	if(mes != null){
%>
<script type="text/javascript" language="javascript">
alert("<%=mes%>");
</script>
<%} %>

<!--页眉-->
<div id="header-wrapper">
    <%@ include file="header.jsp" %>
</div>

<!--内容-->
<div id="content-wrapper" class="container">
    <%@ include file="index_content.jsp" %>
</div>

<!--页脚-->
     <%@ include file="footer.jsp" %>

</body>
</html>