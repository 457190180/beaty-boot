package com.yimew.utils;

import java.util.Random;

public class CodeUtils {
	
	/**
	 * 生成任意随机码
	 * @param length
	 * @return
	 */
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static String getNumRandom(Integer length){
		Random random = new Random();
		StringBuffer numers = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(10);
			numers.append(String.valueOf(nextInt));
		}
		return numers.toString();
	}
	
	/**
	 * 获取min到max之间的随机整数
	 * @param min
	 * @param max
	 * @return
	 */
	public static Integer getNumRandom(Integer min,Integer max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
	}
	
}
