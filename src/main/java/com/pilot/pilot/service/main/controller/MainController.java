package com.pilot.pilot.service.main.controller;

import com.pilot.pilot.biz.common.service.CommonCodeService;
import com.pilot.pilot.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 2019-03-21
 *
 * @author yoongibum
 */
@Slf4j
@RestController
@RequestMapping("/main")
public class MainController {

	@Autowired
	private CommonCodeService commonCodeService;

	@GetMapping(value = "/test")
	public ResponseEntity<ResultVo> main() {
		log.info("---------------- main");
		ResultVo resultVo = new ResultVo();

		try {
			commonCodeService.selectCommonCodeList();
			resultVo.setCode("0000");
			resultVo.setMessage("SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResultVo>(resultVo, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResultVo>(resultVo, HttpStatus.OK);
	}
}