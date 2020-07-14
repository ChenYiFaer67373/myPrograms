package pers.design.service;

import java.util.Date;
import java.util.List;

import pers.design.pojo.User;

public interface UserService {
	User Login(String username,String password);//��¼
	List<User> selAll();
	public void registerAccount(String username,String password);//ע��
	public boolean isExisted(String userame);
	public int updateUserInformation(User user);//������Ϣ
	public void resetUserPassword(User user);//�޸�����
	public int countOfUserName(String userName);//�ж��û����Ƿ���ڣ�����0����
}
