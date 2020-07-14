package pers.design.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.design.pojo.MusicListContent;
import pers.design.pojo.MusicTopList;
import pers.design.pojo.User;
import pers.design.service.MusicListContentService;
import pers.design.service.MusicTopListService;

@Controller
public class MusicTopListController {
	@Resource
	private MusicTopListService musicTopListServiceImpl;
	@Resource
	private MusicListContentService musicListContentServiceImpl;
	
	@RequestMapping("music")
	public String musicTopList(@RequestParam(defaultValue="19723756")int listId,HttpServletRequest request){
		request.setAttribute("listId",listId);
		return "music";
	}
	
	@RequestMapping("music/musicTopList")
	@ResponseBody
	public List<MusicTopList> loadList(){
		return musicTopListServiceImpl.selAll();
	}
	@RequestMapping("music/musicListContent")
	@ResponseBody
	public List<MusicListContent> loadContent(int listId){
		return musicListContentServiceImpl.selByListId(listId);
	}
	
}
