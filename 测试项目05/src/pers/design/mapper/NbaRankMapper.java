package pers.design.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.NbaRank;

public interface NbaRankMapper {
	public List<NbaRank> selAll();
	public void insertData(@Param("rank")NbaRank rank);
	public void deleteAllData();
}
