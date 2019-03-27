package com.pilot.pilot.instatnce;

import com.pilot.pilot.vo.CommonCode;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 2019-03-21
 *
 * @author yoongibum
 */
@Slf4j
public class CommonCodeInstatnce {
	public static LinkedHashMap mCmmnCodeTables;
	//private static CommonCodeInstatnce commonCodeInstatnce;

	/**
	 * DCL(Double-Checked-Locking) Singleton 패턴
	 * @return
	 */
	/*
	public static CommonCodeInstatnce getCommonCodeInstatnce() {
		if(null == commonCodeInstatnce) {
			synchronized (CommonCodeInstatnce.class) {
				if(null == commonCodeInstatnce) {
					log.debug("commonCodeInstatnce is null");
					commonCodeInstatnce = new CommonCodeInstatnce();
				}
			}
		}

		return commonCodeInstatnce;
	}
	*/

	/**
	 * LazyHolder Singleton 패턴
	 * @return
	 */
	public static CommonCodeInstatnce getCommonCodeInstatnce() {
		return LazyHolder.instance;
	}

	private static class LazyHolder {
		private static final CommonCodeInstatnce instance = new CommonCodeInstatnce();
	}

	/**
	 * 그룹별 Instance 추가
	 * @param aNewCodeTable
	 */
	@SuppressWarnings ("unchecked")
	public void addCodeTable(CommonCodeTable aNewCodeTable) {
		mCmmnCodeTables.put(aNewCodeTable.getGroupCode(), aNewCodeTable);
	}

	/**
	 * groupCode -> groupNm
	 * @param groupCode
	 * @return
	 * @throws Exception
	 */
	public static String lookUpGroupNm(String groupCode) throws Exception {
		try {
			CommonCodeTable codeTableInFocus = (CommonCodeTable) mCmmnCodeTables.get(groupCode);
			return codeTableInFocus.getGroupNm();
		}
		catch (Exception ex) {
			throw new Exception("Fail to find groupNm for the groupCode '" + groupCode + "'");
		}
	}

	/**
	 * groupCode + codeNm => code
	 * @param groupCode
	 * @param codeNm
	 * @return
	 * @throws Exception
	 */
	public static String lookUpCode(String groupCode, String codeNm) throws Exception {
		try {
			CommonCodeTable codeTableInFocus = (CommonCodeTable) mCmmnCodeTables.get(groupCode);
			return codeTableInFocus.getCodeForText(codeNm);
		}
		catch (Exception ex) {
			throw new Exception("Fail to find code for '" + codeNm + "' for the groupCode '" + groupCode + "'");
		}
	}

	/**
	 * groupCode + code => codeNm
	 * @param groupCode
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String lookUpCodeNm(String groupCode, String code) throws Exception {
		try {
			CommonCodeTable codeTableInFocus = (CommonCodeTable) mCmmnCodeTables.get(groupCode);
			return codeTableInFocus.getTextForCode(code);
		}
		catch (Exception ex) {
			throw new Exception("Fail to find meaningful name for groupCode '" + groupCode + "' inside code '" + code + "'");
		}
	}

	/**
	 * 해당 groupCode에 대한 코드테이블이 존재하는지 검사
	 * @param groupCode
	 * @return
	 */
	public boolean codeTableExistsForType(String groupCode) {
		return (mCmmnCodeTables.get(groupCode) != null);
	}

	/**
	 * 모든 코드테이블 객체배열을 얻어옴
	 * @return
	 */
	@SuppressWarnings ("rawtypes")
	public static CommonCodeTable[] getCodeTables() {

		CommonCodeTable[] codeTableList = new CommonCodeTable[mCmmnCodeTables.size()];
		int j = 0;

		for (Iterator i = mCmmnCodeTables.keySet().iterator(); i.hasNext();) {
			String key = (String) i.next();
			codeTableList[j++] = (CommonCodeTable) mCmmnCodeTables.get(key);
		}

		return codeTableList;
	}

	/**
	 * 모든 코드테이블 이름을 배열로 얻어옴
	 * @return
	 */
	@SuppressWarnings ("rawtypes")
	public String[] listCodeTableNames() {

		String[] namelist = new String[mCmmnCodeTables.size()];
		int j = 0;

		for (Iterator i = mCmmnCodeTables.keySet().iterator(); i.hasNext();) {

			String key = (String) i.next();
			namelist[j++] = key;
		}
		return namelist;
	}

	/**
	 * groupCode의 코드배열
	 * @param groupCode
	 * @return
	 */
	public String[] listCodes(String groupCode) {
		return getCodeTableForType(groupCode).listCodes();
	}

	/**
	 * groupCode의 코드명배열
	 * @param groupCode
	 * @return
	 */
	public String[] listInstanceTexts(String groupCode) {
		return getCodeTableForType(groupCode).listCodeNms();
	}

	/**
	 * 해당 code에 대한 CodeDescriptor객체를 구함
	 * @param groupCode
	 * @param code
	 * @return
	 */
	public CommonCode getCodeDescriptor(String groupCode, String code) {
		return getCodeTableForType(groupCode).getCodeDescriptor(code);
	}

	/**
	 * 코드테이블을 인스턴스의 코드리스트 Map으로 변환(ms_cd, ms_nm)
	 * @param groupCode
	 * @return
	 */
	public static Map<String, Object> getCodeMap(String groupCode) {

		CommonCodeTable codeTable = getCodeTableForType(groupCode);
		String[] codes = codeTable.listCodes();
		String[] meanings = codeTable.listCodeNms();
		Map<String, Object> map = new LinkedHashMap<String, Object>(codes.length);

		for (int i = 0, size = codes.length; i < size; i++) {
			map.put(codes[i], meanings[i]);
		}

		return map;
	}

	/**
	 * 코드테이블을 인스턴스의 코드리스트 Map으로 변환(ms_nm, ms_cd)
	 * @param groupCode
	 * @return
	 */
	public static Map<String, Object> getCodeNmMap(String groupCode) {

		CommonCodeTable codeTable = getCodeTableForType(groupCode);
		String[] codes = codeTable.listCodes();
		String[] meanings = codeTable.listCodeNms();
		Map<String, Object> map = new LinkedHashMap<String, Object>(codes.length);

		for (int i = 0, size = codes.length; i < size; i++) {
			map.put(meanings[i], codes[i]);
		}

		return map;
	}

	/**
	 * 해당 groupCode에 대한 하위 분류 코드테이블을 얻어옴
	 * @param groupCode
	 * @return
	 */
	public static CommonCodeTable getCodeTableForType(String groupCode) {
		return (CommonCodeTable) mCmmnCodeTables.get(groupCode);
	}

	/**
	 * 코드를 초기화 함
	 */
	/*
	public void reset() {
		log.debug("CmmnCode Instance Init");
		if(mCmmnCodeTables!=null) {
			mCmmnCodeTables.clear();
		}
		mInstance = null;
	}
	*/
}