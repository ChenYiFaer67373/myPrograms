package pers.design.service;

import java.util.List;

import pers.design.pojo.MusicListContent;

public interface MusicListContentService {
	public List<MusicListContent> selByListId(int listId);
	public void addAllContent(List<MusicListContent> list);
	public int addMusicListContent(MusicListContent content);
	public int delMusicListContent(int listId);
}
