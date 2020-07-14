package pers.design.service;

import java.util.List;

import pers.design.pojo.MusicTopList;

public interface MusicTopListService {
	public List<MusicTopList> selAll();
	public List<MusicTopList> selAllByAdmin();
	public int changeMusicListStatus(int listId,int status);
	public int addMusicList(MusicTopList list);
	public int delMusicList(int listId);
	public int countOfListId(int listId);
}
