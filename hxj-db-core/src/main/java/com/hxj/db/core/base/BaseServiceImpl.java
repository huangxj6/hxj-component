package com.hxj.db.core.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxj.common.api.base.BaseEntity;
import com.hxj.common.api.base.BaseService;
import com.hxj.common.api.bean.Order;
import com.hxj.common.api.bean.Order.Direction;
import com.hxj.common.api.bean.PageDto;
import com.hxj.common.api.bean.PageQueryDto;
import com.hxj.common.api.exception.ParamException;
import com.hxj.common.tools.BeanCopyTools;
import com.hxj.common.tools.CollectionTools;
import com.hxj.common.tools.StringTools;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import tk.mybatis.mapper.entity.Example.OrderBy;

/**
 * 服务层基类
 * 
 * @author huangxj 2018年4月24日
 * 
 * @version v1.0
 */
public class BaseServiceImpl<E extends BaseEntity, D extends E> implements BaseService<E, D> {

	/**
	 * 数据库操作类
	 */
	@Autowired
	protected BaseMapper<E> baseMapper;

	/**
	 * 实体对应的class
	 */
	private Class<E> entityClass;

	/**
	 * dto对应的class
	 */
	private Class<D> dtoClass;

	/**
	 * 构造初始化，得到实体和dto的类对象
	 */
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Override
	public Integer save(D dto) {

		// 保存的实体不能为空，否则抛空指针异常
		Objects.requireNonNull(dto);

		// 主键必须由数据库生成，不能由程序指定
		if (dto.getId() != null) {
			throw new RuntimeException("id必须为空！");
		}

		// 转成实体
		E entity = BeanCopyTools.copy(dto, entityClass);

		// 执行插入操作，返回影响条数
		int result = baseMapper.insertSelective(entity);

		// 影响条数必须是1条，否则抛异常
		if (result != 1) {
			throw new RuntimeException("数据库返回的影响条数不为1：" + result);
		}

		// 返回插入后的主键
		return entity.getId();
	}

	@Override
	public void deleteById(Integer id) {

		// id不能为空，否则抛空指针异常
		Objects.requireNonNull(id);

		// 执行删除操作，返回影响条数
		int result = baseMapper.deleteByPrimaryKey(id);

		// 影响条数必须是1条，否则抛异常
		if (result != 1) {
			throw new RuntimeException("数据库返回的影响条数不为1：" + result);
		}
	}

	@Override
	public void updateById(D dto) throws ParamException {

		// 更新的实体不能为空，否则抛空指针异常
		Objects.requireNonNull(dto);

		// 更新时主键不能为空
		Objects.requireNonNull(dto.getId());

		// 转成实体
		E entity = BeanCopyTools.copy(dto, entityClass);

		// 执行更新操作，返回影响条数
		int result = baseMapper.updateByPrimaryKeySelective(entity);

		// 查询不到记录
		if (result == 0) {
			throw new ParamException(StringTools.format("查找不到id为{0}的记录，无法进行更新操作", dto.getId()));
		}

		// 影响条数必须是1条，否则抛异常
		if (result != 1) {
			throw new ParamException("数据库返回的影响条数不为1：" + result);
		}
	}

	@Override
	public D get(Integer id) {
		return getById(id, null);
	}

	@Override
	public D getById(Integer id, String[] properties) {

		// id不能为空，否则抛空指针异常
		Objects.requireNonNull(id);

		D dto = null;

		// 从数据库中查出数据
		E entity = getByIdProperties(id, properties);

		// 转成dto
		if (entity != null) {
			dto = BeanCopyTools.copy(entity, dtoClass);
		}

		return dto;
	}

	@Override
	public List<D> listAll() {
		return listAll(null, null, null);
	}

