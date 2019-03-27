package com.pilot.pilot.service.common.service;

import com.pilot.pilot.biz.common.service.CommonCodeService;
import com.pilot.pilot.instatnce.CommonCodeInstatnce;
import com.pilot.pilot.instatnce.CommonCodeSortingHelper;
import com.pilot.pilot.instatnce.CommonCodeTable;
import com.pilot.pilot.vo.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 2019-03-27
 *
 * @author yoongibum
 */
@Slf4j
@Service
public class CommonCodeManagementService {

	@Autowired
	private CommonCodeService commonCodeService;

	public void setCommonCodeInstance() {
		log.info("-----------------------------------");
		log.info("setCommonCodeInstance");

		try {
			List<CommonCode> commonCodeLit = new ArrayList<CommonCode>();
			Map<String, Object> codeMap = new HashMap<String, Object>();
			String ma_cd = "";
			String ma_nm = "";
			List<CommonCode> codeList = new ArrayList<CommonCode>();

			commonCodeLit = commonCodeService.selectList();

			if (commonCodeLit != null && commonCodeLit.size() > 0) {

				// Map<대분류코드, 대분류코드의코드리스트> 반환
				CommonCodeSortingHelper sorting = new CommonCodeSortingHelper(commonCodeLit);
				codeMap = sorting.getCodeMap();

				for (Iterator<String> itr = codeMap.keySet().iterator(); itr.hasNext();) {
					ma_cd = (String) itr.next();
					codeList = (List<CommonCode>)codeMap.get(ma_cd);  // 각 그룹에 포함된 코드리스트

					if (codeList == null) {
						// 그룹코드는 존재하지만 하위 코드들이 없는 경우
						log.debug("setCodeIntanceInfo list is null");
						continue;
					}

					CommonCode[] codeDescriptor = new CommonCode[codeList.size()];
					log.debug("["+ma_cd+"]'s code count : " + codeList.size());

					for (int j = 0, size = codeList.size(); j < size; j++) {

						CommonCode commonCode = (CommonCode) codeList.get(j);

						if (j == 0) {
							ma_nm = commonCode.getMain_code_name();
						}

						codeDescriptor[j] = new CommonCode(commonCode.getMain_code(), commonCode.getMain_code_name());
					} // End of for (int j = 0, size = list.size(); j < size; j++)

					// 그룹별 Instance Add
					CommonCodeInstatnce.getCommonCodeInstatnce();
					CommonCodeInstatnce.getCommonCodeInstatnce().addCodeTable(new CommonCodeTable(ma_cd, ma_nm, codeDescriptor));

					log.info("공통코드 Instance Loaded [" + ma_cd + "][" + ma_nm + "] (" + codeList.size() + " codes)");
					if (CommonCodeInstatnce.getCommonCodeInstatnce() == null) {
						log.error("공톧코드 getInstance is null... ");
					}

				}
			} else {
				log.error("commonCodeListMap null");
				throw new Exception("commonCodeListMap null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

		log.info("-----------------------------------");
	}
}