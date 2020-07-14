package pers.design.pojo;

public class NbaRank {
	private String rank;
	private String teamName;
	private String teamLink;
	private String winCount;
	private String loseCount;
	private String belong;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamLink() {
		return teamLink;
	}
	public void setTeamLink(String teamLink) {
		this.teamLink = teamLink;
	}
	public String getWinCount() {
		return winCount;
	}
	public void setWinCount(String winCount) {
		this.winCount = winCount;
	}
	public String getLoseCount() {
		return loseCount;
	}
	public void setLoseCount(String loseCount) {
		this.loseCount = loseCount;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	@Override
	public String toString() {
		return "NbaRank [rank=" + rank + ", teamName=" + teamName + ", teamLink=" + teamLink + ", winCount=" + winCount
				+ ", loseCount=" + loseCount + ", belong=" + belong + "]";
	}
}
