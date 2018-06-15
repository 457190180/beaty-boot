package com.yimew.utils;

public class PageUtils {
	public static Integer getPage(Integer offset,Integer limit){
		if(offset==null || limit ==null){
			return null;
		}
		return (offset+limit)/limit;
	}
	
	public static Integer getStart(Integer pageNo,Integer pageSize){
		return (pageNo-1)*pageSize+1;
	}
	public static Integer getEnd(Integer start,Integer pageSize){
		return start+pageSize -1;
	}
}
