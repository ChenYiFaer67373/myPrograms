package pers.design.pojo;

public class MusicListContent {
	private int listId;
	private int singId;
	private String singName;
	private String time;
	private String singer;
	private int rank;
	private String singUrl;
	public MusicTopList musicTopList;
	
	public MusicListContent() {
		super();
	}
	public MusicListContent(int listId, int singId, String singName, String time, String singer, int rank, String singUrl) {
		super();
		this.listId = listId;
		this.singId = singId;
		this.singName = singName;
		this.time = time;
		this.singer = singer;
		this.rank = rank;
		this.singUrl = singUrl;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public int getSingId() {
		return singId;
	}
	public void setSingId(int singId) {
		this.singId = singId;
	}
	public String getSingName() {
		return singName;
	}
	public void setSingName(String singName) {
		this.singName = singName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getSingUrl() {
		return singUrl;
	}
	public void setSingUrl(String singUrl) {
		this.singUrl = singUrl;
	}
	@Override
	public String toString() {
		return "MusicListContent [listId=" + listId + ", singId=" + singId + ", singName=" + singName + ", time=" + time
				+ ", singer=" + singer + ", rank=" + rank + ", singUrl=" + singUrl + "]";
	}
	
	
}
