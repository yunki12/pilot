package com.pilot.pilot.biz.common;

import com.pilot.pilot.biz.common.service.CommonCodeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
public class CommonServiceTests {

	@Autowired
	private CommonCodeService commonCodeService;

	@Test
	public void select() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("select : ");
		try {
			commonCodeService.selectCommonCodeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	}
}