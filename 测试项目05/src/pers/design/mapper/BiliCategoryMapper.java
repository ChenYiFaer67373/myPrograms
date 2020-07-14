package pers.design.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.BiliCategory;

public interface BiliCategoryMapper {
	public List<BiliCategory> selAll();
	public List<BiliCategory> selAllByAdmin();
	public int changeBiliCategoryStatus(@Param("categoryId")int categoryId,@Param("status")int status);
	public int addBiliCategory(BiliCategory biliCategory);
}
