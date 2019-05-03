package com.pilot.pilot.instatnce;

import com.pilot.pilot.vo.CommonCode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
public class CommonCodeSortingHelper {
	private Map<String, Object> map = new LinkedHashMap<String, Object>();

	public CommonCodeSortingHelper(List<CommonCode> list) {
		this.sort(list);
	}

	/**
	 * 정렬
	 * @param list
	 */
	public void sort(List<CommonCode> list) {
		for (int i = 0, size = list.size(); i < size; i++) {
			CommonCode dto = (CommonCode) list.get(i);
			this.add(dto);
		}
	}

	/**
	 * 데이터 추가
	 * @param vo
	 */
	@SuppressWarnings({ "unchecked" })
	public void add(CommonCode vo) {
		String istId = vo.getMain_code();
		if (map.containsKey(istId)) {
			((List<CommonCode>) map.get(istId)).add(vo);
		} else {
			List<CommonCode> list = new LinkedList<CommonCode>();
			list.add(vo);
			map.put(istId, list);
		}
	}

	/**
	 * Map 반환
	 * @return
	 */
	public Map<String, Object> getCodeMap() {
		return this.map;
	}
}
