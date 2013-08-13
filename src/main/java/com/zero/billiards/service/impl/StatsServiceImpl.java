package com.zero.billiards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.billiards.dao.IStatsDao;
import com.zero.billiards.dao.IUserDao;
import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.dataobject.vo.UserRankVO;
import com.zero.billiards.service.IStatsService;

/**
 * 
 * @author wanglinzi
 * @version 1.0 2013年8月13日 下午6:27:54
 */
@Service("statsService")
public class StatsServiceImpl implements IStatsService {

	@Autowired
	private IStatsDao statsDao;

	@Autowired
	private IUserDao userDao;

	public List<UserRankVO> getUserRankList(String userName) {
		return this.statsDao.getUserRankList();
	}

	public UserRankVO getUserRank(String userName) {
		TUser user = this.userDao.getByUserName(userName);
		UserRankVO vo = new UserRankVO();
		vo.setUserId(user.getId());
		Integer wins = this.statsDao.getWins(user.getId());
		Integer losses = this.statsDao.getLosses(user.getId());

		vo.setLosses(losses);
		vo.setWins(wins);
		vo.setAmount(losses + wins);
		vo.setWinPercentage(wins / ((wins + losses) == 0 ? 1 : (wins + losses)));

		return vo;
	}
}
