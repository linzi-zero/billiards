package com.alibaba.billiards.service.test;
import java.util.List;

import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.zero.billiards.dataobject.po.TGameDetailRecord;


public class BaseSpringTestCase extends AbstractTransactionalSpringContextTests {
	public static final int PAGE_NUMBER_1 = 1;
	public static final int PAGE_SIZE_10 = 10;

	public BaseSpringTestCase() {
		super();
		super.setPopulateProtectedVariables(true);
		super.setAutowireMode(AUTOWIRE_BY_NAME);
	}

	public BaseSpringTestCase(String arg0) {
		super(arg0);
		super.setPopulateProtectedVariables(true);
		super.setAutowireMode(AUTOWIRE_BY_NAME);
	}

	@Override
	protected String[] getConfigLocations() {
//		return new String[] {
//				"file:WebContent/WEB-INF/applicationContext-*.xml",
//				"classpath*:resources/**/*-spring.xml",
//		};
		return new String[] {
				 "classpath*:applicationContext-*.xml",
		};
	}
	
	public void test(){
		//this.setComplete();//提交
	}
}
