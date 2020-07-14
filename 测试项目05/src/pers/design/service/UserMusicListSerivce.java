package pers.design.service;

import java.util.List;

import pers.design.pojo.UserMusicList;

public interface UserMusicListSerivce {
	public List<UserMusicList> selMyMusicList(int userId);
	public int countOfThisMusicList(int userId,int musicListId);
	public int addMyMusicList(int userId,int listId);
	public int delMyMusicList(int userId,int musicListId);
}
