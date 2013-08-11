package com.zero.billiards.service;

import java.util.Date;
import java.util.List;

import com.zero.billiards.dataobject.param.AddGameDetailRecordParam;
import com.zero.billiards.dataobject.po.TGameDetailRecord;
import com.zero.billiards.dataobject.vo.GameDetailRecordVO;

/**
 * 游戏服务
 * @author wanglinzi
 * @version 1.0
 */
public interface IGameService {

	/**
	 * 保存比赛记录结果
	 * @param param
	 */
	 public void saveGameDetailRecord(AddGameDetailRecordParam param);
	 
	 /**
	  * 获取比赛记录
	  * @param userName
	  * @return
	  */
	 public List<GameDetailRecordVO> findGameDetailRecord(String userName);
	 
	 /**
	  *  获取比赛记录
	  * @param userName
	  * @param startDate
	  * @param endDate
	  * @return
	  */
	 public List<GameDetailRecordVO> findGameDetailRecord(String userName, Date startDate,Date endDate);

	 /**
	  * 删除一条记录
	  * @param id
	  * @param currentUserName
	  */
	public void deleteGameDetailRecord(String currentUserName, Integer id);
}
