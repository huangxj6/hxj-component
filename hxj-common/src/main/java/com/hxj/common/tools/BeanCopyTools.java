package com.hxj.common.tools;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 对象映射工具类
 * 
 * @author huangxj 2017年3月19日
 * 
 * @version v1.0
 */
@Slf4j
public class BeanCopyTools {

	/**
	 * 返回一个list，该list中对象类型为destinationClass，属性值使用sourceList中的对象属性值进行填充
	 * 
	 * @author huangxj 2017年3月19日
	 *
	 * @version v1.0
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> copyList(Collection sourceList, Class<T> destinationClass) {

		List<T> destinationList = new ArrayList<T>();

		for (Object source : sourceList) {

			T destination = copy(source, destinationClass);
			destinationList.add(destination);
		}

		return destinationList;
	}

	/**
	 * 返回一个指定的类对象，该对象中属性值使用source参数中的值填充
	 * 
	 * @author huangxj 2017年3月19日
	 *
	 * @version v1.0
	 */
	public static <T> T copy(Object source, Class<T> destinationClass) {

		T destination = null;
		try {
			destination = destinationClass.newInstance();
			BeanUtils.copyProperties(destination, source);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return destination;
	}

	/**
	 * 利用Introspector和PropertyDescriptor 将Bean转成一个Map
	 * 
	 * @author huangxj 2018年4月24日 
	 *
	 * @version v1.0
	 */
	public static Map<String, Object> toMap(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			log.error("transBean2Map Error ", e);
		}

		return map;
	}
}
