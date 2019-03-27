package com.pilot.pilot.biz.common.mapper;

import com.pilot.pilot.vo.CommonCode;
import com.pilot.pilot.vo.CommonCodeExtends;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 2018-12-17
 *
 * @author yoongibum
 */
@Repository
public interface CommonMapper {

	List<CommonCodeExtends> selectCommonCodeList() throws Exception;

	List<CommonCode> selectList() throws Exception;
}