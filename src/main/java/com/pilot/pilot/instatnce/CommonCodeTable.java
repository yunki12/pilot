package com.pilot.pilot.instatnce;

import com.pilot.pilot.vo.CommonCode;

public class CommonCodeTable {
	private String maCode = "";
	private String maNm = "";
	private CommonCode[] msCodeList = null;

	/**
	 * 그룹코드및하위코드리스트 Set
	 * @param maCode
	 * @param maNm
	 * @param codelist
	 */
	public CommonCodeTable(String maCode, String maNm, CommonCode[] codelist) {
		this.maCode  = maCode;
		this.maNm    = maNm;
		this.msCodeList  = codelist;
	}

	/**
	 * 인스턴스코드값(key)의 리스트를 배열로 구함
	 * @return
	 */
	public String[] listCodes() {
		String[] codes = new String[msCodeList.length];
		for (int i = 0; i < msCodeList.length; i++) {
			codes[i] = msCodeList[i].getCode();
		}
		return codes;
	}

	/**
	 * 인스턴스코드명 (codeNm)의 리스트를 배열로 구함
	 * @return
	 */
	public String[] listCodeNms() {
		String[] meanings = new String[msCodeList.length];
		for (int i = 0; i < msCodeList.length; i++) {
			meanings[i] = msCodeList[i].getCodeNm();
		}
		return meanings;
	}

	/**
	 * 해당코드에 대한 인스턴스코드명 (codeNm)을 구함
	 * @param instanceCd
	 * @return
	 */
	public String getTextForCode(String instanceCd) {
		for (int i = 0; i < msCodeList.length; i++) {
			if (msCodeList[i].getCode().equalsIgnoreCase(instanceCd))
			return msCodeList[i].getCodeNm();
		}
		return null;
	}

	/**
	 * 해당코드명에 대한 인스턴스코드값(instanceCd)을 구함
	 * @param codeNm
	 * @return
	 */
	public String getCodeForText(String codeNm) {
		for (int i = 0; i < msCodeList.length; i++) {
			if (msCodeList[i].getCodeNm().equalsIgnoreCase(codeNm))
			return msCodeList[i].getCode();
		}
		return null;
	}

	/**
	   * 해당 code에 대한 CodeDescriptor객체를 구함
	   * @param code
	   * @return
	*/
	public CommonCode getCodeDescriptor(String code) {
		for (int i = 0; i < msCodeList.length; i++) {
			if (code.equalsIgnoreCase(msCodeList[i].getCode()))
			return msCodeList[i];
		}
		return null;
	}

	/**
	 * 해당 instanceCd에 대한 CodeDescriptor객체를 구함
	 * @param code
	 * @param newCodeList
	 */
	public void setCodeDescriptor(String code, CommonCode newCodeList) {
		for (int i = 0; i < msCodeList.length; i++) {
			if (code.equalsIgnoreCase(msCodeList[i].getCode()))
				msCodeList[i] = newCodeList;
		}
	}

	public String getGroupCode() {
		return maCode;
	}

	public CommonCode[] getCodeDescriptors() {
		return msCodeList;
	}

	public String getGroupNm() {
		return maNm;
	}
}
