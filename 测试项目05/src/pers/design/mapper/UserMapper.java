package pers.design.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import pers.design.pojo.User;

public interface UserMapper {
	List<User> selAll();
	public String selectUserName(String userName);
	public User selectUserByNameAndPassword(@Param("userName")String userName,@Param("password")String password);//登录
	public int updateUserInformation(User user);//修改个人信息
	public int updatePassword(User user);//修改密码
	public int countOfUserName(String userName);//判断是否已有该用户名
	public void insertNewUser(String userName,String password,Date registerDate);//注册
}
