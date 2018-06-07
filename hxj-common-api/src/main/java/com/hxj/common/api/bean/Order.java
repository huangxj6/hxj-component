package com.hxj.common.api.bean;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 * 排序
 * 
 * @author huangxj 2018年4月24日
 * 
 * @version v1.0
 */
@Getter
@Setter
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	public static enum Direction {
		ASC, DESC;
	}

	/**
	 * 字段
	 */
	private String propertie;

	/**
	 * 方向
	 */
	private Direction direction;
	
	public Order() {
	}

	public Order(String propertie) {

		Objects.requireNonNull(propertie);

		this.propertie = propertie;
		this.direction = Direction.DESC;
	}

	public Order(String propertie, Direction direction) {

		this(propertie);

		if (direction != null) {
			this.direction = direction;
		}
	}
}
