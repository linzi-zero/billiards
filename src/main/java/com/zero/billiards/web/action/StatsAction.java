package com.zero.billiards.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zero.billiards.dataobject.vo.UserRankVO;
import com.zero.billiards.service.IStatsService;
import com.zero.billiards.web.common.BaseAction;

/**
 * 
 * @author wanglinzi
 * @version
 * 
 */
public class StatsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5545844701455954272L;

	@Autowired
	private IStatsService statsService;

	private UserRankVO userRank;
	private List<UserRankVO> rankList;

	public UserRankVO getUserRank() {
		return userRank;
	}

	public void setUserRank(UserRankVO userRank) {
		this.userRank = userRank;
	}

	public List<UserRankVO> getRankList() {
		return rankList;
	}

	public void setRankList(List<UserRankVO> rankList) {
		this.rankList = rankList;
	}

	public String stats() throws Exception {
		this.rankList = this.statsService.getUserRankList(super.getLoginId());
		for (UserRankVO userRank : rankList) {
			if(userRank.getUsername().equals(super.getLoginId())){
				this.userRank = userRank;
				break;
			}
		}
		return SUCCESS;
	}
}
