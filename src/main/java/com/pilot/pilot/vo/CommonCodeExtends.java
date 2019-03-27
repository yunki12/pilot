package com.pilot.pilot.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by 2019-03-21
 *
 * @author yoongibum
 */
@Data
public class CommonCodeExtends extends MainCommonCode{
	private String small_code;
	private String small_code_name;
	private int sort;
	private String mod_mgn_id;
	private String lang;
}