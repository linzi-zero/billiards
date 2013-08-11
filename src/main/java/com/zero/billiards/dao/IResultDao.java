package com.zero.billiards.dao;
import java.util.List;

import com.zero.billiards.dataobject.po.TResult;

/**
 * 比赛结果
 * @author wanglinzi
 * @version 1.0
 *
 */
public interface IResultDao {
	/**
	 * 获取全部结果类型
	 * @return List<TResult>
	 */
	public List<TResult> findAllResult();
	
	/**
	 * 
	 * @param winnerBallNum
	 * @param loserBallNum
	 * @return TResult
	 */
	public TResult getResultByBallNum(Integer winnerBallNum, Integer loserBallNum);
}