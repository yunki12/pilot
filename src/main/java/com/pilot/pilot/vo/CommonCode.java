package com.pilot.pilot.vo;

import lombok.Data;

/**
 * Created by 2019-03-27
 *
 * @author yoongibum
 */
@Data
public class CommonCode {
	private String code;
	private String codeNm;
	private String main_code; // 대분류코드
	private String main_code_name; // 대분류코드명
	private String small_code; // 상세분류코드
	private String small_code_name; // 상세분류코드명
	private String main_use_yn; // 대분류사용여부
	private String small_use_yn; // 상세분류사용여부

	public CommonCode(String code, String codeNm) {
		this.code = code;
		this.codeNm = codeNm;
	}
}