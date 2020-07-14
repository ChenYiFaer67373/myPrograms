package pers.design.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.UserMapper;
import pers.design.pojo.User;
import pers.design.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override//登录
	public User Login(String username, String password) {
		User user= userMapper.selectUserByNameAndPassword(username, password);
		return user;
	}

	@Override
	public List<User> selAll() {
		return userMapper.selAll();
	}

	@Override//注册
	public void registerAccount(String username, String password) {
		Date registerDate=new Date();
		userMapper.insertNewUser(username, password,registerDate);
		
	}

	@Override
	public boolean isExisted(String userame) {
		if(userMapper.selectUserName(userame)==null) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override//更新信息
	public int updateUserInformation(User user) {
		return userMapper.updateUserInformation(user);
		
	}

	@Override//修改密码
	public void resetUserPassword(User user) {
		userMapper.updatePassword(user);
		
	}

	@Override
	public int countOfUserName(String userName) {
		return userMapper.countOfUserName(userName);
	}


}
