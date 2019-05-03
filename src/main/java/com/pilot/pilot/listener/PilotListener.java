package com.pilot.pilot.listener;

import com.pilot.pilot.service.common.service.CommonCodeManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */

@Slf4j
@Component
public class PilotListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CommonCodeManagementService commonCodeManagementService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		try {
			//commonService.selectCommonCodeList();
			commonCodeManagementService.setCommonCodeInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}