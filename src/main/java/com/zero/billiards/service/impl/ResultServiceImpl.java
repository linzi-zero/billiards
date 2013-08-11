package com.zero.billiards.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.billiards.dao.IResultDao;
import com.zero.billiards.dataobject.po.TResult;
import com.zero.billiards.dataobject.vo.ResultVO;
import com.zero.billiards.service.IResultService;

@Service("resultService")
public class ResultServiceImpl implements IResultService {

	@Autowired
	private IResultDao resultDao;
	@Autowired
	private Mapper beanMapper;
	
	public List<ResultVO> findAll() {
		List<TResult> results = this.resultDao.findAllResult();
		List<ResultVO> resultVOList = new ArrayList<ResultVO>(0);
		ResultVO vo = null;
		for (TResult tResult : results) {
			vo = this.beanMapper.map(tResult, ResultVO.class);
			resultVOList.add(vo);
		}
		return resultVOList;
	}

}
