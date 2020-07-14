package pers.design.service;

import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import pers.design.pojo.BiliRank;

public interface BiliRankService {
	public List<BiliRank> getAllData();//获取所有数据
	public List<BiliRank> getDataByCategory(int categoryId);//根据categoryId获取信息
	public void ClearRankTable();//清空表中数据
	public void InsertAllRank(List<BiliRank> list);//插入数据
	public int dataCount();
	public int dataCountByCategoryId(int categoryId);
	public List<BiliRank> selByPage(int pageNum,int pageSize);
	public List<BiliRank> selByPageAndCategoryId(int pageNum,int pageSize,int categoryId);
	public List<BiliRank> selByKeyword(String keyword);
}
