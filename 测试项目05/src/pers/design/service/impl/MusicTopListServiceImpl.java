package pers.design.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.MusicTopListMapper;
import pers.design.pojo.MusicTopList;
import pers.design.service.MusicTopListService;

@Service
public class MusicTopListServiceImpl implements MusicTopListService {
	@Resource
	private MusicTopListMapper musicTopListMapper;
	@Override
	public List<MusicTopList> selAll() {
		return musicTopListMapper.selAll();
	}

	@Override
	public int addMusicList(MusicTopList list) {
		return musicTopListMapper.addMusicList(list);
	}

	@Override
	public int delMusicList(int listId) {
		return musicTopListMapper.delMusicList(listId);
	}

	@Override
	public List<MusicTopList> selAllByAdmin() {
		return musicTopListMapper.selAllByAdmin();
	}

	@Override
	public int changeMusicListStatus(int listId, int status) {
		return musicTopListMapper.changeMusicListStatus(listId, status);
	}

	@Override
	public int countOfListId(int listId) {
		return musicTopListMapper.countOfListId(listId);
	}

}
