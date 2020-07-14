package pers.design.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.BiliRank;

public interface BiliRankMapper {
	public List<BiliRank> selAll();//查询所有记录
	public void insertData(BiliRank rank);//插入数据
	public List<BiliRank> selByCategoryId(int categoryId);//根据categoryId查询
	public void deleteAllData();//清空记录
	public int dataCount();//总数量
	public int dataCountByCategoryId(int categoryId);//单一categoryId的记录数量
	public List<BiliRank> selByPage(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);
	public List<BiliRank> selByPageAndCategoryId(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize,@Param("categoryId")int categoryId);
	
//	public List<BiliRank> selByKeyword(String keyword);
	
	public List<BiliRank> selByKeyword(String keyword);
}
