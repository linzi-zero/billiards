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
@Table(name="t_match")
public class TMatch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",length=40)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="type_id")
	private TMatchType matchType;
	
	@Column(name="begin_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(length=200)
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TMatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(TMatchType matchType) {
		this.matchType = matchType;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
