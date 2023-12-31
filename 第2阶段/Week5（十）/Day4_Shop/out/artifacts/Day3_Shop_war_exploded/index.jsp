<%@ page import="utils.ConstUtils" %>
<%@ page import="service.impl.UserServiceImpl" %>
<%@ page import="service.UserService" %>
<%@ page import="entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>

<title>小米商城首页</title>
</head>
<body>

   <%
       Cookie[] cookies = request.getCookies();
       String username = null;
       String password = null;
       if (cookies != null) {
           for (Cookie c : cookies) {   //循环遍历，判断是否勾选登录cookie的存储值
               if (c.getName().equals("upass")) {  //如果匹配上"upass"的value："username-password"
                   username = c.getValue().split("-")[0];
                   password = c.getValue().split("-")[1];
                   break;
               }
           }
       }

       UserService userService = new UserServiceImpl();
       //因为没有经过login判断，所以还需设置凭证，判断是否取到登录的cookie值
       if (username != null && password != null) {
           User user = userService.login(username, password);
           //对应设置登录凭证，在session域中存值
           request.getSession().setAttribute(ConstUtils.LOGIN,user);
       }

   %>


<%@ include file="header.jsp"%>
<!--网站中间内容开始-->
<div id="thred">
      <img src="image/banner2.jpg" width="1230" height="460" /> 
</div>
   <div id="forth">
   		<span>
        	<a href=""><img src="image/hjh_01.gif" /></a>
            <a href=""><img src="image/hjh_02.gif" /></a>
            <a href=""><img src="image/hjh_03.gif" /></a>
            <a href=""><img src="image/hjh_04.gif" /></a>
            <a href=""><img src="image/hjh_05.gif" /></a>
            <a href=""><img src="image/hjh_06.gif" /></a>
        </span>
        <a href="" id="a_left"><img src="image/hongmi4x.png" width="316" height="170" /></a>
        <a href="" id="a_left"><img src="image/xiaomi5.jpg" width="316" height="170" /></a>
    	<a href="" id="a_left"><img src="image/pinghengche.jpg" width="316" height="170" /></a>
   </div>
   <div id="fifth">
   		<span id="fif_text">小米明星单品</span>
   </div>
    <div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai1.png" width="234" height="234" /></a>
            	<a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
            <span style=" border-top:#008000 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai2.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
            <span style="border-top:#0000ff 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai3.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
            <span style="border-top:#ff0000 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai4.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
            <span style="border-top:#008080 1px solid">
            	<a href="" id="siximg"><img src="image/pinpai5.png" width="234" height="234" /></a>
                <a href="" id="na">小米MIX</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">3499元起</p>
            </span>
    </div>
   <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>