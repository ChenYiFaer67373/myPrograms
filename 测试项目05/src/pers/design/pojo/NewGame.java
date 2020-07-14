package pers.design.pojo;

import java.util.Date;

public class NewGame {
	private int id;
	private String name;
	private String date;
	private String company;
	private String type;
	private String score;
	private String img;
	private String introduceUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getIntroduceUrl() {
		return introduceUrl;
	}
	public void setIntroduceUrl(String introduceUrl) {
		this.introduceUrl = introduceUrl;
	}
	@Override
	public String toString() {
		return "NewGame [id=" + id + ", name=" + name + ", date=" + date + ", company=" + company + ", type=" + type
				+ ", score=" + score + ", img=" + img + ", introduceUrl=" + introduceUrl + "]";
	}
	
	
	
}
