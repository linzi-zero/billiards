<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta charset="utf-8" />
    <title>DA台球派</title>
    <meta content="xt88.vicp.net" name="author" />
    <meta content="Copyright &copy;wanglinzi.com" name="copyright" />
    <meta content="1 days" name="revisit-after" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link href="/css/base.css" rel="stylesheet" type="text/css" />
	<link href="/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="loginbg">
			<div class="logintopwarp">
				<div class="loginlogo"><img src="/image/logo.jpg" style=" width:192px; height:90px;"></div>
				<div class="slogan">xxxx</div>
			</div>
			<form id="fm1" class="fm-v clearfix" action="/login.action" method="post">
				<!--  -->
				<div class="loginbox">
					<div class="loginMsg">
	        		<label class="msgType">账号 :  </label>
					<input id="username" name="param.username" class="msgContent" tabindex="1" placeholder="请输入用户名" type="text" value="" maxlength="200" autocomplete="off"/>
					</div>
	        		<div class="loginMsgh2">
					<label class="msgType">密码 :  </label>
					<input id="password" name="param.password" class="msgContent" tabindex="2" placeholder="请输入密码" type="password" type="text" value="" maxlength="200" autocomplete="off"/>
					</div>
				</div>
				<div class="loginBoxBottom">
					<input id="isCookie" name="param.isCookie" checked="checked" value="1" tabindex="3"  type="checkbox" />
					<label class="nextAutoLogin">
						下次自动登录
					</label>
					<input  class="loginButton" id="loginButton" type="submit" value="登录"/>
				</div>
				<div class="loginBoxBottom">
					<label class="nextAutoLogin">
						${message }
					</label>
				</div>
			</form>
			</div>
<div class="footer" align="center">
	<p>DA 2013 billiards.com</p>
    <p>21:26 07-21</p>
</div>
</body>
</html>

