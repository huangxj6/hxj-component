package com.hxj.common.api.base;

import java.util.List;

import com.hxj.common.api.bean.Order;
import com.hxj.common.api.bean.PageDto;
import com.hxj.common.api.bean.PageQueryDto;
import com.hxj.common.api.exception.CustomException;

public interface BaseService<E extends BaseEntity, D extends E> {

	/**
	 * 插入一条记录
	 * 
	 * @param dto
	 *            传入dto
	 * 
	 * @return 返回数据库自动生成的主键id
	 * 
	 * @author huangxj 2018年4月26日
	 *
	 * @version v1.0
	 */
	public Integer save(D dto);

	/**
	 * 根据主键删除一条记录
	 * 
	 * @author huangxj 2018年4月19日
	 *
	 * @version v1.0
	 */
	public void deleteById(Integer id);

	/**
	 * 根据主键修改一条记录，dto中空值的属性表示不更新该字段
	 * 
	 * @author huangxj 2018年4月19日
	 *
	 * @version v1.0
	 * @throws CustomException 
	 */
	public void updateById(D dto) throws CustomException;

	/**
	 * 根据id查找一条记录，如果记录不存在的话则返回一个null值
	 * 
	 * @author huangxj 2018年4月19日
	 *
	 * @version v1.0
	 */
	public D get(Integer id);

	/**
	 * 根据id查找一条记录，指定查哪些字段，如果记录不存在的话则返回一个null值
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	public D getById(Integer id, String[] properties);

	/**
	 * 查找所有
	 * 
	 * @author huangxj 2018年4月19日
	 *
	 * @version v1.0
	 */
	public List<D> listAll();

	/**
	 * 条件查找
	 * 
	 * @param queryConditions
	 *            指定查询条件
	 * @param orders
	 *            排序
	 * @param properties
	 *            只查某些字段
	 * @return
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月12日 下午5:49:35
	 * 
	 * @version v1.0
	 */
	public List<D> listAll(D queryConditions, Order[] orders, String[] properties);

	/**
	 * 分页查询
	 * 
	 * @author huangxj 2018年4月20日
	 *
	 * @version v1.0
	 */
	public PageDto<D> listByPage(PageQueryDto<D> pageQueryDto);

}