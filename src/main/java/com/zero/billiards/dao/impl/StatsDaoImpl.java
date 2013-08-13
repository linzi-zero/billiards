package com.zero.billiards.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.zero.billiards.dao.IStatsDao;
import com.zero.billiards.dao.MyHibernateDaoSupport;
import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.dataobject.vo.UserRankVO;

/**
 * 
 * @author wanglinzi
 * @version 1.0 2013年8月13日 下午6:37:39
 */
@Repository("statsDao")
public class StatsDaoImpl extends MyHibernateDaoSupport implements IStatsDao {
	private static final String USER_RANK_DESC_SQL = "select t1.id, t1.user_name, t1.real_name, amount, wins, amount-wins as losses, "
			+ "case when amount=0 then 0 else  0+(CAST((wins/amount)*100 AS CHAR(5)))   end as winPercentage "
			+ " from (select u.id,u.user_name,u.real_name,count(d.id) amount "
			+ " from t_user u "
			+ "left join t_game_detail_record d "
			+ "on u.id = d.loser_id or u.id = d.winner_id "
			+ "group by u.id,u.user_name,u.real_name) t1 "
			+ " join (select u.id,count(d.id) wins from t_user u "
			+ "left join t_game_detail_record d "
			+ "on u.id = d.winner_id "
			+ "group by u.id) t2 "
			+ " on t1.id = t2.id "
			+ " order by winPercentage desc";
	// cannot use count(0) query
	private static final String GET_WINS = "select count(*) from TGameDetailRecord t where t.winner.id=?";
	private static final String GET_LOSSES = "select count(*) from TGameDetailRecord t where t.loser=?";
	
	public Integer getWins(Integer userId) {
		Object count = this
				.getSession()
				.createQuery(GET_WINS)
				.setParameter(0, userId).uniqueResult();
		return ((Long) count).intValue();
	}

	public Integer getLosses(Integer userId) {
		TUser user = new TUser();
		user.setId(userId);
		
		Object count = this
				.getSession()
				.createQuery(GET_LOSSES)
				.setParameter(0, user).uniqueResult();
		return ((Long) count).intValue();
	}

	public List<UserRankVO> getUserRankList() {
		//id	user_name	real_name	amount	wins	losses	winPercentage
		List<Object[]> userRankList = this.getSession()
											.createSQLQuery(USER_RANK_DESC_SQL)
											.addScalar("id", Hibernate.INTEGER)
											.addScalar("user_name", Hibernate.STRING)
											.addScalar("real_name", Hibernate.STRING)
											.addScalar("amount", Hibernate.INTEGER)
											.addScalar("wins", Hibernate.INTEGER)
											.addScalar("losses", Hibernate.INTEGER)
											.addScalar("winPercentage", Hibernate.DOUBLE)
											.list();
		List<UserRankVO> list  = new ArrayList<UserRankVO>(0);
		UserRankVO vo = null;
		for (Object object[] : userRankList) {
			vo = new UserRankVO();
			vo.setUserId((Integer) object[0]);
			vo.setUsername(object[1].toString());
			vo.setRealName(object[2].toString());
			vo.setAmount((Integer) object[3]);
			vo.setWins((Integer) object[4]);
			vo.setLosses((Integer) object[5]);
			vo.setWinPercentage((Double) object[6]);
			list.add(vo);
		}
		return list;
	}

}
