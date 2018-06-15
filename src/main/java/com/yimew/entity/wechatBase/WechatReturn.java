package com.yimew.entity.wechatBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** * @author  作者 E-mail: * @date 创建时间：2017年11月22日 上午11:02:02 * @version 1.0 * @parameter  * @since  * @return  */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class WechatReturn {
	
	@XmlElement
	private String return_code;
	@XmlElement
	private String return_msg;

	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	@Override
	public String toString() {
		return "WechatReturn [return_code=" + return_code + ", return_msg=" + return_msg + "]";
	}
	
	
	
}
