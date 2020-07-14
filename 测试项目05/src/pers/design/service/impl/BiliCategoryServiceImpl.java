package pers.design.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.BiliCategoryMapper;
import pers.design.pojo.BiliCategory;
import pers.design.service.BiliCategoryService;

@Service
public class BiliCategoryServiceImpl implements BiliCategoryService {
	@Resource
	private BiliCategoryMapper biliCategoryMapper;
	
	public BiliCategoryMapper getBiliCategoryMapper() {
		return biliCategoryMapper;
	}

	public void setBiliCategoryMapper(BiliCategoryMapper biliCategoryMapper) {
		this.biliCategoryMapper = biliCategoryMapper;
	}

	@Override
	public List<BiliCategory> getAllCategory() {
		return biliCategoryMapper.selAll();
	}

	@Override
	public int changeBiliCategoryStatus(int categoryId, int status) {
		return biliCategoryMapper.changeBiliCategoryStatus(categoryId, status);
	}

	@Override
	public int addBiliCategory(int categoryId, String categoryName, String categoryUrl) {
		BiliCategory biliCategory=new BiliCategory(categoryId, categoryName, categoryUrl);
		return biliCategoryMapper.addBiliCategory(biliCategory);
	}

	@Override
	public List<BiliCategory> getAllCategoryByAdmin() {
		return biliCategoryMapper.selAllByAdmin();
	}

}
