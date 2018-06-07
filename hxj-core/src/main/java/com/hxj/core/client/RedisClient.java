package com.hxj.core.client;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * redis客户端
 * 
 * @author huangxj 2017年6月1日
 * 
 * @version v1.0
 */
public class RedisClient {

	//redis模板
	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate<Serializable, Object> redisTemplate;

	//默认存储时间（3600秒）
	@Value("#{redisProperties[defaultExpireTime]}")
	private String defaultExpireTime;

	/**
	 * 批量删除对应的value
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public void remove(String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public void removePattern(String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * 删除对应的value
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public void remove(String key) {
		if (isExists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public boolean isExists(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 读取缓存
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public Object get(String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	/**
	 * 读取字符串缓存
	 * 
	 * @author huangxj 2017年6月1日 
	 *
	 * @version v1.0
	 */
	public String getString(String key) {
		Object obj = get(key);
		return obj.toString();
	}
	

	/**
	 * 写入缓存
	 * 
	 * @author huangxj 2017年6月3日 
	 *
	 * @version v1.0
	 */
	public void set(String key, Object value) {

		Long expireTime = Long.parseLong(defaultExpireTime);
		set(key, value, expireTime);
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void set(String key, Object value, Long expireTime) {

		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
		redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	}
}
