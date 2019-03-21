package com.pilot.pilot.service.main;

import com.pilot.pilot.common.service.CommonService;
import com.pilot.pilot.vo.CateSCode;
import com.pilot.pilot.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

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
	private CommonService commonService;

	@GetMapping(value = "/test")
	public ResponseEntity<ResultVo> main() {
		log.info("@@@@@@@@@@@@@@@@@@@@@");
		log.info("commonService : ");
		commonService.select();
		log.info("@@@@@@@@@@@@@@@@@@@@@");

		ResultVo resultVo = new ResultVo();
		resultVo.setCode("0000");
		resultVo.setMessage("SUCCESS");

		return new ResponseEntity<ResultVo>(resultVo, HttpStatus.OK);
	}
}