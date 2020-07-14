package pers.design.pojo;

import java.util.Date;

public class UserBiliCategory {
	private int userId;
	private int biliCategoryId;
	private Date addTime;
	private BiliCategory biliCategory;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBiliCategoryId() {
		return biliCategoryId;
	}

	public void setBiliCategoryId(int biliCategoryId) {
		this.biliCategoryId = biliCategoryId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BiliCategory getBiliCategory() {
		return biliCategory;
	}

	public void setBiliCategory(BiliCategory biliCategory) {
		this.biliCategory = biliCategory;
	}

	@Override
	public String toString() {
		return "UserBiliCategory [userId=" + userId + ", biliCategoryId=" + biliCategoryId + ", addTime=" + addTime
				+ ", biliCategory=" + biliCategory + "]";
	}
	
}
