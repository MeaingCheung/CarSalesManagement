package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.Car;

/**
 * MyBatis Mapper 接口 - 表：car
 * 
 * @since 2017-04-09 12:36:31
 */
public interface CarMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(Car record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(Car record);

	/**
	 * 按主键查询
	 */
	Car selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(Car record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(Car record);

	/**
	 * 根据条件分页查询
	 *
	 * @param createUserLoginId
	 * @param type
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<Car> selectByConditionAndPage(@Param("createUserLoginId") Long createUserLoginId, @Param("type") Integer type,
			@Param("beginIndex") int beginIndex, @Param("size") int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param serialNumber
	 * @return
	 */
	Car selectByUniqueKey(@Param("serialNumber") String serialNumber);

}