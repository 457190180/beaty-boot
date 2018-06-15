package com.yimew.entity.wechatBase;

import javax.validation.constraints.NotNull;

/** * @author  作者 E-mail: * @date 创建时间：2017年11月16日 下午6:18:09 * @version 1.0 * @parameter  * @since  * @return  */
public class WechatParam {
	private String encryptedData;
	private String iv;
	@NotNull(message = "code不能为空")
	private String code;
	
	private String userId;
	private String evaId;
	private String msg;
	@NotNull(message = "phone不能为空")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEvaId() {
		return evaId;
	}
	public void setEvaId(String evaId) {
		this.evaId = evaId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
