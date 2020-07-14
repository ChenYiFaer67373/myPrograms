package pers.design.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import pers.design.pojo.User;

public interface UserMapper {
	List<User> selAll();
	public String selectUserName(String userName);
	public User selectUserByNameAndPassword(@Param("userName")String userName,@Param("password")String password);//��¼
	public int updateUserInformation(User user);//�޸ĸ�����Ϣ
	public int updatePassword(User user);//�޸�����
	public int countOfUserName(String userName);//�ж��Ƿ����и��û���
	public void insertNewUser(String userName,String password,Date registerDate);//ע��
}
