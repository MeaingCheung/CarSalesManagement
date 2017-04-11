package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.Inventory;

/**
 * MyBatis Mapper 接口 - 表：inventory
 * 
 * @since 2017-04-11 19:53:41
 */
public interface InventoryMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(Inventory record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(Inventory record);

	/**
	 * 按主键查询
	 */
	Inventory selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(Inventory record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(Inventory record);

	/**
	 * 根据唯一索引查询
	 *
	 * @param carSerialNumber
	 * @param costPrice
	 * @return
	 */
	Inventory selectByUniqueKey(@Param("carSerialNumber") String carSerialNumber, @Param("costPrice") long costPrice);

	/**
	 * 根据条件进行查询
	 *
	 * @param carSerialNumber
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<Inventory> selectByConditionAndPage(@Param("carSerialNumber") String carSerialNumber,
			@Param("beginIndex") int beginIndex, @Param("size") int size);

}