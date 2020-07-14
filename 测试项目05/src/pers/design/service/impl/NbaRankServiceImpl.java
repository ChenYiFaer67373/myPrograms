package pers.design.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.NbaRankMapper;
import pers.design.pojo.NbaRank;
import pers.design.service.NbaRankService;

@Service
public class NbaRankServiceImpl implements NbaRankService {
	@Resource
	private NbaRankMapper nbaRankMapper;
	public NbaRankMapper getNbaRankMapper() {
		return nbaRankMapper;
	}

	public void setNbaRankMapper(NbaRankMapper nbaRankMapper) {
		this.nbaRankMapper = nbaRankMapper;
	}

	@Override//获取nba_rank表中所有信息
	public List<NbaRank> getAllRank() {
		return nbaRankMapper.selAll();
	}

	@Override//清空nba_rank表中所有信息
	public void clearRankTable() {
		nbaRankMapper.deleteAllData();

	}

	@Override//将爬虫获取的数据写入表中
	public void insertAllRank(List<NbaRank> list) {
		for (NbaRank nbaRank : list) {
			nbaRankMapper.insertData(nbaRank);
		}

	}

}
