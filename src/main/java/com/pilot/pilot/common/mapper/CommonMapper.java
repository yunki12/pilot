package com.pilot.pilot.common.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
@Repository
public interface CommonMapper {

	//public void select() throws Exception {
	//	System.out.println("CommonMapper select");
	//}
	List<Map<String, Object>> select() throws Exception;
}