package com.zero.billiards.dataobject.vo;

/**
 * 用户排名
 * @author wanglinzi
 * @version 1.0
 * 2013年8月13日 下午6:20:57
 */
public class UserRankVO {
	private Integer userId;
	private String username;
	private String realName;
	/**
	 * 胜场数
	 */
	private Integer wins;

	/**
	 * 输场数
	 */
	private Integer losses;
	/**
	 * 胜率
	 */
	private double winPercentage;
	
	
	private Integer amount;
	
	@Override
	public String toString() {
		return "UserRankVO [id=" + userId + ", username=" + username
				+ ", realName=" + realName + ", wins=" + wins + ", losses="
				+ losses + ", winPercentage=" + winPercentage + "]";
	}

	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}