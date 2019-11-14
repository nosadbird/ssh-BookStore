<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javabean.Cartbean" %>
<%@ page import="java.util.Vector" %>
<%@ page import="javabean.Addressbean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
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
<div id="content-wrapper" class="container">
    <!--左边内容区-->
    <article>
    <%Vector<Cartbean> cart = (Vector<Cartbean>) request.getAttribute("cart"); %>
        <!--面包屑导航-->
        <section class="crumb-nav">您现在的位置：<a href="index.html">首页</a> &gt;&gt;购物车</section>
        <section class="cartt"><h2 id="title8">购物车</h2>
<form action="Paycontroll" method="post">
            <table class="cart-table">
      <tr><td> <input type="hidden" name="hidden" value="cart"></td></tr>

                <tr class="cart-title">
                	<th>选择</th>
                    <th colspan="2">编号</th>
                    <th>书名</th>
                    <th>单价</th>
                </tr>
    <%
    float sum = 0.00f;
    if(cart != null){
    	for(int i = 0; i < cart.size(); i++){
    		sum += cart.get(i).getBprice();
    %>   
                <tr>
                	<td><input type="checkbox" name="check" value="<%=cart.get(i).getBno().trim() %>"></td>
                    <td class="td-center"><a href="detailedcontorll?id=<%=cart.get(i).getBno().trim() %>"><img src="images/<%=cart.get(i).getBno().trim() %>.jpg" alt="封面"/></a></td>
                    <td><h3><%=cart.get(i).getBno() %></h3></td>
                    <td class="td-right"><%=cart.get(i).getBname() %></td>
                    <td class="td-right"><%=cart.get(i).getBprice() %></td>
                </tr>
               
     <%}} %>    
                <tr class="cart-total">
                    <td colspan="5" class="td-right"><input type="submit" value="去结算"></td>
                </tr>
            </table>
            </form>
        </section>
    </article><!--右边边栏区--><aside>
        <!--广告区-->
        <section id="advert">
            <a href="#"><img src="images/ad1.jpg" alt="广告"></a>
            <a href="#"><img src="images/ad2.jpg" alt="广告"></a>
            <a href="#"><img src="images/ad3.jpg" alt="广告"></a>
        </section>
        <div class="border"><img src="images/border.gif" alt="分隔线" /></div>
        <!--畅销图书-->
        <section id="best-selling">
            <h2 id="title7">畅销图书</h2>
            <ul>
                <li><a class="selling" href="#">查令十字街84号（珍藏版）（汤唯、吴秀波主演北京遇上西雅图2）</a>
                    <div class="curr">
                        <div class="p-img">
                            <a title="查令十字街84号（珍藏版）（汤唯、吴秀波主演北京遇上西雅图2）" href="#">
                                <img width="80" height="80" src="images/selling1.jpg">
                            </a>
                        </div>
                        <div class="p-name">
                            <a title="查令十字街84号（珍藏版）（汤唯、吴秀波主演北京遇上西雅图2）" href="#">查令十字街
84号（珍藏版）（汤唯、吴秀波主演北京遇上西雅图2）</a>
                            <strong>￥43.50</strong>
                            <del>￥52.00</del>
                        </div>
                    </div>
                </li>
                <li><a class="selling" href="#">分享经济 供给侧改革的新经济方案</a>
                    <div class="curr">
                        <div class="p-img">
                            <a title="分享经济 供给侧改革的新经济方案" href="#">
                                <img width="80" height="80" src="images/selling2.jpg">
                            </a>
                        </div>
                        <div class="p-name">
                            <a title="分享经济 供给侧改革的新经济方案" href="#">分享经济 供给侧改革的新经济方案</a>
                            <strong>￥43.50</strong>
                            <del>￥52.00</del>
                        </div>
                    </div>
                </li>
            </ul>
        </section>
        <div class="border"><img src="images/border.gif" alt="分隔线" /></div>
        <!--图书分类-->
        <section class="aside-section">
            <h2 id="title4">图书分类</h2>
            <ul>
                <li><a href="category.html">编程语言</a></li>
                <li><a href="category.html">数据库</a></li>
                <li><a href="category.html">图形图像</a></li>
                <li><a href="category.html">网页制作</a></li>
                <li><a href="category.html">考试认证</a></li>
            </ul>
        </section><!--合作伙伴--><section class="aside-section">
            <h2 id="title5">合作伙伴</h2>
            <ul>
                <li><a href="#">中国电子商务研究中心</a></li>
                <li><a href="#">清华大学出版社</a></li>
                <li><a href="#">中国人民大学出版社</a></li>
                <li><a href="#">中国社会科学出版社</a></li>
            </ul>
        </section>
        <div class="border"><img src="images/border.gif" alt="分隔线" /></div>
        <!--关于书店-->
        <section class="about">
            <h2 id="title6">关于书店</h2>
            <img src="images/about.gif" alt="有家书店"><p>有家书店成立于2010年6月，是由教育部主管、清华大学主办的综合
出版单位。植根于“清华”这座久负盛名的高等学府，秉承清华人“自强不息，厚德载物”的人文精神。</p>
        </section>
    </aside>
</div>

<!--页脚-->
     <%@ include file="footer.jsp" %>

</body>
</html>