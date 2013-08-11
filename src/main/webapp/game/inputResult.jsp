<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
   <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta charset="utf-8">
    <title>对战录入-DA台球派(billiards.com)</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
<style>
@charset "utf-8";.list{margin-bottom:10px;list-style:none;background-color:#fff;-webkit-tap-highlight-color: rgba(0,0,0,0);}.list li:not([class*="list"]){position:relative;padding:10px;margin:5px 5px 0;border-bottom:1px solid rgba(0,0,0,.25);box-shadow:0 0 3px rgba(0,0,0,.25)}.list li p{color:rgba(0,0,0,.3);margin-top:3px;}.list li.re-content{border:1px solid #efc795;background-color:#fff0dd;margin:10px 15px 0;display:none;}.list li.re-content p{color:#56270b;line-height:1.5em;position:relative;}.list li.re-content:before{content:'';display:block;position:absolute;top:-8px;right:40px;height:8px;width:14px;overflow:hidden;background:url(/image/icon.png) no-repeat 0 -16px;background-size:34px 52px}.list li span.date{display:block;color:#c09157;padding-top:5px}.list li:first-child{border-top:1px solid rgba(0,0,0,.1);}.list li > a:not([class*="button"]){position:relative;display:block;padding:inherit;margin:-10px;color:#001c82;}.list .hoticon{display:block;position:relative;width:46px;margin-right:10px;min-height:60px;line-height:31px;text-indent:5px;float:left;color:#662400;text-shadow:0 1px 0 rgba(255,255,255,.3);}.list .hoticon:before{display:block;content:'置顶';position:absolute;top:0;width:46px;height:33px;background:url(/image/icon.png) no-repeat 0 0;z-index:1}.list.inset{width:auto;margin-right:10px;margin-left:10px;border:1px solid rgba(0,0,0,.1);border-radius:6px;box-sizing:border-box;}.list.inset li:first-child{border-top-width:0;}.list.inset li:last-child{border-bottom-width:0;}.list .list-divider{position:relative;top:-1px;padding-top:6px;padding-bottom:6px;font-size:12px;font-weight:bold;line-height:18px;text-shadow:0 1px 0 rgba(255,255,255,.5);background-color:#f8f8f8;background-image:-webkit-linear-gradient(top,#f8f8f8 0,#eee 100%);background-image:linear-gradient(to bottom,#f8f8f8 0,#eee 100%);border-top:1px solid rgba(0,0,0,.1);border-bottom:1px solid rgba(0,0,0,.1);box-shadow:inset 0 1px 1px rgba(255,255,255,.4);}.list-tab{margin-bottom:10px;}.list-tab a.tab{display:inline-block;width:50%;text-align:center;background:#538dea;font-size:1.4em;font-weight:bold;color:#FFF;position:relative;padding:10px;}.list-tab a.tab:first-child{margin-left:-20px;}.list-tab a.tab:last-child{border-left:1px solid #FFF;margin-right:-21px;}.list-tab a.tab.current{background:#2c69c5;}.list-tab a.tab.current:after{content:'';display:block;width:0;height:0;position:absolute;bottom:-8px;left:50%;margin-left:-10px;border-left:8px solid transparent;border-right:8px solid transparent;border-top:8px solid #2C69C5}.list.inset .list-divider:first-child{top:0;border-top-width:0;border-radius:6px 6px 0 0;}.list.inset .list-divider:last-child{border-radius:0 0 6px 6px;}.list .chevron,.list [class*="button"],.list [class*="count"],.list .toggle{position:absolute;top:50%;right:10px;}.list .chevron,.list [class*="count"]{margin-top:-10px;}.list .chevron + [class*="count"]{right:30px;}.list [class*="button"]{left:auto;margin-top:-14px;}.list .toggle{margin-top:-15px;}[class*="bar-"]{z-index:10;height:37px;padding:5px;}.bar-header-secondary{top:45px;}.bar-footer{bottom:0;}.bar-standard{background-color:#f2f2f2;background-image:-webkit-linear-gradient(top,#f2f2f2 0,#e5e5e5 100%);background-image:linear-gradient(to bottom,#f2f2f2 0,#e5e5e5 100%);border-bottom:1px solid #aaa;box-shadow:inset 0 1px 1px -1px #fff;}.bar-footer.bar-standard,.bar-footer-secondary.bar-standard{border-top:1px solid #aaa;border-bottom-width:0;}.bar-title{background-color:#2c69c5;overflow:hidden;border-bottom:1px solid #0e5895;box-shadow:inset 0 1px 1px -1px rgba(255,255,255,.8);-webkit-box-orient:horizontal;box-orient:horizontal;}.bar-title .title{position:absolute;top:0;left:0;display:block;width:100%;font-size:20px;font-weight:bold;line-height:44px;color:#fff;text-align:center;text-shadow:0 -1px rgba(0,0,0,.5);white-space:nowrap;}.bar-title > a:not([class*="button"]){display:block;width:100%;height:100%;}.bar-title .title a{color:inherit;}.bar-tab{bottom:0;height:50px;padding:0;background-color:#393939;background-image:-webkit-linear-gradient(top,#393939 0,#2b2b2b 100%);background-image:linear-gradient(to bottom,#393939 0,#2b2b2b 100%);border-top:1px solid #000;border-bottom-width:0;box-shadow:inset 0 1px 1px -1px rgba(255,255,255,.6);}.tab-inner{display:-webkit-box;display:box;height:100%;list-style:none;-webkit-box-orient:horizontal;box-orient:horizontal;}.tab-item{height:100%;padding-top:9px;text-align:center;box-sizing:border-box;-webkit-box-flex:1;box-flex:1;}.tab-item.active{box-shadow:inset 0 0 20px rgba(0,0,0,.5);}.tab-icon{display:block;height:18px;margin:0 auto;}.tab-label{margin-top:1px;font-size:10px;font-weight:bold;color:#fff;text-shadow:0 1px rgba(0,0,0,.3);}.bar-title .title + [class*="button"]:last-child,.bar-title .button + [class*="button"]:last-child,.bar-title [class*="button"].pull-right{position:absolute;top:5px;right:5px;}.bar-title .button:active{color:#fff;background-color:#0876b1;}.bar-title .segmented-controller{line-height:18px;text-shadow:0 -1px 0 rgba(0,0,0,0.3);background-color:#1eb0e9;background-image:-webkit-linear-gradient(top,#1eb0e9 0,#0984c6 100%);background-image:linear-gradient(to bottom,#1eb0e9 0,#0984c6 100%);border:1px solid #0e5895;border-radius:3px;box-shadow:0 1px rgba(255,255,255,.25);-webkit-box-flex:1;box-flex:1;}.bar-title .segmented-controller li{border-left:1px solid #0e5895;box-shadow:inset 1px 0 rgba(255,255,255,.25);}.bar-title .segmented-controller .active + li,.bar-title .segmented-controller li:first-child{box-shadow:none;}.bar-title .segmented-controller li:first-child{border-left-width:0;}.bar-title .segmented-controller li.active{background-color:#0082c4;box-shadow:inset 0 1px 6px rgba(0,0,0,.3);}.bar-title .segmented-controller li > a{color:#fff;}.bar-standard input[type=search]{height:32px;margin:0;}.bar-title [class*="button"]{padding:4px 15px;position:relative;z-index:10;line-height:26px;color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,.3);background:url(/image/icon.png) no-repeat 0 -66px;border:none;box-shadow:none;width:46px;height:29px;}html,body,div,span,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,section,summary,time,audio,video{padding:0;margin:0;border:0;}html{-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;}body{font:14px/1.25 "Helvetica Neue",sans-serif;color:#222;background-color:#fff;}a{color:#222;text-decoration:none;-webkit-tap-highlight-color:rgba(0,0,0,0);}.content{background-color:#fff;overflow:hidden;-webkit-transition-property:top,bottom;transition-property:top,bottom;-webkit-transition-duration:.2s,.2s;transition-duration:.2s,.2s;-webkit-transition-timing-function:linear,linear;transition-timing-function:linear,linear;-webkit-overflow-scrolling:touch;}.content > *{-webkit-transform:translateZ(0px);transform:translateZ(0px);}.content-padded{padding:10px;}[class*="button"]{position:relative;display:inline-block;padding:6px 15px;margin:0;font-weight:bold;height:22px;line-height:22px;color:#333;text-align:center;text-shadow:0 1px 0 rgba(255,255,255,0.5);vertical-align:top;cursor:pointer;background-color:#f8f8f8;background-image:-webkit-linear-gradient(top,#f8f8f8 0,#d4d4d4 100%);background-image:linear-gradient(to bottom,#f8f8f8 0,#d4d4d4 100%);border:1px solid rgba(0,0,0,.3);border-radius:3px;box-shadow:inset 0 1px 1px rgba(255,255,255,.4),0 1px 2px rgba(0,0,0,.05);}[class*="button"]:active{padding-top:5px;padding-bottom:3px;color:#333;background-color:#ccc;background-image:none;box-shadow:inset 0 3px 3px rgba(0,0,0,.2);}.button-main,.button-positive,.button-negative{color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,.3);}.button-main{background-color:#1eafe7;background-image:-webkit-linear-gradient(top,#1eafe7 0,#1a97c8 100%);background-image:linear-gradient(to bottom,#1eafe7 0,#1a97c8 100%);border:1px solid #117aaa;}.button-positive{background-color:#34ba15;background-image:-webkit-linear-gradient(top,#34ba15 0,#2da012 100%);background-image:linear-gradient(to bottom,#34ba15 0,#2da012 100%);border:1px solid #278f0f;}.button-negative{background-color:#e71e1e;background-image:-webkit-linear-gradient(top,#e71e1e 0,#c71a1a 100%);background-image:linear-gradient(to bottom,#e71e1e 0,#c71a1a 100%);border:1px solid #b51a1a;}.button-main:active,.button-positive:active,.button-negative:active{color:#fff;}.button-main:active{background-color:#0876b1;}.button-positive:active{background-color:#298f11;}.button-negative:active{background-color:#b21a1a;}.button-block{display:block;padding:11px 0 13px;margin-bottom:10px;font-size:16px;}.button-block:active{padding:12px 0;}[class*="button"] [class*="count"]{padding-top:2px;padding-bottom:2px;margin-right:-4px;margin-left:4px;text-shadow:none;background-color:rgba(0,0,0,.2);box-shadow:inset 0 1px 1px -1px #000000,0 1px 1px -1px #fff;}.button-block [class*="count"]{position:absolute;right:0;padding-top:4px;padding-bottom:4px;margin-right:10px;}.topwrap{height:44px;padding:0 10px;}.login{text-align:right;height:44px;line-height:44px }.login a{padding:0 5px;}.customWrap{margin:5px;padding:5px;}.msgwrap{padding:7px 10px 0;}.bottomWarp{padding:10px 20px 5px;height:32px;text-align:center;}.copyright{background:#dbdbdb;padding:10px;}.copyright a{color:#013c96;}.nav-bottom{padding:15px 20px 25px;}.l{float:left }.r{float:right;}.page{position:relative;}.page .pages{text-align:center;height:40px;line-height:40px;font-size:1.4em;color:#001C82;}.pageskip{position:absolute;border:1px solid #d6d6d6;top:0;}.pageskip a{padding:10px;display:inline-block;}.pageskip a:first-child{border-right:1px solid #d6d6d6;}.pageskip.prev{left:0;border-left:none }.pageskip.next{right:0;border-right:none }footer{clear:both;}.nav-global{height:30px;line-height:30px;text-align:center;padding:5px }footer a,footer span,.nav-global a{padding:0 3px;}.c-input-group label,.c-input-group p{display:block;padding-bottom:10px;}.c-input-group textarea{height:100px;}.relink{}.relink a{background:#2b67c7;color:#FFF;width:50%;display:inline-block;text-align:center;padding:10px 0;}.relink a:first-child{border-right:1px solid #FFF;margin-left:-1px;}i.gotop{display:inline-block;background:url(/image/icon.png) no-repeat -50px 0;width:18px;height:20px;margin-right:5px;vertical-align:top;}input,textarea,button,select{font-family:inherit;font-size:inherit;}select,textarea,input[type="text"],input[type=search],input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="tel"],input[type="color"],.input-group{width:100%;height:40px;padding:5px 0;margin-bottom:10px;background-color:#fff;border:1px solid rgba(0,0,0,.2);border-radius:3px;box-shadow:0 1px 1px rgba(255,255,255,.2),inset 0 1px 1px rgba(0,0,0,.1);-webkit-appearance:none;box-sizing:border-box;}input[type=search]{height:34px;font-size:14px;border-radius:30px;}textarea{height:auto;}select{height:auto;font-size:14px;background-color:#f8f8f8;background-image:-webkit-linear-gradient(top,#f8f8f8 0,#d4d4d4 100%);background-image:linear-gradient(to bottom,#f8f8f8 0,#d4d4d4 100%);box-shadow:inset 0 1px 1px rgba(0,0,0,.1);}.input-group{width:auto;height:auto;padding:0;}.input-group input{margin-bottom:0;background-color:transparent;border:0;border-bottom:1px solid rgba(0,0,0,.2);border-radius:0;box-shadow:none;}.input-group input:last-child{border-bottom-width:0;}.input-row{overflow:hidden;border-bottom:1px solid rgba(0,0,0,.2);}.input-row:last-child{border-bottom-width:0;}.input-row label{float:left;width:25%;padding:11px 10px 9px 13px;font-weight:bold;}.input-row label + input{float:right;width:65%;padding-left:0;margin-bottom:0;border-bottom:0;}
</style>
    <script type="text/javascript" src="/js/jquery.js" charset="utf-8"></script>
  </head>
  <body>

<div class="topwrap">
    <img class="l" src="/image/logo.jpg" style="width:102px; height:42px;" alt="billiards" />
    <div class="login">
    			 <a href="">欢迎你：<c:out value="${sessionScope._URN}" /></a>
    </div>
</div>
	 	<header class="bar-title">
	    	<a id="go_back" class="button-prev" href="#" data-transition="slide-out">返回</a>
	    	<h1 class="title" style="top:44px">对战录入</h1>
	  	</header>
  		<div class="content">
  			
    		<div class="checkout-form content-padded">
      			<form id="submit_form" action="/game/submitResult.action" method="post">
	        		<div class="c-input-group">
	        			<p>${message }</p>
	          			<p>感谢您使用DA台球派对战录入，谢谢！</p>
	          			<label>您的对手是：</label>
							<select name="param.opponentId" contextmenu="对手姓名">
								<c:forEach items="${users }" var="user">
									<option value="${user.id}">${user.realName }</option>
								</c:forEach>
							</select>
	          			<label>本场结果：</label>
									<input name="param.isWin" checked="checked" value="true" type="radio">我赢了
									<input name="param.isWin" type="radio" value="false">我输了			
						<br/><br/>
	          			<label>我剩余球数：</label>
	          				<select name="param.ballNum" contextmenu=">详细结果">
	          				<c:forEach begin="0" end="7" var="i">
								 <option value="${i }">${i }个球</option>
								 </c:forEach>
							</select>
						<label>对手剩余球数：</label>
	          				<select name="param.opponentBallNum" contextmenu=">详细结果">
								<c:forEach begin="0" end="7" var="i">
								 <option value="${i }">${i }个球</option>
								 </c:forEach>
							</select>
	          			<label>此场非赛事</label>
	        		</div>
					<div class="bottomWarp">
	        			<a id="submit_btn" class="button">提&nbsp;&nbsp;交</a>
	        		</div>
      			</form>
    		</div>
  		</div>
  		<footer>
 <div class="nav-global">
   <a href="">首页</a>
 </div>
 <div class="copyright">
     <span>触版</span><span class="r">&copy;2013 billiards.com</span>
 </div>
<script type="text/javascript">
  		$(function(){
  			$('#go_back').bind('click',function(){
  				history.go(-2);
  			});
  		});
</script>
  		</footer>
  </body>
  <script type="text/javascript">
  $(function(){
	$('#submit_btn').bind('click',function(){
		$('#submit_form').submit();
	});  
  });
  </script>
</html>