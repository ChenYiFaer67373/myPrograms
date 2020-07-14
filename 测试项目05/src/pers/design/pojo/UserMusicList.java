package pers.design.pojo;

import java.util.Date;

public class UserMusicList {
	public int userId;
	public int musicListId;
	public Date addTime;
	public MusicTopList musicTopList;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMusicListId() {
		return musicListId;
	}
	public void setMusicListId(int musicListId) {
		this.musicListId = musicListId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "UserMusicList [userId=" + userId + ", musicListId=" + musicListId + ", addTime=" + addTime
				+ ", musicTopList=" + musicTopList + "]";
	}
	
	
}
