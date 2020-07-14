package pers.design.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.MusicListContent;

public interface MusicListContentMapper {
	public List<MusicListContent> selByListId(int listId);
	public int addMusicListContent(MusicListContent content);
	public int delMusicListContent(@Param("listId")int listId);
}
