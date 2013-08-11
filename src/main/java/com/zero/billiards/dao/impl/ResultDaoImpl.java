package com.zero.billiards.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zero.billiards.dao.IResultDao;
import com.zero.billiards.dao.MyHibernateDaoSupport;
import com.zero.billiards.dataobject.po.TResult;

@Repository("resultDao")        //声明此类为数据持久层的类
public class ResultDaoImpl extends MyHibernateDaoSupport implements IResultDao {

	@SuppressWarnings("unchecked")
	public List<TResult> findAllResult() {
		return this.getHibernateTemplate().loadAll(TResult.class);
	}

	public TResult getResultByBallNum(Integer winnerBallNum,
			Integer loserBallNum) {
		@SuppressWarnings("unchecked")
		List<TResult> list = this.getHibernateTemplate().find("from TResult where winnerBallNum=? and loserBallNum=?",new Integer[]{winnerBallNum, loserBallNum});
		if(list.size() == 1)
			return list.get(0);
		return null;
	}
    
}
