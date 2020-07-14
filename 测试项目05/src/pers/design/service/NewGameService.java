package pers.design.service;

import java.util.List;

import pers.design.pojo.NewGame;

public interface NewGameService {
	public List<NewGame> selAll();
	public List<NewGame> selByDate();
	public List<NewGame> selByScore();
	public int updateData(List<NewGame> list);
	public void delAllData();
}
