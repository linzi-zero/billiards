package com.zero.billiards.service;

import java.util.List;

import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.dataobject.vo.UserLoginVO;
import com.zero.billiards.dataobject.vo.UserOpponentVO;
import com.zero.billiards.dataobject.vo.UserVO;
import com.zero.billiards.exception.PasswordNotMatchException;
import com.zero.billiards.exception.UserNotFoundException;

/**
 * 用户服务接口
 * @author wanglinzi
 * @version 1.0
 */
public interface IUserService {
	 public void save(TUser user);
	 
	 /**
	  * 用户登录
	  * @param userName
	  * @param Password
	  * @return  UserLoginVO
	  * @throws UserNotFoundException 
	  * @throws PasswordNotMatchException
	  */
	 public UserLoginVO login(String userName,String Password)  throws UserNotFoundException, PasswordNotMatchException;
	 
	 /**
	  * 获取比赛所有对手
	  * @param userName
	  * @return List<UserOpponentVO>
	  */
	 public List<UserOpponentVO> findOpponent(String userName); 
	 
	 /**
	  * 根据userName获取用户信息
	  * @param userName
	  * @return UserVO
	  */
	 public UserVO getUserByUsername(String userName);
	 
	 /**
	  * 根据userId获取用户信息
	  * @param id
	  * @return UserVO
	  */ 
	 public UserVO getUserById(Integer id);
}
