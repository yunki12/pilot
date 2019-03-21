package com.pilot.pilot.common.service;

import com.pilot.pilot.common.mapper.CommonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
@Service
public class CommonService {
	private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

	@Autowired
	private CommonMapper commonMapper;

/*	@Value("${name}")
	private String name;*/

	public void select() {
		try {
			//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//System.out.println("commonService : ");
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			logger.info("commonService : ");
			//logger.info("name : " + name);
			commonMapper.select();
			//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}