package com.zero.billiards.dataobject.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_result")
public class TResult {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="winner_ball_num")
	private Integer winnerBallNum;
	
	@Column(name="loser_ball_num")
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
