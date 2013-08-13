package com.zero.billiards.service.test;


import org.springframework.beans.factory.annotation.Autowired;

import com.zero.billiards.service.IStatsService;

/**
 * IStatsService测试
 * @author wanglinzi
 * @version 1.0
 * 2013年8月13日 下午6:48:50
 */
public class StatsServiceTest extends BaseSpringTestCase {
	
	@Autowired
	IStatsService statsService;
	
	public void testGetRankList(){
		System.out.println(this.statsService.getUserRankList("wlz"));
		System.out.println(this.statsService.getUserRank("wlz"));
	}
	
}
	