	@Override
	public List<D> listAll(D queryConditions, Order[] orders, String[] properties) {

		List<D> dtoList = null;

		// 执行查询操作
		List<E> entityList = listAllProperties(queryConditions, orders, properties);

		// 转成dto列表
		if (CollectionTools.isNotEmpty(entityList)) {
			dtoList = BeanCopyTools.copyList(entityList, dtoClass);
		}

		return dtoList;
	}

	@Override
	public PageDto<D> listByPage(PageQueryDto<D> pageQueryDto) {

		// 查询参数不能为空
		Objects.requireNonNull(pageQueryDto);

		PageDto<D> pageDto = new PageDto<>();

		// 得到分页信息
		Integer pageNum = pageQueryDto.getPageNum();
		Integer pageSize = pageQueryDto.getPageSize();

		// 设置分页
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}

		// 查询数据库
		List<E> entityList = listAllProperties(pageQueryDto.getQueryConditions(), pageQueryDto.getOrders(),
				pageQueryDto.getProperties());

		if (CollectionTools.isNotEmpty(entityList)) {

			// 得到分页信息
			PageInfo<E> pageInfo = new PageInfo<>(entityList);

			// 转成pageDto
			pageDto = pageInfo2PageDto(pageInfo);
		}

		return pageDto;
	}

	/**
	 * 查找单个（指定查询字段）
	 * 
	 * @author huangxj 2018年4月23日
	 *
	 * @version v1.0
	 */
	protected E getByIdProperties(Integer id, String... properties) {

		// 创建example类
		Example example = new Example(entityClass);

		// 设置要查询的字段
		if (properties != null) {
			example = example.selectProperties(properties);
		}

		example.createCriteria().andEqualTo(BaseEntity.ID, id);

		E entity = baseMapper.selectOneByExample(example);

		return entity;
	}

	/**
	 * 查找全部（指定查询字段）
	 * 
	 * @author huangxj 2018年4月23日
	 *
	 * @version v1.0
	 * @param dto
	 */
	protected List<E> listAllProperties(D queryConditions, Order[] orders, String[] properties) {

		// 创建example类
		Example example = new Example(entityClass);

		// 设置要查询的字段
		if (properties != null) {
			example = example.selectProperties(properties);
		}

		// 设置排序
		if (orders != null) {
			setOrders(example, orders);
		}

		// 设置查询条件
		if (queryConditions != null) {

			Criteria criteria = example.createCriteria();
			Map<String, Object> map = BeanCopyTools.toMap(queryConditions);
			for (Map.Entry<String, Object> entry : map.entrySet()) {

				String key = entry.getKey();
				Object value = entry.getValue();

				if (value == null || "".equals(entry.getValue())) {
					continue;
				}
				criteria.andEqualTo(key, entry.getValue());
			}
		}

		List<E> entityList = baseMapper.selectByExample(example);
		return entityList;
	}

	/**
	 * 设置排序
	 * 
	 * @author huangxj 2018年4月24日
	 *
	 * @version v1.0
	 */
	protected void setOrders(Example example, Order[] orders) {

		for (Order order : orders) {

			OrderBy orderBy = example.orderBy(order.getPropertie());

			Direction direction = order.getDirection();
			if (direction == Direction.ASC) {
				orderBy.asc();
			} else {
				orderBy.desc();
			}
		}
	}

	/**
	 * 将mybatis的分页信息转换成本项目自定义的分页信息
	 * 
	 * @author huangxj 2018年4月26日
	 *
	 * @version v1.0
	 */
	@SuppressWarnings("unchecked")
	protected PageDto<D> pageInfo2PageDto(PageInfo<E> pageInfo) {

		if (pageInfo == null) {
			return null;
		}

		// 复制分页信息
		PageDto<D> pageDto = BeanCopyTools.copy(pageInfo, PageDto.class);

		// 复制列表数据
		List<E> entityList = pageInfo.getList();
		if (CollectionTools.isNotEmpty(entityList)) {
			pageDto.setDtoList(BeanCopyTools.copyList(entityList, dtoClass));
		}

		return pageDto;
	}
}
