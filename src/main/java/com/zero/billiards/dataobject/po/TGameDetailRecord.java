package com.zero.billiards.dataobject.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="t_game_detail_record")
public class TGameDetailRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private	Date endTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="winner_id")
	private TUser winner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loser_id")
	private TUser loser;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="result_id")
	private TResult result;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="match_id",nullable=true)
	private TMatch match;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public TUser getWinner() {
		return winner;
	}

	public void setWinner(TUser winner) {
		this.winner = winner;
	}

	public TUser getLoser() {
		return loser;
	}

	public void setLoser(TUser loser) {
		this.loser = loser;
	}

	public TResult getResult() {
		return result;
	}

	public void setResult(TResult result) {
		this.result = result;
	}

	public TMatch getMatch() {
		return match;
	}

	public void setMatch(TMatch match) {
		this.match = match;
	}
	
}
