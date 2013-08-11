package com.zero.billiards.dataobject.vo;

import java.util.Date;

public class GameDetailRecordVO {
	@Override
	public String toString() {
		return "GameDetailRecordVO [id=" + id + ", endTime=" + endTime
				+ ", winnerId=" + winnerId + ", loserId=" + loserId
				+ ", resultId=" + resultId + ", matchId=" + matchId
				+ ", winnerBallNum=" + winnerBallNum + ", loserBallNum="
				+ loserBallNum + "]";
	}
	
	private Integer id;
	private	Date endTime;
	private Integer winnerId;
	private Integer loserId;
	private String winnerUserName;
	private String loserUserName;
	private String winnerRealName;
	private String loserRealName;
	private Integer resultId;
	private Integer matchId;
	private Integer winnerBallNum;
	private Integer loserBallNum;
	
	public String getWinnerRealName() {
		return winnerRealName;
	}
	public void setWinnerRealName(String winnerRealName) {
		this.winnerRealName = winnerRealName;
	}
	public String getLoserRealName() {
		return loserRealName;
	}
	public void setLoserRealName(String loserRealName) {
		this.loserRealName = loserRealName;
	}
	public String getWinnerUserName() {
		return winnerUserName;
	}
	public void setWinnerUserName(String winnerUserName) {
		this.winnerUserName = winnerUserName;
	}
	public String getLoserUserName() {
		return loserUserName;
	}
	public void setLoserUserName(String loserUserName) {
		this.loserUserName = loserUserName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWinnerBallNum() {
		return winnerBallNum;
	}
	public void setWinnerBallNum(Integer winnerBallNum) {
		this.winnerBallNum = winnerBallNum;
	}
	public Integer getLoserBallNum() {
		return loserBallNum;
	}
	public void setLoserBallNum(Integer loserBallNum) {
		this.loserBallNum = loserBallNum;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}
	public Integer getLoserId() {
		return loserId;
	}
	public void setLoserId(Integer loserId) {
		this.loserId = loserId;
	}
	public Integer getResultId() {
		return resultId;
	}
	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	

}
