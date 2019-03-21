package com.pilot.pilot.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
@Data
public class CateSCode implements Serializable {
	private String MA_CD;
	private String MS_CD;
	private String MS_NM;
	private String USE_YN;
}