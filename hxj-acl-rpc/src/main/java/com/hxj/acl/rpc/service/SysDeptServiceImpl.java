package com.hxj.acl.rpc.service;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.hxj.acl.rpc.api.dto.SysDeptDto;
import com.hxj.acl.rpc.api.entity.SysDept;
import com.hxj.acl.rpc.api.entity.SysUser;
import com.hxj.acl.rpc.api.service.SysDeptService;
import com.hxj.acl.rpc.mapper.SysDeptMapper;
import com.hxj.acl.rpc.mapper.SysUserMapper;
import com.hxj.common.api.exception.ParamException;
import com.hxj.common.api.exception.ParamException;
import com.hxj.common.tools.StringTools;
import com.hxj.core.tool.LevelTreeTool;
import com.hxj.db.core.base.BaseServiceImpl;

/**
 * 部门服务类实现
 * 
 * @author huangxj
 *
 * @date 2018-05-12 15:44:28
 * 
 * @version v1.0
 */
@Transactional
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept, SysDeptDto> implements SysDeptService {

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Resource
	private SysUserMapper sysUserMapper;

	/**
	 * 传入父id获取层级
	 * 
	 * @param parentId
	 *            父id
	 * 
	 * @return 计算后的层级
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月19日 下午3:54:05
	 * 
	 * @version v1.0
	 */
	private String calculateLevel(Integer parentId) {

		if (parentId == null) {
			return LevelTreeTool.ROOT;
		}

		// 从数据库中查找出层级
		SysDept parent = getByIdProperties(parentId, SysDept.LEVEL);
		if (parent == null) {
			return LevelTreeTool.ROOT;
		}

		// 得到父亲的级别
		String parentLevel = parent.getLevel();

		// 返回计算结果
		return LevelTreeTool.calculateLevel(parentLevel, parentId);
	}

	@Override
	public void create(SysDeptDto sysDeptDto) throws ParamException {

		// 设置层级
		sysDeptDto.setLevel(calculateLevel(sysDeptDto.getParentId()));

		try {

			// 保存
			save(sysDeptDto);
		} catch (DuplicateKeyException e) {

			throw new ParamException(StringTools.format("部门名称【{0}】已存在！", sysDeptDto.getName()));
		}
	}

	@Override
	public void modify(SysDeptDto sysDeptDto) throws ParamException {

		Integer id = sysDeptDto.getId();
		Objects.requireNonNull(id);

		Integer parentId = sysDeptDto.getParentId();

		// 在有修改父级id的情况下才需要修改层级
		if (parentId != null) {

			// 获取旧的层级
			String oldLevel = getByIdProperties(id, SysDept.LEVEL).getLevel();

			// 计算新的层级
			String newLevel = calculateLevel(parentId);

			// 层级有变化的话，那么除了要更新该部门的层级外，还需要更新该部门下所有子部门的层级
			if (!newLevel.equals(oldLevel)) {

				// 设置层级
				sysDeptDto.setLevel(newLevel);

				// 计算旧前缀
				String oldChildLevelPrefix = LevelTreeTool.calculateLevel(oldLevel, id);

				// 计算新前缀
				String newChildLevelPrefix = LevelTreeTool.calculateLevel(newLevel, id);

				// 将其下面子部门的旧前缀替换成新的前缀
				sysDeptMapper.updateLevelPrefix(oldChildLevelPrefix, newChildLevelPrefix);
			}
		}

		// 执行更新操作
		updateById(sysDeptDto);
	}

	@Override
	public List<SysDeptDto> listDeptTree() {
		return LevelTreeTool.buildTree(listAll());
	}

	@Override
	public void delete(Integer id) throws ParamException {

		Objects.requireNonNull(id);

		// 获取子部门数
		SysDept sysDept = new SysDept();
		sysDept.setParentId(id);
		int childCount = sysDeptMapper.selectCount(sysDept);

		// 有子部门的话则不给删除
		if (childCount > 0) {
			throw new ParamException("当前部门下面有子部门，无法删除！");
		}

		// 获取部门下的用户数
		SysUser sysUser = new SysUser();
		sysUser.setDeptId(id);
		int userCont = sysUserMapper.selectCount(sysUser);

		// 部门下有用户的话则不给删除
		if (userCont > 0) {
			throw new ParamException("当前部门下面有用户，无法删除！");
		}

		deleteById(id);
	}
}
