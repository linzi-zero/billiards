package com.zero.billiards.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.billiards.dao.IGameDao;
import com.zero.billiards.dao.IResultDao;
import com.zero.billiards.dao.IUserDao;
import com.zero.billiards.dataobject.param.AddGameDetailRecordParam;
import com.zero.billiards.dataobject.po.TGameDetailRecord;
import com.zero.billiards.dataobject.po.TMatch;
import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.dataobject.vo.GameDetailRecordVO;
import com.zero.billiards.service.IGameService;

@Service("gameService")
public class GameServiceImpl implements IGameService {

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IResultDao resultDao;
	
	@Autowired
	private IGameDao gameDao;
	 
	@Autowired
	private Mapper beanMapper;
	
	public void saveGameDetailRecord(AddGameDetailRecordParam param) {
		if(param == null){
			throw new RuntimeException("比赛结果为NULL");
		}
		
		TGameDetailRecord tRecord = new TGameDetailRecord();
		//当前赢
		if(param.getIsWin()){
			tRecord.setWinner(this.userDao.getByUserName(param.getUserName()));
			tRecord.setLoser(this.userDao.get(param.getOpponentId()));
			tRecord.setResult(this.resultDao.getResultByBallNum(param.getBallNum(), param.getOpponentBallNum()));
		}else{//当前输
			tRecord.setWinner(this.userDao.get(param.getOpponentId()));
			tRecord.setLoser(this.userDao.getByUserName(param.getUserName()));
			tRecord.setResult(this.resultDao.getResultByBallNum(param.getOpponentBallNum(), param.getBallNum()));
		}
		tRecord.setEndTime(new Date());
		
		if(param.getMatchId() != null){
			//TODO 没有开发比赛
			tRecord.setMatch(new TMatch());
		}
		this.gameDao.save(tRecord);
	}

	public List<GameDetailRecordVO> findGameDetailRecord(String userName) {
		List<TGameDetailRecord> list =  this.gameDao.findGameDetailRecord(userName);
		List<GameDetailRecordVO> voList = new ArrayList<GameDetailRecordVO>(0);
		
		for (TGameDetailRecord tGameDetailRecord : list) {
			voList.add(this.convertToVO(tGameDetailRecord));
		}
		
		return voList;
	}

	public List<GameDetailRecordVO> findGameDetailRecord(String userName,
			Date startDate, Date endDate) {
		List<TGameDetailRecord> list =  this.gameDao.findGameDetailRecord(userName,startDate, endDate);
		List<GameDetailRecordVO> voList = new ArrayList<GameDetailRecordVO>(0);
		
		for (TGameDetailRecord tGameDetailRecord : list) {
			voList.add(this.convertToVO(tGameDetailRecord));
		}
		return voList;
	}

	public void deleteGameDetailRecord(String currentUserName, Integer id) {
		TUser user = this.userDao.getByUserName(currentUserName);
		if(user == null){
			throw new RuntimeException("删除比赛记录时，当前用户名不存在无法删除记录:"+ id);
		}
		TGameDetailRecord record = this.gameDao.get(id);
		if(record == null){
			throw new RuntimeException("要删除的记录不存在!");
		}
		if(user.getId() != record.getWinner().getId()){
			throw new RuntimeException("不能删除自己为输的记录!");
		}
		this.gameDao.deleteGameDetailRecord(id);
	}
	
	private GameDetailRecordVO convertToVO(TGameDetailRecord record){
		if(record != null){
			return this.beanMapper.map(record, GameDetailRecordVO.class);
		}
		return null;
	}
}
