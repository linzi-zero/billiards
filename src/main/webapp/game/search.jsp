<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" name="viewport" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="apple-touch-icon-precomposed" href="/qunar-touch.png"/>
<title>查询-DA台球派</title>
<link rel="stylesheet" href="/css/common-2013072514033702.css"  type='text/css' />
<!-- 
<style tyle="text/css">
.qn_main{width:320px;margin:0 auto;}
</style>
 -->
<script   type="text/javascript" src="/js/date_picker/WdatePicker.js"></script>
</head>
<body>
<div class="qn_main">
<div class="qn_pages">
    <div id="searchPage">
		<div class="qn_qunar">
	<div class="bg"></div>
</div>
        <div class="qn_header">
            <div class="back"><a href="../">后退</a></div>
            <div class="title">搜索</div>
        </div>
                <!-- 搜索 -->
        <div class="qn_tab" id="ftTab">
            <ul class="qn_tab2">
                <li class="tab_title active" id="oneWay">简单</li>
                <li class="tab_title " id="roundWay">复杂</li>
            </ul>
            <div class="t" style="display: none">
            </div>
            <div class="tab_content qn_pa10" style="display: none">
                <div class="qn_item qn_border oneWay" id="ftStartDate">
                    <div class="qn_fl">开始日期</div>
                    <div class="qn_extend qn_arrow_grey r"><input id="startDateInput" readonly="readonly" type="text" onClick="WdatePicker()"/></div>
                </div>
                <div class="qn_item qn_border roundWay" id="ftBackDate">
                    <div class="qn_fl">结束日期</div>
                    <div class="qn_extend qn_arrow_grey r" ><input id="backDateInput" readonly="readonly" type="text" onClick="WdatePicker()"/></div>
                </div>
            </div>
            <div class="qn_btn qn_plr10">
                <a id="searchSubmit">开始搜索</a>
            </div>
            </div>
<div class="qn_footer">
	<ul class="footer_nav clearfix">
	    <li><a href="">关于我们</a></li>
	</ul>
	<ul class="mobile_pc clearfix">
	    <li class="active"><a href="">触屏版</a></li>
	</ul>
		<div class="copyright">
	    <span > 京ICP备999999</span>
	    <a class="qn_ml25" href="">意见反馈</a>
	</div>
</div>
    </div>
    <!-- 城市列表 -->
</div>

</div><!-- end qn_main -->
<script type="text/javascript" src="/js/zepto/zepto-2013072514033702.js"></script>
<script type="text/javascript">
;(function(){
//单程和返程
$(function(){
var tabs = $('#ftTab .tab_title');
tabs.on('click', function(e){
    var id = e.target.id;
    tabs.each(function(index, item){
        item.id == id ? $(item).addClass('active') : $(item).removeClass('active');
    });
    id = id.toLowerCase();
    id == 'oneway' ? $('.tab_content').css("display","none") : $('.tab_content').css("display","");
});
    
    //处理表单
    $('#searchSubmit').on('click', function(e){
        e.preventDefault();
        if( $('.tab_content').css("display") == "block"){
        	 $.href().path('findGameDetailRecord.action').param().param({
                 startDate  : $('#startDateInput').val(),
                 endDate    :  $('#backDateInput').val()
             }).exec();
        	
        }else{
        	 $.href().path('findGameDetailRecord.action').exec();
        }
    })
        
    
    //hover
    $('.qn_item, .back, .switch, .main_nav li, .footer_nav li a').hover();
    $('.qn_index_list dl').delegate('dd', 'touchstart', function(){
        var thiz = $(this),
            later = setTimeout(function(){
	            thiz.addClass('hover');
	        }, 50);
        
        $(document).one('touchmove touchend', function(){
            clearTimeout(later);
            thiz.removeClass('hover');
        });
	});
});
})();

</script>
	
<script type="text/javascript">

$(window).on('load', function(){
    setTimeout(function(){ window.scrollTo(0, 1); }, 100);
})
</script>
</body>
</html>
