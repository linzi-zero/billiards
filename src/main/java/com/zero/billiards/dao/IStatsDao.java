package com.zero.billiards.dao;

import java.util.List;

import com.zero.billiards.dataobject.vo.UserRankVO;

public interface IStatsDao {
	/**
	 * 获取胜场数
	 * @param userId
	 * @return
	 */
	public Integer getWins(Integer userId);
	/**
	 * 获取输场数
	 * @param userId
	 * @return
	 */
	public Integer getLosses(Integer userId);
	/**
	 * 获取系统用户排名
	 * @return
	 */
	public List<UserRankVO> getUserRankList();
}