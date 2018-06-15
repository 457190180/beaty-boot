package com.yimew.utils;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {
	/**
	 * 获取一个UUID
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	/**
	 * 获取一个末尾为num位的由时间戳组成的唯一id
	 * @param num
	 * @return
	 */
	public static String getTimeID(Integer num){
		if(num==null){
			num=0;
		}
		return String.valueOf(new Date().getTime())+ CodeUtils.getNumRandom(num);
	}
	
	public static String getUserCode(){
		return new Date().getTime()+"";
	}

	public static String getCompanycode() {
		return new Date().getTime()+"";
	}
}
