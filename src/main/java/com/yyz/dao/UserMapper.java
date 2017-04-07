package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.User;

/**
 * MyBatis Mapper 接口 - 表：user
 * 
 * @since 2017-03-11 11:36:40
 */
public interface UserMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(User record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(User record);

	/**
	 * 按主键查询
	 */
	User selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 根据登录名进行查找
	 *
	 * @param loginName
	 * @return
	 */
	User selectByLoginName(@Param("loginName") String loginName);

	/**
	 * 根据条件进行分页查询
	 * 
	 * @param size
	 * @param beginIndex
	 * @param department
	 * @param role
	 *
	 * @return
	 */
	List<User> selectByConditionAndPage(@Param("position") Integer position, @Param("department") Integer department,
			@Param("beginIndex") int beginIndex, @Param("size") int size);

	/**
	 * 查询当前最大的loginId
	 *
	 * @return
	 */
	Long selectMaxLoginId();

}