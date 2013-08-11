package com.zero.billiards.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zero.billiards.dao.IGameDao;
import com.zero.billiards.dao.MyHibernateDaoSupport;
import com.zero.billiards.dataobject.po.TGameDetailRecord;

@Repository("gameDao")
public class GameDaoImpl extends MyHibernateDaoSupport implements IGameDao {

	public Integer save(TGameDetailRecord gameRecord) {
		return (Integer) super.getHibernateTemplate().save(gameRecord);
	}

	@SuppressWarnings("unchecked")
	public List<TGameDetailRecord> findGameDetailRecord(String userName) {
		return this
				.getHibernateTemplate()
				.find("from TGameDetailRecord t where t.loser.username =? or t.winner.username=? order by endTime desc",
						new String[] { userName, userName });
	}

	@SuppressWarnings("unchecked")
	public List<TGameDetailRecord> findGameDetailRecord(String userName,
			Date startDate, Date endDate) {
		return this
				.getHibernateTemplate()
				.find("from TGameDetailRecord t where (t.loser.username =? or t.winner.username=?) and  t.endTime >= ? and t.endTime <= ?   order by endTime desc",
						new Object[] { userName,userName, startDate, endDate });
	}

	public void deleteGameDetailRecord(Integer id) {
		TGameDetailRecord record = new TGameDetailRecord();
		record.setId(id);
		this.getHibernateTemplate().delete(record);
	}

	public TGameDetailRecord get(Integer id) {
		return (TGameDetailRecord) this.getHibernateTemplate().get(TGameDetailRecord.class, id);
	}

}
