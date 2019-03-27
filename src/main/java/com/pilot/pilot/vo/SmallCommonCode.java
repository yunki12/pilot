package com.pilot.pilot.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 2019-03-21
 *
 * @author yoongibum
 */
@Data
public class SmallCommonCode implements Serializable{
	private String main_code;
	private String small_code;
	private String small_code_name;
	private int sort;
	private String mod_mgn_id;
	private Date mod_dt;
	private String lang;
	private String use_yn;
	private String rem;
}