package com.pilot.pilot.common;

import com.pilot.pilot.common.service.CommonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
public class CommonServiceTests {

	@Autowired
	private CommonService commonService;

	@Test
	public void select() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("select : ");
		commonService.select();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	}
}