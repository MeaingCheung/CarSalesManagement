package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.Manufacturer;

/**
 * MyBatis Mapper 接口 - 表：manufacturer
 * 
 * @since 2017-04-07 22:01:28
 */
public interface ManufacturerMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(Manufacturer record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(Manufacturer record);

	/**
	 * 按主键查询
	 */
	Manufacturer selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(Manufacturer record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(Manufacturer record);

	/**
	 * 根据条件分页查询
	 *
	 * @param createUserLoginId
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<Manufacturer> selectByConditionAndPage(@Param("createUserLoginId") Long createUserLoginId,
			@Param("beginIndex") int beginIndex, @Param("size") int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param serialNumber
	 * @return
	 */
	Manufacturer selectByUniqueKey(Long serialNumber);

}