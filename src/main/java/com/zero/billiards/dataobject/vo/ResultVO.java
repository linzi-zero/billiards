package com.zero.billiards.dataobject.vo;

public class ResultVO {
	private Integer id;
	
	private Integer winnerBallNum;
	
	private Integer loserBallNum;

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
