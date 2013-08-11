package com.zero.billiards.dao;
import java.util.Date;
import java.util.List;

import com.zero.billiards.dataobject.po.TGameDetailRecord;

public interface IGameDao {
	
	public Integer save(TGameDetailRecord gameRecord);

	public List<TGameDetailRecord> findGameDetailRecord(String userName);

	public List<TGameDetailRecord> findGameDetailRecord(String userName,
			Date startDate, Date endDate);

	public void deleteGameDetailRecord(Integer id);
	
	public TGameDetailRecord get(Integer id);

}