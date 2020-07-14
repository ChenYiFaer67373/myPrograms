package pers.design.service;

import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import pers.design.pojo.BiliRank;

public interface BiliRankService {
	public List<BiliRank> getAllData();//��ȡ��������
	public List<BiliRank> getDataByCategory(int categoryId);//����categoryId��ȡ��Ϣ
	public void ClearRankTable();//��ձ�������
	public void InsertAllRank(List<BiliRank> list);//��������
	public int dataCount();
	public int dataCountByCategoryId(int categoryId);
	public List<BiliRank> selByPage(int pageNum,int pageSize);
	public List<BiliRank> selByPageAndCategoryId(int pageNum,int pageSize,int categoryId);
	public List<BiliRank> selByKeyword(String keyword);
}
