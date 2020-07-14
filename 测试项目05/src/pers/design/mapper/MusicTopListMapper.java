package pers.design.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.MusicTopList;

public interface MusicTopListMapper {
	public List<MusicTopList> selAll();
	public List<MusicTopList> selAllByAdmin();
	public int changeMusicListStatus(@Param("listId")int listId,@Param("status")int status);
	public MusicTopList selByMusicListId(int listId);
	public int addMusicList(MusicTopList list);
	public int delMusicList(int listId);
	public int countOfListId(int listId);
}
