package com.yimew.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataGrid implements Serializable{

	private static final long serialVersionUID = 8660623678943216889L;
	private Long total = 0l;
	private List<?> rows = new ArrayList<Object>();
	/**
	 * 列表构造
	 * @param total 总数
	 * @param rows 内容
	 */
	public DataGrid(Long total, List<?> rows){
		this.rows= rows;
		this.total=total;
	}
	public DataGrid(){
		
	}
	

	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	
	

}
