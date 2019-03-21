package com.pilot.pilot.common;

import com.pilot.pilot.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */

@Component
public class PilotListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CommonService commonService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("onApplicationEvent  ");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		commonService.select();
	}
}