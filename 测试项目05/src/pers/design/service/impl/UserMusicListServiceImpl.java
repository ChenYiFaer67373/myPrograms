package pers.design.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.UserMusicListMapper;
import pers.design.pojo.UserMusicList;
import pers.design.service.UserMusicListSerivce;
@Service
public class UserMusicListServiceImpl implements UserMusicListSerivce {
	@Resource
	private UserMusicListMapper userMusicListMapper;
	@Override
	public List<UserMusicList> selMyMusicList(int userId) {
		return userMusicListMapper.selMyMusicList(userId);
	}

	@Override
	public int addMyMusicList(int userId,int listId) {
		return userMusicListMapper.addMyMusicList(userId, listId, new Date());
	}

	@Override
	public int delMyMusicList(int userId, int musicListId) {
		return userMusicListMapper.delMyMusicList(userId, musicListId);
	}

	@Override
	public int countOfThisMusicList(int userId, int musicListId) {
		return userMusicListMapper.countOfThisMusicList(userId, musicListId);
	}

}
