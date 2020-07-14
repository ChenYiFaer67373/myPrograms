package pers.design.service;

import java.util.List;

import pers.design.pojo.BiliCategory;

public interface BiliCategoryService {
	public List<BiliCategory> getAllCategory();
	public List<BiliCategory> getAllCategoryByAdmin();
	public int changeBiliCategoryStatus(int categoryId,int status);
	public int addBiliCategory(int categoryId, String categoryName, String categoryUrl);
}
