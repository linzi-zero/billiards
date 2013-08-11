<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<link rel="apple-touch-icon-precomposed" href="http://wz.easou.com/favicon.ico?esid=9U14ODjBostRfH&amp;wver=t&amp;enid=bcgn3508_45816"/>
<title>DA台球派首页</title>
<link href="css/vt4.css?esid=9U14ODjBostRfH&amp;wver=t&amp;enid=bcgn3508_45816" type="text/css" rel="stylesheet" />
<link href="css/style.css?esid=9U14ODjBostRfH&amp;wver=t&amp;enid=bcgn3508_45816" type="text/css" rel="stylesheet"/>
<style type="text/css">
.aclose{float:right; width:48px; height:31px; background:url(images/2903.png) no-repeat -290px 0; border:0; cursor: pointer;color:#fff;font-weight:bold;font-size:18px;text-shadow: 1px 1px 2px #61616b; text-align:center; line-height:31px}
#searchbox{z-index:999; position:absolute;
clear:both;width:304px; height:40px; border-top:1px solid #dddddd;
background-image: -webkit-gradient(
linear,
left bottom,
left top,
color-stop(1, #f8f8f8),
color-stop(0, #dedede)
);
background-image: -moz-linear-gradient(
center bottom,
#f8f8f8 100%,
#dedede 0%
);
padding:10px 8px 6px 8px; position:relative}
.inputsearh{ float:left;width:130px; height:31px; background:url(images/2903.png) no-repeat 0px 0px; border:0; padding:0px 10px 0px 110px; line-height:31px; font-size:16px; color:#a9a9a9}
.inputsearh_add{ float:left;width:105px; height:31px; background:url(images/2903.png) no-repeat 0px 0px; border:0; padding:0px 10px 0px 135px; line-height:31px; font-size:16px; color:#a9a9a9}
.other{
font-size:18px;
color:#212224;
text-align:center;
background-color:#e4edf1
}
.other1{
font-size:18px;
color:#31497c;
}
.other2{
font-size:18px;
color:#31497c;
text-align:center;
background-color:#e4edf1
}
.listmate{
padding:0px; height:34px; line-height:34px; border-bottom:1px solid #feffff; border-top:1px solid #feffff;
font-size:18px; color:#212224;z-index:0;
background-color:#feffff;
background-image:-webkit-gradient(linear, left top, left bottom, from(#feffff), to(#d3e5ee));
background-image:-webkit-linear-gradient(top, #feffff, #d3e5ee);
background-image:-moz-linear-gradient(top, #feffff, #d3e5ee);
background-image:-ms-linear-gradient(top, #feffff, #d3e5ee);
background-image:-o-linear-gradient(top, #feffff, #d3e5ee);
background-image:linear-gradient(top, #feffff, #d3e5ee);
filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#feffff', EndColorStr='#d3e5ee');
}
</style>
<script type="text/javascript">
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);   function hideURLbar(){ window.scrollTo(0,1); }
var tabs=[{id:'tab0',size:5,over:'tab_active',out:'tab'}];
var Tab={
change:function(index,tabId,menu){
var tab=tabs[index];
for(var i=0;i<tab.size;i++){
if(document.getElementById(tab.id+i)!=null){
document.getElementById(tab.id+i).style.display="none";
}
if(document.getElementById(tabId)!=null){
document.getElementById(tabId).style.display="";
}
if(document.getElementById("menu"+index+i)!=null){
document.getElementById("menu"+index+i).className=tab.out;
}
}
if(document.getElementById("menu"+index+menu)!=null) {
document.getElementById("menu"+index+menu).className=tab.over;
}
}
}
function display_searchPanel(){
var searchPanel = document.getElementById("searchPanel");
searchPanel.style.display = "block";
}
function searchSubmit(channel){
var q=$("#tKeyword").attr("value");
var actType=$("#actType").attr("value");
var esid=$("#esid").attr("value");
//var wver=$("#wver").attr("value");
var wver="t";
var fn=$("#fn").attr("value");
var url="s.e";
if(channel=="mp3"){
url="http://mp3.easou.com/s.e";
}
if(channel=="info"){
if(q==""){
url="http://wap.easou.com";
}else{
url="http://i.easou.com/s.m";
}
}
if(channel=="photo"){
if(q==""){
url="http://p2.easou.com/index.e";
}else{
url="http://p2.easou.com/s.e";
}
}
if(channel=="book"){
if(q==""){
url="http://book.easou.com/t/index.m";
}else{
url="http://book.easou.com/t/search.m";
}
}
if(channel=="app"){
if(q==""){
url="http://app.easou.com/index.e";
}else{
url="http://app.easou.com/sv.e";
}
}
if(channel=="shop"){
if(q==""){
url="http://gouwu.easou.com/index.m";
}else{
url="http://gouwu.easou.com/search.m";
}
}
if(channel=="new"){
url="http://n.easou.com/s.m";
}
if(channel=="weather"){
if(q==""){
url="http://tq.easou.com/city/search.action";
}else{
url="http://tq.easou.com/city/search.action";
}
}
if(channel=="web"){
url="http://wz.easou.com";
}
if(channel=="weather"){
url+="?q=" +q+"&actType="+actType +"&wver="+wver+"&esid="+esid+"&fn="+fn+"&search="+q;
}else
{
url+="?q=" +q+"&actType="+actType +"&wver="+wver+"&esid="+esid+"&fn="+fn;
}
location.href = url;
}
</script>
</head>
<body>
<p align="center"><a href="index.jsp"><img src="/image/logo.jpg"  style=" width:172px; height:44px;"/></a></p>
<section>
<div class="maintab">
<ul>
<li class="tab_active" id="menu01" onClick="Tab.change(0,'tab01',1)">台球</li>
<li class="tab" id="menu02" onClick="Tab.change(0,'tab02',2)">实用查询</li>
</ul>
</div>
<div class="tabmate" id="tab01" style="display:block">
<ul class="ullistbox2">
<li>
<a href='/game/inputResultPage.action'><img src="/image/app.png" width="55px" height="55px"/><br/>录入</a>
</li>
<li>
<a href='/game/search.jsp'><img src="/image/find.png" width="55px" height="55px"/><br/>查询</a>
</li>
<li>
<a href='/game/stats.jsp'><img src="/image/stats.png" width="55px" height="55px"/><br/>统计</a>
</li>
</ul>
</div>
<div class="tabmate" id="tab02" style="display:none">
<ul class="ullistbox2">
<li>
<a href=''><img src=""/><br/>机票</a>
</li>
</ul>
</div>
</section>
<br/>
<div class="copyright clearFix">
<div class="r"><span>©2013</span>&nbsp;billiards.com</div>
<li><a href="/logout.action">退出</a></li>
</div>
<script src="js/zepto/zepto.js"></script>
<script src="js/zepto/event.js"></script>
<script src="js/zepto/form.js"></script>
</body>
</html>
