package com.alibaba.billiards.service.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.zero.billiards.dataobject.vo.GameDetailRecordVO;
import com.zero.billiards.service.IGameService;

public class GameServiceTest extends BaseSpringTestCase {
	
	@Autowired
	IGameService gameService;
	
	public void testRecord2(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<GameDetailRecordVO> list;
		try {
			list = this.gameService.findGameDetailRecord(
					"wlz", sdf.parse("2013-07-25 00:00:00"),sdf.parse("2013-07-25 23:59:59"));
			System.out.println("--------调用成功2---------"+ list.size());
			this.print(list);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("--------调用失败2---------"+e);
		}
		//this.setComplete();//提交
	}
	
	public void testFindGameDetailRecord1(){
		List<GameDetailRecordVO> list = this.gameService.findGameDetailRecord("wlz");
		this.print(list);
		System.out.println("--------调用成功1---------"+ list.size());
	}
	
	private void print(List<GameDetailRecordVO> list){
		for (GameDetailRecordVO gameDetailRecordVO : list) {
			System.out.println(gameDetailRecordVO);
		}
	}
	
}
	