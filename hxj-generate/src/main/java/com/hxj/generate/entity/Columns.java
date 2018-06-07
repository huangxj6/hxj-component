package com.hxj.generate.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Columns implements Serializable{

	private static final long serialVersionUID = 1L;

	// 列名
	private String columnName;
	
	// 字段名
	private String fieldName;
	
	// 数据类型
	private String dataType;
	
	// 注释
	private String columnComment;
	
	// 字段常量名
	private String constantName;
	
}
