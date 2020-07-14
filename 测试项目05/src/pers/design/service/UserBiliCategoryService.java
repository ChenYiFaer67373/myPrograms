package pers.design.service;

import java.util.List;

import pers.design.pojo.UserBiliCategory;

public interface UserBiliCategoryService {
	public List<UserBiliCategory> selMyCollectedCategory(int userId);
	public int countOfThisCategory(int userId,int categoryId);
	public int deleteMyCollectedCategory(int userId,int biliCategoryId);
	public int addMyCollectedCategory(int userId,int biliCategoryId);
}
