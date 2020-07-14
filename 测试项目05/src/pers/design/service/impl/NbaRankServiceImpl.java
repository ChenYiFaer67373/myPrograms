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

	@Override//��ȡnba_rank����������Ϣ
	public List<NbaRank> getAllRank() {
		return nbaRankMapper.selAll();
	}

	@Override//���nba_rank����������Ϣ
	public void clearRankTable() {
		nbaRankMapper.deleteAllData();

	}

	@Override//�������ȡ������д�����
	public void insertAllRank(List<NbaRank> list) {
		for (NbaRank nbaRank : list) {
			nbaRankMapper.insertData(nbaRank);
		}

	}

}
