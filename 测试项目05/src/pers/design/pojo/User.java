package pers.design.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private int UID;
	private String userName;
	private String password;
	private int age;
	private String sex;
	private String email;
	private boolean isAdmin;
	private Date registerDate;
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [UID=" + UID + ", userName=" + userName + ", password=" + password + ", age=" + age + ", sex="
				+ sex + ", email=" + email + ", isAdmin=" + isAdmin + ", registerDate=" + registerDate + "]";
	}
	
}
