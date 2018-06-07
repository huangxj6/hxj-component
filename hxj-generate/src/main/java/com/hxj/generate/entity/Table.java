package com.hxj.generate.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {

	// 表名
	private String tableName;

	// 表注释
	private String tableComment;

	// 实体名称
	private String entityName;

	// 实体的变量名，首字母小写
	private String entityVariableName;

	// 表下面的所有列
	private List<Columns> columnsList;

}
