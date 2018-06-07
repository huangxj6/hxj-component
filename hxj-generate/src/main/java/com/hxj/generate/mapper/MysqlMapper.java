package com.hxj.generate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hxj.generate.entity.Columns;
import com.hxj.generate.entity.Table;

@Mapper
public interface MysqlMapper {

	public List<Table> listTables();

	public List<Columns> listColumns(@Param("tableName") String tableName);
}
