package com.hxj.core.tool;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.hxj.common.api.base.tree.BaseLevelEntity;
import com.hxj.common.api.base.tree.NextLevelListOperate;
import com.hxj.common.tools.CollectionTools;
import com.hxj.common.tools.StringTools;

/**
 * 层级计算工具类
 * 
 * @author huangxj
 *
 * @date 2018年5月12日 下午5:09:10
 * 
 * @version v1.0
 */
public class LevelTreeTool {

	/**
	 * 层级分隔符
	 */
	public final static String SEPARATOR = ".";

	/**
	 * 最顶层层级id
	 */
	public final static String ROOT = "0";

	/**
	 * 层级计算规则，首层的层级为0，下一层级为：父亲的层级.父亲的id
	 * 
	 * @param parentLevel
	 *            父层级
	 * 
	 * @param parentId
	 *            父id
	 * 
	 * @return 计算后的层级
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月12日 下午5:06:16
	 * 
	 * @version v1.0
	 */
	public static String calculateLevel(String parentLevel, Integer parentId) {
		if (StringTools.isBlank(parentLevel)) {
			return ROOT;
		} else {
			return StringUtils.join(parentLevel, SEPARATOR, parentId);
		}
	}

	/**
	 * 传入一个list，根据层级规则将这个list构造成一个树
	 * 
	 * @param list
	 *            传入的列表，类表里的实体必须是BaseLevelEntity的子类及实现了NextLevelListOperate接口
	 *            
	 * @return 顶级列表，下面包含了各个实体的子列表
	 * 
	 * @author huangxj
	 *
	 * @date 2018年5月19日 下午1:56:33
	 * 
	 * @version v1.0
	 */
	public static <T extends BaseLevelEntity & NextLevelListOperate<T>> List<T> buildTree(List<T> list) {

		/*
		 * 定义一个辅助map，格式： level1 -> list[t1,t2...], level2 -> list[t1,t2...] ...
		 */
	 	ArrayListMultimap<String, T> levelMap = ArrayListMultimap.create();

		// 遍历列表，将相同层级的实体放在同一个列表中
		for (T t : list) {
			levelMap.put(t.getLevel(), t);
		}

		// 取出顶级部门列表
		List<T> rootList = levelMap.get(ROOT);

		// 将顶级部门列表转成一棵树
		listToTree(rootList, levelMap);

		// 返回顶级列表
		return rootList;
	}

	/**
	 * 辅助方法，递归将一个列表变成一棵树
	 * 
	 * @author huangxj 
	 *
	 * @date 2018年5月19日 下午1:58:56
	 * 
	 * @version v1.0
	 */
	private static <T extends BaseLevelEntity & NextLevelListOperate<T>> void listToTree(List<T> List,
			ArrayListMultimap<String, T> levelMap) {

		// 遍历
		for (T t : List) {

			// 计算下一个层级
			String nextLevel = calculateLevel(t.getLevel(), t.getId());

			// 从levelMap中取出下一个层级的列表
			List<T> nextList = levelMap.get(nextLevel);

			// 有子部门
			if (CollectionTools.isNotEmpty(nextList)) {

				// 赋值
				t.setNextList(nextList);

				// 递归调用，将子部门列表转成一颗树
				listToTree(nextList, levelMap);
			}
		}
	}

}
