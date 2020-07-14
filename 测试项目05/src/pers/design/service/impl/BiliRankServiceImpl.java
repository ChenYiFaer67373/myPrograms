package pers.design.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.BiliRankMapper;
import pers.design.pojo.BiliRank;
import pers.design.service.BiliRankService;

@Service
public class BiliRankServiceImpl implements BiliRankService {
	@Resource
	private BiliRankMapper biliRankMapper;
	
	public BiliRankMapper getBiliRankMapper() {
		return biliRankMapper;
	}

	public void setBiliRankMapper(BiliRankMapper biliRankMapper) {
		this.biliRankMapper = biliRankMapper;
	}
	@Override
	public List<BiliRank> getDataByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return biliRankMapper.selByCategoryId(categoryId);
	}

	@Override
	public void ClearRankTable() {
		biliRankMapper.deleteAllData();

	}
	@Override
	public void InsertAllRank(List<BiliRank> list) {
		for (BiliRank rank : list) {
			biliRankMapper.insertData(rank);
		}
	}
	@Override
	public List<BiliRank> getAllData() {
		return biliRankMapper.selAll();
	}

	@Override
	public int dataCount() {
		return biliRankMapper.dataCount();
	}

	@Override
	public int dataCountByCategoryId(int categoryId) {
		return biliRankMapper.dataCountByCategoryId(categoryId);
	}

	@Override
	public List<BiliRank> selByPage(int pageNum, int pageSize) {
		int pageStart=(pageNum-1)*pageSize;
		return biliRankMapper.selByPage(pageStart, pageSize);
	}

	@Override
	public List<BiliRank> selByPageAndCategoryId(int pageNum, int pageSize, int categoryId) {
		int pageStart=(pageNum-1)*pageSize;
		return biliRankMapper.selByPageAndCategoryId(pageStart, pageSize, categoryId);
	}

	@Override
	public List<BiliRank> selByKeyword(String keyword) {
		return biliRankMapper.selByKeyword(keyword);
	}
	

}
