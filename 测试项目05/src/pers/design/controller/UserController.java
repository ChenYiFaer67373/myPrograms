package pers.design.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import javafx.scene.control.Alert;
import pers.design.pojo.BiliRank;
import pers.design.pojo.MusicListContent;
import pers.design.pojo.MusicTopList;
import pers.design.pojo.User;
import pers.design.pojo.UserBiliCategory;
import pers.design.pojo.UserMusicList;
import pers.design.service.BiliRankService;
import pers.design.service.MusicListContentService;
import pers.design.service.UserBiliCategoryService;
import pers.design.service.UserMusicListSerivce;
import pers.design.service.UserService;
import pers.design.service.impl.BiliRankServiceImpl;
import pers.design.service.impl.MusicListContentServiceImpl;
import pers.design.service.impl.UserBiliCategoryServiceImpl;
import pers.design.service.impl.UserMusicListServiceImpl;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private UserBiliCategoryService userBiliCategoryServiceImpl;
	@Resource
	private UserMusicListSerivce userMusicListServiceImpl;
	@Resource
	private MusicListContentService musicListContentServiceImpl;
	@Resource
	private BiliRankService biliRankServiceImpl;
	//ʹ��ajax�Ե�½������֤
	@RequestMapping("login")
	@ResponseBody
	public HashMap<String, String> login(String username,String password,HttpServletRequest request) {
		HashMap<String, String> map=new HashMap<>();
		String msg=null;
		if(userServiceImpl.Login(username, password)==null) {
			msg="error";
		}else {
			User user=userServiceImpl.Login(username, password);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("UID", user.getUID());
			System.out.println();
			if(user.isAdmin()) {
				msg= "admin";
			}else {
				msg= "user";
			}
		}
		map.put("msg", msg);
		return map;
	}
	
	//ע��
	@RequestMapping("register_do")
	public String register(String username,String password,HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
			userServiceImpl.registerAccount(username, password);
			return "redirect:index.jsp";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "register";
		}
		
	}
	
	//�˳���¼
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		return "redirect:index.jsp";
		
	}
	
	//���¸�����Ϣ  ����ҳ����user�·�����������mappingҪ��/user/����ƥ��
	@RequestMapping("user/updateInfo")
	@ResponseBody
	public User updateInfo(String username,@RequestParam(defaultValue="0")int age,Integer sex,String email,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(username+" "+age+" "+sex+" "+ email);
		user.setUserName(username);
		user.setAge(age);
		if(sex==1) {
			user.setSex("��");
		}else {
			user.setSex("Ů");
		}
		user.setEmail(email);
		userServiceImpl.updateUserInformation(user);
		return user;
	}
	
	@RequestMapping("user/resetpwd")
	@ResponseBody
	public Integer resetPwd(String password,String newPassword,String rePassword,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int result=0;
		String pwd=user.getPassword();
		if(password.equals(pwd)) {
			if(newPassword.length()>=6&&newPassword.length()<=16) {
				if(newPassword.equals(rePassword)) {
					if(newPassword.equals(password)) {
						result=5;//����û��
					}else {
						user.setPassword(newPassword);
						userServiceImpl.resetUserPassword(user);
						request.getSession().removeAttribute("user");
						result=1;//�����޸ĳɹ�
					}
				}else {
					result=4;//�������벻һ��
				}
			}else {
				result=3;//�����볤�Ȳ�����Ҫ��
			}
		}else {
			result=2;//ԭʼ�������
		}
		return result;
	}
	
	//���������ͷ��
	@RequestMapping("user/updatepic")
	public String updatePhoto(MultipartFile newPic,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		String photoName=String.valueOf(user.getUID())+newPic.getOriginalFilename().substring(newPic.getOriginalFilename().lastIndexOf("."));
		String path=request.getServletContext().getRealPath("img")+"/users/"+photoName;
		try {
			FileUtils.copyInputStreamToFile(newPic.getInputStream(), new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user/myphoto";
	}
	
	//����bilirankҳ����ղ����
	@RequestMapping("bili/loadCollectionStatus")
	@ResponseBody
	public int loadCollectionStatus(int categoryId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		int result= userBiliCategoryServiceImpl.countOfThisCategory(userId, categoryId);
		return result;
	}
	//ɾ���ղ�
	@RequestMapping("bili/deleteCollection")
	@ResponseBody
	public int deleteCollection(int categoryId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		return userBiliCategoryServiceImpl.deleteMyCollectedCategory(userId, categoryId);
	}
	//����ղ�
	@RequestMapping("bili/addCollection")
	@ResponseBody
	public int addCollection(int categoryId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		return userBiliCategoryServiceImpl.addMyCollectedCategory(userId, categoryId);
	}
	
	//����musicҳ����ղ�
	@RequestMapping("music/loadCollectionStatus")
	@ResponseBody
	public int loadMusicCollectionStatus(int listId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		return userMusicListServiceImpl.countOfThisMusicList(userId, listId);
	}
	@RequestMapping("music/deleteCollection")
	@ResponseBody
	public int deleteMusicCollection(int listId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		return userMusicListServiceImpl.delMyMusicList(userId, listId);
	}
	@RequestMapping("music/addCollection")
	@ResponseBody
	public int addMusicCollection(int listId,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		int userId=user.getUID();
		return userMusicListServiceImpl.addMyMusicList(userId, listId);
	}
	
	@RequestMapping("loadMyBiliCollections")//������ҳ�ҵ��ղ��б�
	@ResponseBody
	public List<UserBiliCategory> loadMyMusicLists(HttpServletRequest request){
		HashMap<String, Object> map=new HashMap<>();
		if(request.getSession().getAttribute("user")!=null) {
			User user=(User) request.getSession().getAttribute("user");
			int userId=user.getUID();
			return userBiliCategoryServiceImpl.selMyCollectedCategory(userId);
			//List<UserMusicList> userMusicLists=userMusicListServiceImpl.selMyMusicList(userId);
		}else {
			return null;
		}
	}
	
	@RequestMapping("loadMyMusicListCollections")//������ҳ�ҵ��ղ��б�
	@ResponseBody
	public List<UserMusicList> loadMyMusicListCollections(HttpServletRequest request){
		HashMap<String, Object> map=new HashMap<>();
		if(request.getSession().getAttribute("user")!=null) {
			User user=(User) request.getSession().getAttribute("user");
			int userId=user.getUID();
			return userMusicListServiceImpl.selMyMusicList(userId);
		}else {
			return null;
		}
	}
	@RequestMapping("changeMyMusicList")
	@ResponseBody
	public List<MusicListContent> changeMyMusicList(int musicListId){
		List<MusicListContent> content=musicListContentServiceImpl.selByListId(musicListId);
		return content;
	}
	
	@RequestMapping("changeMyBiliCategory")
	@ResponseBody
	public List<BiliRank> changeMyBiliCategory(int biliCategoryId){
		List<BiliRank> content=biliRankServiceImpl.getDataByCategory(biliCategoryId);
		return content;
	}
	
}
