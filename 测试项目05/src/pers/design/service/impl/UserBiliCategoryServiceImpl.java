package pers.design.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.BiliCategoryMapper;
import pers.design.mapper.UserBiliCategoryMapper;
import pers.design.pojo.UserBiliCategory;
import pers.design.service.UserBiliCategoryService;

@Service 
public class UserBiliCategoryServiceImpl implements UserBiliCategoryService {
	
	@Resource
	private UserBiliCategoryMapper userBiliCategoryMapper;
	@Override
	public List<UserBiliCategory> selMyCollectedCategory(int userId) {
		return userBiliCategoryMapper.selMyCollectedCategory(userId);
	}

	@Override
	public int deleteMyCollectedCategory(int userId, int biliCategoryId) {
		return userBiliCategoryMapper.deleteMyCollectedCategory(userId, biliCategoryId);

	}

	@Override
	public int addMyCollectedCategory (int userId, int biliCategoryId) {
		return userBiliCategoryMapper.addMyCollectedCategory(userId, biliCategoryId,new Date());

	}

	@Override
	public int countOfThisCategory(int userId, int categoryId) {
		return userBiliCategoryMapper.countOfThisCategory(userId, categoryId);
	}

}
