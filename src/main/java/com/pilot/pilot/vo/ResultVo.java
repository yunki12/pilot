package com.pilot.pilot.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 2019-03-21
 *
 * @author yoongibum
 */
@Data
public class ResultVo<T>{
	private String status;
	private String code;
	private String message;
	private T data;
}