package com.alibaba.billiards.service.test;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.billiards.dataobject.vo.UserOpponentVO;
import com.zero.billiards.service.IUserService;

public class UserServiceTest extends BaseSpringTestCase {
	private static final Log log = LogFactory.getLog(UserServiceTest.class);
	
	@Autowired
	IUserService userService;
	
	public void testfindOpponent(){
		List<UserOpponentVO> userOpponentVOList = this.userService.findOpponent("wlz");
		assertNotNull(userOpponentVOList);
		log.info("结果总计：" + userOpponentVOList.size());
	}
	
	
}
	