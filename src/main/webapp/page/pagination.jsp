<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="STYLE4">
			&nbsp;&nbsp;共有 ${pageResults. totalCount} 条记录，当前第 ${pageResults.
			currentPage+1}/${pageResults.pageCount} 页
		</td>
		<td>
			<table border="0" align="right" cellpadding="0" cellspacing="0">
				<tr>
					<td width="40">
						<a
							onclick="gotoPage('1','list.do',${pageResults.pageCount },$('searchForm'));"
							href="#"><img src="../sub_images/first.gif" width="37"
								height="15" border="0" />
						</a>
					</td>
					<td width="45">
						<a
							onclick="gotoPage('${pageResults.currentPage eq 0?1:pageResults.currentPage}','list.do',${pageResults.pageCount},$('searchForm'));"
							href="#"><img border="0" src="../sub_images/back.gif"
								width="43" height="15" />
						</a>
					</td>
					<td width="45">
						<a
							onclick="gotoPage('${(pageResults.pageCount-1) eq pageResults.currentPage?pageResults.currentPage+1:pageResults.currentPage+2}','list.do',${pageResults.pageCount},$('searchForm'));"
							href="#"><img border="0" src="../sub_images/next.gif"
								width="43" height="15" />
						</a>
					</td>
					<td width="40">
						<a
							onclick="gotoPage('${pageResults.pageCount}','list.do',${pageResults.pageCount},$('searchForm'));"
							href="#"><img src="../sub_images/last.gif" width="37"
								height="15" border="0" />
						</a>
					</td>
					<td width="100">
						<div align="center">
							<span class="STYLE1">转到第 <input
									onkeypress="fnCheckNumber()" maxlength="3" name="p" type="text"
									size="4"
									style="height: 12px; width: 20px; border: 1px solid #999999;" />页
							</span>
						</div>
					</td>
					<td width="40">
						<a
							onclick="gotoPage($(p).value,'list.do',${pageResults.pageCount},$('searchForm'));"
							href="#"><img border="0" src="../sub_images/go.gif"
								width="37" height="15" />
						</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>