package com.zero.billiards.service;

import java.util.List;

import com.zero.billiards.dataobject.vo.UserRankVO;

/**
 * 统计服务
 * @author wanglinzi
 * @version 1.0
 * 2013年8月13日 下午6:18:17
 */
public interface IStatsService {
	/**
	 * 获取统计排名
	 * @param userId
	 * @return
	 */
	public List<UserRankVO> getUserRankList(String userName);
	
	public UserRankVO getUserRank(String userName);
}
