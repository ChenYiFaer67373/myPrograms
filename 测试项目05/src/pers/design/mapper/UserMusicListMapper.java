package pers.design.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.design.pojo.UserMusicList;

public interface UserMusicListMapper {
	public List<UserMusicList> selMyMusicList(int userId);
	public int countOfThisMusicList(@Param("userId")int userId,@Param("musicListId")int musicListId);
	public int addMyMusicList(@Param("userId")int userId,@Param("musicListId")int musicListId,@Param("addTime")Date addTime);
	public int delMyMusicList(@Param("userId")int userId,@Param("musicListId")int musicListId);
}
