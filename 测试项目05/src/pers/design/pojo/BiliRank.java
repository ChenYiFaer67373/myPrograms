package pers.design.pojo;

public class BiliRank {
	public int ranking;
	public int categoryId;
	public String videoName;
	public int playTimes;
	public String danmuNum;
	public String upLoader;
	public int score;
	public String videoUrl;
	public String upLoaderUrl;
	public String cnTimes;
	public BiliCategory biliCategory;
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public int getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(int playTimes) {
		this.playTimes = playTimes;
	}
	
	public String getDanmuNum() {
		return danmuNum;
	}
	public void setDanmuNum(String danmuNum) {
		this.danmuNum = danmuNum;
	}
	public String getUpLoader() {
		return upLoader;
	}
	public void setUpLoader(String upLoader) {
		this.upLoader = upLoader;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getUpLoaderUrl() {
		return upLoaderUrl;
	}
	public void setUpLoaderUrl(String upLoaderUrl) {
		this.upLoaderUrl = upLoaderUrl;
	}
	public String getCnTimes() {
		return cnTimes;
	}
	public void setCnTimes(String cnTimes) {
		this.cnTimes = cnTimes;
	}
	@Override
	public String toString() {
		return "BiliRank [ranking=" + ranking + ", categoryId=" + categoryId + ", videoName=" + videoName
				+ ", playTimes=" + playTimes + ", danmuNum=" + danmuNum + ", upLoader=" + upLoader + ", score=" + score
				+ ", videoUrl=" + videoUrl + ", upLoaderUrl=" + upLoaderUrl + ", cnTimes=" + cnTimes + ", biliCategory="
				+ biliCategory + "]";
	}
	
	
	
}
