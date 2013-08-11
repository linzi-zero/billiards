package com.zero.billiards.dataobject.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

@Entity
@Table(name="t_user")
public class TUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public List<TGameDetailRecord> getWinList() {
		return winList;
	}
	public void setWinList(List<TGameDetailRecord> winList) {
		this.winList = winList;
	}
	public List<TGameDetailRecord> getLoseList() {
		return loseList;
	}
	public void setLoseList(List<TGameDetailRecord> loseList) {
		this.loseList = loseList;
	}
	@Column(name="user_name", length=15)
    private String username;
    
    @Column(name="password", length=15)
    private String password;
    
    @Column(name="real_name",length=20)
    private String realName;
    
    @OneToMany(fetch=FetchType.LAZY,targetEntity=TGameDetailRecord.class,mappedBy="winner")
    private List<TGameDetailRecord> winList;
    
    @OneToMany(fetch=FetchType.LAZY,targetEntity=TGameDetailRecord.class,mappedBy="loser")
    private List<TGameDetailRecord> loseList;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}