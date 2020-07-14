package pers.design.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.design.pojo.BiliCategory;
import pers.design.pojo.BiliRank;
import pers.design.pojo.MusicTopList;
import pers.design.pojo.NewGame;
import pers.design.service.BiliCategoryService;
import pers.design.service.MusicTopListService;
import pers.design.service.UserService;
import pers.design.service.impl.BiliCategoryServiceImpl;
import pers.design.spider.BilibiliSpider;
import pers.design.spider.GameSpider;
import pers.design.spider.MusicSpider;

@Controller
public class AdminController {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private MusicTopListService musicTopListServiceImpl;
	@Resource 
	private BiliCategoryService biliCategoryServiceImpl;
	
	
	@RequestMapping("admin/biliRank")
	public String BiliRank() {
		return "redirect:admin.jsp";
	}
	@RequestMapping("admin/music")
	public String music() {
		return "redirect:admin_music.jsp";
	}
	@RequestMapping("admin/newGame")
	public String NewGame() {
		return "redirect:admin_newGame.jsp";
	}
	
	@RequestMapping("admin/loadBiliCategory")
	@ResponseBody
	public List<BiliCategory> loadBiliCategory(){
		return biliCategoryServiceImpl.getAllCategoryByAdmin();
	}
	
	@RequestMapping("admin/updateBiliData")
	@ResponseBody
	public void updateBiliData() {
		BilibiliSpider.runSpider();
	}
	@RequestMapping("admin/changeBiliCategoryStatus")
	@ResponseBody
	public int changeBiliCategoryStatus(int categoryId, int status) {
		if(status==1) {
			status=0;
		}else if(status==0) {
			status=1;
		}
		biliCategoryServiceImpl.changeBiliCategoryStatus(categoryId, status);
		return status;
	}
	@RequestMapping("admin/addNewCategory")
	@ResponseBody
	public int addNewCategory(int categoryId,String categoryName,String categoryUrl) {
		System.out.println(categoryId+" "+categoryName);
		return biliCategoryServiceImpl.addBiliCategory(categoryId, categoryName, categoryUrl);
	}
	
	@RequestMapping("admin/loadMusicTopList")
	@ResponseBody
	public List<MusicTopList> showMusicList(){
		return musicTopListServiceImpl.selAllByAdmin();
	}
	@RequestMapping("admin/updateMusicData")
	@ResponseBody
	public int updateMusicData() {
		MusicSpider spider=MusicSpider.getInstance();
		try {
			spider.runSpider();
			return 1;
		} catch (IOException e) {
			return 0;
		}
	}
	@RequestMapping("admin/addMusicTopList")
	@ResponseBody
	public int addMusicTopList(int listId,String name) {
		int count=musicTopListServiceImpl.countOfListId(listId);
		if(count==1) {
			return 0;
		}else {
			String apiUrl="https://api.itooi.cn/music/netease/songList?key=579621905&id="+listId+"&limit=10&offset=0";
			MusicTopList list=new MusicTopList(listId, name, apiUrl);
			musicTopListServiceImpl.addMusicList(list);
			MusicSpider spider= MusicSpider.getInstance();
			try {
				spider.updateContentByApiUrl(apiUrl);
				return 1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return 0;
			}
		}
		
	}
	
	@RequestMapping("admin/changeMusicListStatus")
	@ResponseBody
	public int delMusicTopList(int listId,int status) {
		if(status==1) {
			status=0;
		}else if(status==0) {
			status=1;
		}
		musicTopListServiceImpl.changeMusicListStatus(listId, status);
		return status;
	}
	
	@RequestMapping("admin/updateNewGame")
	@ResponseBody
	public int updateNewGame() {
		return GameSpider.runSpider();
	}
}
