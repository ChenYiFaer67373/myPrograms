package pers.design.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.design.pojo.NewGame;
import pers.design.service.NewGameService;

@Controller
public class NewGameController {
	@Resource
	private NewGameService newGameServiceImpl;
	
//	@RequestMapping("game")
//	public String showGame(HttpServletRequest request){
//		List<NewGame> list=newGameServiceImpl.selAll();
//		request.setAttribute("game", list);
//		return "redirect:game.jsp";
//	}
}
