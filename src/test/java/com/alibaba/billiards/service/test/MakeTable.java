package com.alibaba.billiards.service.test;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

import com.zero.billiards.dataobject.po.TGameDetailRecord;
import com.zero.billiards.dataobject.po.TMatch;
import com.zero.billiards.dataobject.po.TMatchType;
import com.zero.billiards.dataobject.po.TResult;
import com.zero.billiards.dataobject.po.TUser;

/**
 * 
 * @author wanglinzi
 * 
 */
public class MakeTable {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Configuration config = new AnnotationConfiguration().configure();

		AnnotationConfiguration config = new AnnotationConfiguration().configure();
		config.addAnnotatedClass(TUser.class)
				.addAnnotatedClass(TGameDetailRecord.class)
				.addAnnotatedClass(TMatch.class)
				.addAnnotatedClass(TMatchType.class)
				.addAnnotatedClass(TResult.class);
		
/*
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		new SchemaExport(cfg, connection);*/
		
		SchemaExport se = new SchemaExport(config);
		se.create(true, true);
	}

	public static void updateTable(String[] args) {
		Configuration config = new Configuration().configure();
		SchemaUpdate su = new SchemaUpdate(config);
		su.execute(true, true);
	}
}