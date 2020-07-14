package pers.design.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.design.mapper.BiliRankMapper;
import pers.design.pojo.BiliCategory;
import pers.design.pojo.BiliRank;
import pers.design.pojo.User;
import pers.design.service.BiliCategoryService;
import pers.design.service.BiliRankService;
import pers.design.service.impl.BiliCategoryServiceImpl;

@Controller
public class BiliRankController {
	@Resource
	private BiliRankService biliRankServiceImpl;
	@Resource
	private BiliCategoryService biliCategoryServiceImpl;
	
	@RequestMapping("bilirank")
	public String changeCatgegoryId(@RequestParam(defaultValue="1") int categoryId,@RequestParam(defaultValue="1") int pageNum ,HttpServletRequest request,HttpServletResponse response) {
		int count=biliRankServiceImpl.dataCountByCategoryId(categoryId);
		int pageSize=10;
		int totalPages=count%pageSize==0?count/pageSize:count/pageSize+1;
		request.setAttribute("categoryId", categoryId);
		request.setAttribute("currentPage", pageNum);
		request.setAttribute("totalPages", totalPages);
		return "bilirank";
	}
	@RequestMapping("bilirank_content")
	@ResponseBody
	public HashMap<Object,Object> initialize(Integer categoryId,Integer currentPage, HttpServletRequest request) {
		HashMap<Object, Object> map=new HashMap<>();
		int pageSize=10;
		List<BiliCategory> list1= biliCategoryServiceImpl.getAllCategory();
		List<BiliRank> list2=biliRankServiceImpl.selByPageAndCategoryId(currentPage,pageSize,categoryId);
		map.put("category", list1);
		map.put("rank", list2);
		return map;
	}
	
	//¹Ø¼ü×ÖËÑË÷
	@RequestMapping("keysearch")
	public String getKeyword(String keyword,HttpServletRequest request) {
		request.setAttribute("keyword", keyword);
		return "bilirank_search";
	}
	
	@RequestMapping("show_keysearch")
	@ResponseBody
	public HashMap<String, Object> searchByKeyword(String keyword) {
		HashMap<String, Object> map=new HashMap<>();
		List<BiliRank> list= biliRankServiceImpl.selByKeyword(keyword);
		map.put("rank", list);
		return map;
	}
	
	
	
}
