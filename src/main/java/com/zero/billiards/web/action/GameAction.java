package com.zero.billiards.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.billiards.dataobject.param.AddGameDetailRecordParam;
import com.zero.billiards.dataobject.vo.GameDetailRecordVO;
import com.zero.billiards.dataobject.vo.ResultVO;
import com.zero.billiards.dataobject.vo.UserOpponentVO;
import com.zero.billiards.service.IGameService;
import com.zero.billiards.service.IResultService;
import com.zero.billiards.service.IUserService;
import com.zero.billiards.web.common.BaseAction;

/**
 * 比赛action
 * @author wanglinzi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GameAction extends BaseAction {

	@Resource(name = "userService")
	private IUserService userService;
	@Autowired
	private IResultService resultService;
	@Autowired
	private IGameService gameService;

	/**
	 * DTO List
	 */
	private List<UserOpponentVO> users;
	private List<ResultVO> results;
	private List<GameDetailRecordVO> records;
	private AddGameDetailRecordParam param;
	private String startDate;
	private String endDate;
	private Integer delRecordId;
	
	public Integer getDelRecordId() {
		return delRecordId;
	}

	public void setDelRecordId(Integer delRecordId) {
		this.delRecordId = delRecordId;
	}

	public List<GameDetailRecordVO> getRecords() {
		return records;
	}

	public void setRecords(List<GameDetailRecordVO> records) {
		this.records = records;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IResultService getResultService() {
		return resultService;
	}

	public void setResultService(IResultService resultService) {
		this.resultService = resultService;
	}


	public List<UserOpponentVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserOpponentVO> users) {
		this.users = users;
	}

	public List<ResultVO> getResults() {
		return results;
	}

	public void setResults(List<ResultVO> results) {
		this.results = results;
	}
	public AddGameDetailRecordParam getParam() {
		return param;
	}

	public void setParam(AddGameDetailRecordParam param) {
		this.param = param;
	}
	/**
	 * 输入结果页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inputResultPage() throws Exception {
		this.users = userService.findOpponent(super.getLoginId());
		this.results = this.resultService.findAll();
		return INPUT;
	}

	/**
	 * 提交结果保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String submitResult() throws Exception {
		if(param == null){
			super.setMessage("错误！重新输入!!!");
			return SUCCESS;
		}
		//当前用户名
		param.setUserName(super.getLoginId());
		this.gameService.saveGameDetailRecord(param);
		super.setMessage("录入成功!");
		return SUCCESS;
	}
	
	/**
	 * 获取比赛记录
	 * @return
	 */
	public String findGameDetailRecord(){
		if(this.getStartDate() == null || this.getEndDate() == null){
			records = this.gameService.findGameDetailRecord(super.getLoginId());
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date startD = sdf.parse(startDate+" 00:00:00");
				Date endD = sdf.parse(endDate+" 23:59:59");
				
				records = this.gameService.findGameDetailRecord(super.getLoginId(), startD, endD);
			} catch (ParseException e) {
				LogFactory.getLog(this.getClass()).info("日期格式不正确");
				return "search";
			}
			
		}
		return "result";
	}
	
	/**
	 * 删除一条比赛记录
	 * @return
	 */
	public String deleteRecord(){
		if(delRecordId == null){
			super.setMessage("错误！参数不正确!");
			return "findGameDetailRecord";
		}
		this.gameService.deleteGameDetailRecord(super.getLoginId(), delRecordId);
		return "findGameDetailRecord";
	}

}
