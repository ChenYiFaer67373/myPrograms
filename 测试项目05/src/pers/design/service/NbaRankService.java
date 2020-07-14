package pers.design.service;

import java.util.List;

import pers.design.pojo.NbaRank;

public interface NbaRankService {
	public List<NbaRank> getAllRank();
	public void clearRankTable();
	public void insertAllRank(List<NbaRank> list);
}
