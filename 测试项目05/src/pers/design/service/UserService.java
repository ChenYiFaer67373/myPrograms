package pers.design.service;

import java.util.Date;
import java.util.List;

import pers.design.pojo.User;

public interface UserService {
	User Login(String username,String password);//登录
	List<User> selAll();
	public void registerAccount(String username,String password);//注册
	public boolean isExisted(String userame);
	public int updateUserInformation(User user);//更新信息
	public void resetUserPassword(User user);//修改密码
	public int countOfUserName(String userName);//判断用户名是否存在，返回0可用
}
