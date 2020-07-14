package pers.design.pojo;

public class BiliCategory {
	public int categoryId;
	public String categoryName;
	public String categoryUrl;
	public int status;
	
	public BiliCategory() {
		super();
	}
	
	public BiliCategory(int categoryId, String categoryName, String categoryUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryUrl = categoryUrl;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryUrl() {
		return categoryUrl;
	}
	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BiliCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryUrl="
				+ categoryUrl + ", status=" + status + "]";
	}
	
	
}
