package pers.design.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pers.design.pojo.BiliCategory;
import pers.design.pojo.BiliRank;
import pers.design.pojo.MusicTopList;
import pers.design.pojo.NewGame;
import pers.design.pojo.User;
import pers.design.service.BiliCategoryService;
import pers.design.service.BiliRankService;
import pers.design.service.MusicTopListService;
import pers.design.service.NbaRankService;
import pers.design.service.NewGameService;
import pers.design.service.UserService;
import pers.design.service.impl.BiliCategoryServiceImpl;
import pers.design.service.impl.BiliRankServiceImpl;
import pers.design.service.impl.NbaRankServiceImpl;
import pers.design.service.impl.NewGameServiceImpl;
import pers.design.service.impl.UserServiceImpl;
import pers.design.utils.InitialDataUtils;

@Controller
public class SystemController {
	
	@Resource
	private BiliRankService BiliRankServiceImpl;
	@Resource
	private NbaRankService nbaRankServiceImpl;
	@Resource
	private NewGameService newGameServiceImpl;
	@Resource
	private MusicTopListService musicTopListServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping("checkUserName")
	@ResponseBody
	public boolean checkUserName(@RequestParam(required=true)String userName,HttpServletRequest request) {
		User user= (User) request.getSession().getAttribute("user");
		if(user.getUserName().equals(userName)) {//userName未修改直接返回true
			return true;
		}else {
			int count=userServiceImpl.countOfUserName(userName);
			if(count==0) {//数据库中没有该userName，可以使用
				return true;
			}else {//不能使用该userName，返回false
				return false;
			}
		}
	}
	
	@RequestMapping("checkUserNameForRegister")
	@ResponseBody
	public boolean checkUserNameForRegister(String userName,HttpServletRequest request) {
		int count=userServiceImpl.countOfUserName(userName);
		if(count==0) {
			return true;
		}else {
			return false;
		}
	}
	
	@RequestMapping("game")
	@ResponseBody
	public List<NewGame> loadGame(){
		return newGameServiceImpl.selAll();
		
	}
	
}
