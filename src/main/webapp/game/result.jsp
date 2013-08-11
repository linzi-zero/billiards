<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<html>
<head>
    <meta content="wap.easou.com" name="author" />
    <meta content="Copyright &copy;wanglinzi.com" name="copyright" />
    <meta content="1 days" name="revisit-after" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
<script language="javascript" src="/js/jquery.js"></script>
<script language="JavaScript" type="text/javascript">
var sec = 3;
timerID = setInterval("count()",1000);
function count() {
    $('#num').html(sec--);
    if(sec < 1){
    	clearInterval(timerID);
    	window.location.href ="/index.jsp";
    }
}
</Script>
</head>
<body>
<br/>
<br/>
<br/>
<table width="100%" height="223" border="0" align="center">
  <tr>
    <td height="50"><div align="center"><img src="/image/app-2.jpg" width="37" height="40"></div></td>
  </tr>
  <tr>
    <td height="50"><div align="center">${message }</div></td>
  </tr>
  <tr>
    <td height="50"><div align="center">将在 <SPAN id="num" style="color: red;">3</SPAN> 秒后自动自动返回</div></td>
  </tr>
  <tr>
    <td height="50">
    <div align="center">
       <a id="go_back" class="button-prev" href="/index.jsp" data-transition="slide-out">返回</a>
    </div>    </td>
  </tr>
</table>
</body>
</html>