package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.InventoryRecord;

/**
 * MyBatis Mapper 接口 - 表：inventoryrecord
 * 
 * @since 2017-04-11 19:54:23
 */
public interface InventoryRecordMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(InventoryRecord record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(InventoryRecord record);

	/**
	 * 按主键查询
	 */
	InventoryRecord selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(InventoryRecord record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(InventoryRecord record);

	/**
	 * 根据条件分页查询
	 *
	 * @param inventoryId
	 * @param type
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<InventoryRecord> selectByConditionAndPage(@Param("inventoryId") Long inventoryId, @Param("type") Integer type,
			@Param("beginIndex") int beginIndex, @Param("size") int size);

}