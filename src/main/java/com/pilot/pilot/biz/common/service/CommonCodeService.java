package com.pilot.pilot.biz.common.service;

import com.pilot.pilot.biz.common.mapper.CommonMapper;
import com.pilot.pilot.vo.CommonCode;
import com.pilot.pilot.vo.CommonCodeExtends;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
@Service
public class CommonCodeService {
	private static final Logger logger = LoggerFactory.getLogger(CommonCodeService.class);

	@Autowired
	private CommonMapper commonMapper;

	@Transactional(readOnly = true)
	public List<CommonCodeExtends> selectCommonCodeList() throws Exception {
		List<CommonCodeExtends> selectResult =	commonMapper.selectCommonCodeList();
		return selectResult;
	}

	/**
	 * 공통코드를 조회한다.
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<CommonCode> selectList() throws Exception{
		return commonMapper.selectList();
	}
}