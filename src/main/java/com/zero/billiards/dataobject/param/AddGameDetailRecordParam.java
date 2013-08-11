package com.zero.billiards.dataobject.param;

/**
 * 比赛结果参数
 * @author wanglinzi
 * @version 1.0
 */
public class AddGameDetailRecordParam {
	private Integer matchId;
	/**
	 * 我剩余球数
	 */
	private Integer ballNum;
	/**
	 * 对手剩余球数
	 */
	private Integer opponentBallNum;
	
	/**
	 * 对手UserID
	 */
	private Integer opponentId;
	/**
	 * 当前UserName
	 */
	private String userName;
	
	/**
	 * 是否赢 true 我赢，false:我输
	 */
	private boolean isWin;
	
	public Integer getBallNum() {
		return ballNum;
	}
	public void setBallNum(Integer ballNum) {
		this.ballNum = ballNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getOpponentBallNum() {
		return opponentBallNum;
	}
	public void setOpponentBallNum(Integer opponentBallNum) {
		this.opponentBallNum = opponentBallNum;
	}
	public Integer getOpponentId() {
		return opponentId;
	}
	public void setOpponentId(Integer opponentId) {
		this.opponentId = opponentId;
	}
	public boolean getIsWin() {
		return isWin;
	}
	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
}
