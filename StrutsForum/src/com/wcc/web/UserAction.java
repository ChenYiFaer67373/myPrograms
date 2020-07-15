package com.wcc.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wcc.domain.User;
import com.wcc.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	public User user=new User();

	public String execute() throws Exception {
		
		System.err.println("我已经运行");
		UserService userService=new UserService();
		boolean success= userService.findUser(user);
		if(success) {
			return "success";
		}else {
			return "error";
		}
	}
	
public String register() throws Exception {
		
		System.err.println("register已经运行");
		UserService userService=new UserService();
		boolean success= userService.findUser(user);
		if(success) {
			return "success";
		}else {
			return "error";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
