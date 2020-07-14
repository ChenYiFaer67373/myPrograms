package pers.design.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.BiliRank;

public interface BiliRankMapper {
	public List<BiliRank> selAll();//��ѯ���м�¼
	public void insertData(BiliRank rank);//��������
	public List<BiliRank> selByCategoryId(int categoryId);//����categoryId��ѯ
	public void deleteAllData();//��ռ�¼
	public int dataCount();//������
	public int dataCountByCategoryId(int categoryId);//��һcategoryId�ļ�¼����
	public List<BiliRank> selByPage(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);
	public List<BiliRank> selByPageAndCategoryId(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize,@Param("categoryId")int categoryId);
	
//	public List<BiliRank> selByKeyword(String keyword);
	
	public List<BiliRank> selByKeyword(String keyword);
}
