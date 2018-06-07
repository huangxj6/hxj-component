package com.hxj.common.api.base.tree;

import java.util.List;

public interface NextLevelListOperate<T> {

	/**
	 * 设置下一个层级的列表
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月19日 下午2:17:46
	 * 
	 * @version v1.0
	 */
	public void setNextList(List<T> list);

	/**
	 * 获取下一个层级的列表
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月19日 下午2:18:01
	 * 
	 * @version v1.0
	 */
	public List<T> getNextList();
}
