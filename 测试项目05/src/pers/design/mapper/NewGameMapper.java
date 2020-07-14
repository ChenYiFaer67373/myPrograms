package pers.design.mapper;

import java.util.List;

import pers.design.pojo.NewGame;

public interface NewGameMapper {
	public int insertData(NewGame game);
	public List<NewGame> selAll();
	public List<NewGame> selByScore();
	public List<NewGame> selByDate();
	public void delAllData();
	
}
