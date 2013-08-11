package com.zero.billiards.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.billiards.dao.IUserDao;
import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.dataobject.vo.UserLoginVO;
import com.zero.billiards.dataobject.vo.UserOpponentVO;
import com.zero.billiards.dataobject.vo.UserVO;
import com.zero.billiards.exception.PasswordNotMatchException;
import com.zero.billiards.exception.UserNotFoundException;
import com.zero.billiards.service.IUserService;

@Service("userService")        //声明此类为业务逻辑层的类
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private Mapper beanMapper;

    public void save(TUser user){
        userDao.save(user);
    }

    /**
     * 目前只实现用户名登陆
     */
	public UserLoginVO login(String realName, String password)
			throws UserNotFoundException, PasswordNotMatchException {
		TUser user = this.userDao.getUser( realName,  password);
		if(user == null){
			throw new UserNotFoundException("Incorrect username or password! Please try again .");
		}
			
		return this.beanMapper.map(user, UserLoginVO.class);
	}

	public List<UserOpponentVO> findOpponent(String userName) {
		List<TUser> users = this.userDao.findExcludeByUsername(userName);
		
		List<UserOpponentVO> opponentList = new ArrayList<UserOpponentVO>();
		UserOpponentVO vo = null;
		for (TUser tUser : users) {
			vo = this.beanMapper.map(tUser, UserOpponentVO.class);
			opponentList.add(vo);
		}
		return opponentList;
	}

	public UserVO getUserByUsername(String userName) {
		TUser user = this.userDao.getByUserName(userName);
		return this.convertToUserVO(user);
	}

	public UserVO getUserById(Integer id) {
		TUser user = this.userDao.get(id);
		return this.convertToUserVO(user);
	}
	
	/**
	 * bean 转换
	 * @param user
	 * @return
	 */
	private UserVO convertToUserVO(TUser user){
		UserVO vo = null;
		if(user != null){
			vo = this.beanMapper.map(user, UserVO.class);
		}
		return vo;
	}

}