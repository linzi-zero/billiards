<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"
	name="viewport" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection" />
<meta name="keywords" content="" />
<meta name="description" content="" />

<title>统计-DA台球派</title>
<link rel="stylesheet" href="/css/common-2013072514033702.css"
	type='text/css' />

<style type="text/css">
.qn_main {
	width: 320px;
	margin: 0 auto;
}
</style>
<script type="text/javascript" src="/js/jquery.js" charset="utf-8"></script>
</head>
<body>
	<div class="qn_main">
		<div class="qn_pages">
			<div id="flightsPage">
				<div class="qn_qunar">
					<div class="bg"></div>
				</div>
				<div class="qn_header">
					<div class="back">
						<a href="#">后退</a>
					</div>
					<div class="title sub">
						<p>统计结果</p>
					</div>
				</div>
				<div class="qn_list">
				
					<div class="wrapper">
						<div class="little_box">
							<span class="itemname1">我的实时统计：</span>
							<div class="itemname1">胜率:<span class="font4"><fmt:formatNumber value="${userRank.winPercentage }" pattern="##"  minFractionDigits="0"/> %</span>
							 总计:<span class="font4">${userRank.amount }</span> 赢:<span class="font4">${userRank.wins }  </span>输:<span class="font4">${userRank.losses }</span></div>
						</div>
						<div id="graphbox">
						
			<c:forEach items="${rankList }" var="rank" varStatus="vs">
							<div class="little_box">
								<div class="graph">
									<span class="color5" style="width: ${rank.winPercentage }%;">&nbsp;</span>
								</div>
								<div class="itemname">${rank.realName }:<span class="font3"><fmt:formatNumber value="${rank.winPercentage }" pattern="##"  minFractionDigits="0"/> % </span> 赢:<span class="font3">${rank.wins } </span> 输:<span class="font3">${rank.losses }</span></div>
							</div>
		   </c:forEach>
						</div>
					</div>
					<div class="qn_footer">
						<ul class="footer_nav clearfix">
							<li><a href="">最近浏览</a></li>
							<li><a href="">关于我们</a></li>
						</ul>
						<ul class="mobile_pc clearfix">
							<li class="active"><a href="">触屏版</a></li>
						</ul>
						<div class="copyright">
							<span>Billiards 京ICP备05021087</span> <a class="qn_ml25" href="">意见反馈</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- end qn_main -->
	<script type="text/javascript">
		$(window).on('load', function() {
			setTimeout(function() {
				window.scrollTo(0, 1);
			}, 100);
		})
	</script>
</body>
</html>

