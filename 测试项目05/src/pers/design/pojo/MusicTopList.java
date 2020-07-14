package pers.design.pojo;

public class MusicTopList {
	public int listId;
	public String name;
	public String apiUrl;
	public int position;
	public int status;
	public MusicTopList() {
		super();
	}
	
	public MusicTopList(int listId, String name, String apiUrl) {
		super();
		this.listId = listId;
		this.name = name;
		this.apiUrl = apiUrl;
	}

	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MusicTopList [listId=" + listId + ", name=" + name + ", apiUrl=" + apiUrl + ", position=" + position
				+ ", status=" + status + "]";
	}
	
	
}
