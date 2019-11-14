<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javabean.Userbean" %>

<!--网站logo-->
    <header class="container">
        <div id="logo">
           <div style="float:left">
              <a href="index.jsp"><h1>有家书店</h1></a>
           </div>
           <%Userbean u = (Userbean)session.getAttribute("user");
           	 if(u == null){
           %>
           <div style="float:left;">
              <br><br>
              <a href="login.jsp" title="已有账号？登录？" style="color:yellow;">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录</a>
              <a href="register.jsp" title="无账号？注册？" style="color:yellow;">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</a>
           </div>
            <%} else {
        	   %>
       		<div style="float:left;">
              <br><br>
              <a href="index.jsp"  style="color:yellow;">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您 <%=u.getUsername() %></a>
           </div>
           <%} %>
        </div>
        <div id="search">
            <form action="contorller" method="post">
                <input type="search" id="search" name="search" placeholder="站内搜索"><input type="submit" id="submit" value="搜索">
            	<input type="hidden" name="hidden" value="search"/>
            </form>
        </div>
    </header>
    <!--导航菜单-->
    <div id="nav">
       <nav class="container">
            <ul>
                <li><a href="index.jsp">首页</a></li><li>
                <a href="detailedcontorll?aim=myinfo">个人信息</a></li><li>
                <a href="detailedcontorll?aim=myorder">我的订单</a></li>
            </ul>
            <div id="menu-logo">
                <a href="detailedcontorll?aim=opencart&&id=-1">购物车</a>
            </div>
        </nav>

    </div>