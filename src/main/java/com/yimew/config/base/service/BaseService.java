package com.yimew.config.base.service;

import com.github.pagehelper.PageInfo;
import com.yimew.config.base.page.BasePage;
import com.yimew.entity.sys.User;

import java.util.List;

public interface BaseService<T,P extends BasePage,K,Q> {

	/**
	 * 公共获取查询用query
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Q getQuery(P p)throws  Exception;


	/**
	 * 公共根据Id获取数据
	 * @param id
	 * @return
	 */
	public  T getById(K id) throws  Exception;
	
	/**
	 * 公共获取列表
	 * @param q
	 * @return
	 */
	public PageInfo<T> getList(Q q)throws  Exception;
	
	/**
	 * 公共统计
	 * @param q
	 * @return
	 */
	public Integer countList(Q q)throws  Exception;
	
	/**
	 * 公共部分保存
	 * @param t
	 * @return
	 */
	public T insertSelective(T t, User user)throws  Exception;

	/**
	 * 公共全部保存
	 * @param t
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T insert(T t, User user)throws  Exception;

	/**
	 * 公共部分修改
	 * @param t
	 * @return
	 */
	public T updateByPrimaryKeySelective(T t, User user)throws  Exception;

	/**
	 * 公共全部修改
	 * @param t
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T updateByPrimaryKey(T t, User user)throws  Exception;

	/**
	 * 公共删除
	 * @param ks
	 * @return
	 */
	public Integer del(List<T> ks, User user) throws  Exception;
	


}
