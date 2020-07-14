package pers.design.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.UserBiliCategory;

public interface UserBiliCategoryMapper {
	public List<UserBiliCategory> selMyCollectedCategory(int userId);
	public int countOfThisCategory(@Param("userId")int userId,@Param("biliCategoryId")int categoryId);
	public int deleteMyCollectedCategory(@Param("userId")int userId,@Param("biliCategoryId")int biliCategoryId);
	public int addMyCollectedCategory(@Param("userId")int userId,@Param("biliCategoryId")int biliCategoryId,@Param("addTime")Date addTime);
}
