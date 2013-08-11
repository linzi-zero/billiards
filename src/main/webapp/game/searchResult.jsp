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
<link rel="apple-touch-icon-precomposed" href="/qunar-touch.png" />
<title>查询结果-DA台球派</title>
<link rel="stylesheet"
	href="/css/common-2013072514033702.css"
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
						<p>查询结果</p>
					</div>
				</div>
				<div class="qn_sort">
					<ul>
						<li class="by_price active up"><span>按时间</span>
							<div class="mark"></div></li>
					</ul>
				</div>
				<div class="qn_list">
					<ul>
						<c:forEach items="${records }" var="record">
							<li class="item clearfix" data-code="fff" data-type="0">
								<div class="inner clearfix">
									<div class="qn_fl qn_mr10">
										<p class="qn_grey">
											<fmt:formatDate value="${record.endTime }"
												pattern="yyyy-MM-dd hh:mm:ss" />
										</p>
									</div>
									<div class="min_price qn_arrow_grey b">
										<p class="ds qn_orange">${record.winnerUserName eq sessionScope["_UID"] ?"赢":"输"}</p>
									</div>
									<div>
										<p class="airport">
											<br /> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												${record.winnerRealName }</span> VS <span>${record.loserRealName }
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
													test='${record.winnerUserName eq sessionScope["_UID"]}'>
													<a
														href="/game/deleteRecord.action?delRecordId=${record.id }">删除</a>
												</c:if>
											</span>
										</p>
									</div>
								</div>
								<div class="qn_ota qn_hide clear">
									<div class="ticket_info">${record.winnerUserName eq sessionScope["_UID"] ?"我赢了，":"我输了。"}
										赢者剩余${record.winnerBallNum }球，输者剩余${record.loserBallNum }球。</div>
									<ul>
									</ul>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div class="bottom">
						<div class="more">点击查看更多</div>
						<div class="goTop">
							<span>回到顶部</span>
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
	<script type="text/javascript" src="/js/zepto/zepto.js"></script>
	<script>
		;
		(function() {

			$(function() {

				//后退
				$('#flightsPage .back a').on('click', function(e) {
					e.preventDefault();
					window.history.go(-1);
				});

				//选中
				$('.qn_index_list dd')
						.on(
								'click',
								function(e) {
									var thiz = $(this), tagName = e.target.tagName, target, className;
									if (tagName == 'INPUT') {
										target = e.target;
									} else {
										target = thiz.find('input')[0]
										target.checked = target.checked ? false
												: true;
									}
									className = target.className;
									if (className.indexOf('isMix') != -1)
										return;
									if (className.indexOf('planeDesc') != -1)
										return;

									if (className.indexOf('all') != -1) {
										var isChecked = target.checked;
										className = target.className.replace(
												'all ', '');
										$('.qn_index_list .' + className)
												.each(
														function() {
															this.className
																	.indexOf('all') == -1
																	&& (this.checked = isChecked ? true
																			: false);
														});
										return;
									}
									;

									var all = true, zAll = $('.qn_index_list .all.'
											+ className);
									zAll[0].checked = true;
									$('.qn_index_list .' + className)
											.each(
													function() {
														!this.checked
																&& (zAll[0].checked = false);
													});
								});

				//重置
				$('.qn_index_list .reset').on('click', function() {
					$('.qn_index_list input').each(function() {
						this.checked = false;
					});
				});
				//提交
				//包含联程 isMix
				//TODO 初始化filter
				$('.qn_index_list .confirm')
						.on(
								'click',
								function() {
									var filter = {}, className, i, url1 = '', //'&filter=',
									url2 = ''; //'&filterValue=';

									$('.qn_index_list input[type="checkbox"]')
											.each(
													function() {
														className = this.className;

														if (className
																.indexOf('all') != -1
																|| className
																		.indexOf('isMix') != -1)
															return;
														//多选按钮
														if (this.checked) {
															filter[className] = filter[className]
																	|| [];
															filter[className]
																	.push(this.value)
														}
													});

									var isAll = false, radio = $('.qn_index_list input[class="all planeDesc"]');
									if (radio.length != 0 && radio[0].checked)
										isAll = true;

									$('.qn_index_list input[class="planeDesc"]')
											.each(
													function() {
														if (!this.checked
																&& !isAll)
															return;
														className = this.className;
														filter[className] = filter[className]
																|| [];
														filter[className]
																.push(this.value)
													});

									for (i in filter) {
										url1 += i + '|';
										url2 += filter[i].join(',') + '|';
									}

									url1 = url1.slice(0, -1);
									url2 = url2.slice(0, -1);
									filter = {
										'filter' : url1,
										'filterValue' : url2
									};
									if ($('.isMix')[0]) {
										filter.isMix = $('.isMix')[0].checked ? 1
												: 0;
									}
									$.href().param(filter).exec();
								});

				//展开，显示OTA列表
				$('.qn_list ul')
						.delegate(
								'li',
								'click',
								function(e) {
									var me = $(this), minPrice = me
											.find('.min_price'), ota = me
											.find('.qn_ota'), code = me
											.data('code')
											|| '';
									minPrice.toggleClass("b").toggleClass("t");
									//展开ota列表

									if (ota.hasClass('qn_hide')) {
										ota.removeClass('qn_hide');
									} else {
										//  关闭列表
										!$(e.target).hasClass('agent_more')
												&& ota.addClass('qn_hide');
									}

								});

				//加载更多
				var tcount = 63, retCount = 15, currPage = 1, totalPage = Math
						.ceil(tcount / retCount);

				$('.qn_list .more').on('click', function() {
					var thiz = $(this);
					if (thiz.html() == '正在加载...')
						return;
					if (++currPage > totalPage)
						return;
					thiz.html("正在加载...");
					$.ajax({
						url : $.href().param({
							'page' : currPage,
							'tpl' : 'flight.flightListTpl'
						}).getValue(),
						dataType : 'html',
						success : function(data) {
							$('.qn_list > ul').append(data);
							if (currPage == totalPage) {
								thiz.html('已加载完毕');
							} else {
								thiz.html('点击查看更多');
							}
							;
						}
					});
				});

				//回到顶部
				$('.bottom .goTop').on('click', function() {
					window.scroll(0, 1);
				});

				//hover
				$('.header_item').hover();

				$('.qn_list').delegate('.inner', 'touchstart', function() {
					var thiz = $(this), later = setTimeout(function() {
						thiz.addClass('hover');
					}, 50);

					$(document).one('touchmove touchend', function() {
						clearTimeout(later);
						thiz.removeClass('hover');
					});
				});

				$(
						'.filter_bg_btn, .back, .right, .bottom div, .footer_nav li a, .qn_sort li, .main_nav li')
						.hover();

				$('.bottom .reset, .bottom .confirm, .bottom .goTop').hover();

			})
		})();
	</script>
	<script type="text/javascript">
		$(window).on('load', function() {
			setTimeout(function() {
				window.scrollTo(0, 1);
			}, 100);
		})
	</script>
</body>
</html>

