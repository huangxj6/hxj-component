package com.hxj.generate.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxj.common.api.base.BaseEntity;
import com.hxj.common.tools.StringTools;
import com.hxj.generate.entity.Columns;
import com.hxj.generate.entity.Table;
import com.hxj.generate.mapper.MysqlMapper;

@Service
public class DbService {

	public static Map<String, String> dataTypeMap = new HashMap<>();

	static {

		dataTypeMap.put("tinyint", "Integer");
		dataTypeMap.put("smallint", "Integer");
		dataTypeMap.put("mediumint", "Integer");
		dataTypeMap.put("int", "Integer");
		dataTypeMap.put("integer", "Integer");
		dataTypeMap.put("bigint", "Long");
		dataTypeMap.put("float", "Float");
		dataTypeMap.put("double", "Double");
		dataTypeMap.put("decimal", "BigDecimal");
		dataTypeMap.put("char", "String");
		dataTypeMap.put("varchar", "String");
		dataTypeMap.put("tinytext", "String");
		dataTypeMap.put("text", "String");
		dataTypeMap.put("mediumtext", "String");
		dataTypeMap.put("longtext", "String");
		dataTypeMap.put("date", "Date");
		dataTypeMap.put("datetime", "Date");
		dataTypeMap.put("timestamp", "Date");
	}

	@Autowired
	private MysqlMapper mysqlMapper;

	public List<Table> listTables() {
		
		List<Table> tableList = mysqlMapper.listTables();
		
		// 初始化table
		for (Table table : tableList) {
			
			String tableName = table.getTableName();
			String entityVariableName = StringTools.camelCaseName(tableName);
			
			table.setEntityVariableName(entityVariableName);
			table.setEntityName(StringTools.capitalize(entityVariableName));
			table.setColumnsList(listColumns(tableName));
		}
		
		return tableList;
	}

	public List<Columns> listColumns(String tableName) {

		// 定义要剔除的字段
		Map<String, Boolean> baseColumnsMap = new HashMap<>();
		Field[] baseFields = BaseEntity.class.getDeclaredFields();
		for (Field field : baseFields) {
			if (field.getModifiers() == Modifier.PRIVATE) {
				baseColumnsMap.put(StringTools.underscoreName(field.getName()), true);
			}
		}

		List<Columns> list = mysqlMapper.listColumns(tableName);

		ListIterator<Columns> lit = list.listIterator();
		while (lit.hasNext()) {

			Columns columns = lit.next();

			if (baseColumnsMap.get(columns.getColumnName().trim()) != null) {
				lit.remove();
			}

			else {

				columns.setDataType(dataTypeMap.get(columns.getDataType()));
				columns.setFieldName(StringTools.camelCaseName(columns.getColumnName()));
				columns.setConstantName(columns.getColumnName().toUpperCase());
			}
		}

		return list;
	}

	public static void main(String[] args) {

		Map<String, Boolean> map = new HashMap<>();
		Field[] baseColumns = BaseEntity.class.getDeclaredFields();
		for (Field field : baseColumns) {
			if (field.getModifiers() == Modifier.PRIVATE) {
				map.put(StringTools.underscoreName(field.getName()), true);
			}
		}
	}
}
