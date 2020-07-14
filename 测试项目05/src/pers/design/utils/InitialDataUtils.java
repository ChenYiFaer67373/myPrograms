package pers.design.utils;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pers.design.pojo.BiliCategory;
import pers.design.pojo.BiliRank;
import pers.design.pojo.NbaRank;
import pers.design.service.BiliCategoryService;
import pers.design.service.BiliRankService;
import pers.design.service.NbaRankService;
import pers.design.service.UserService;
/**
 * \@Resource���ܶ���ɾ�̬��
 * ����ʹ�õ���ģʽ�������
 * @author WangChengCheng
 *
 */
@Component
public class InitialDataUtils {
	@Resource
	private BiliRankService biliRankServiceImpl;
	@Resource
	private BiliCategoryService biliCategoryServiceImpl;
	@Resource
	private NbaRankService nbaRankServiceImpl;
	@Resource
	private UserService userServiceImpl;
	
	private static InitialDataUtils utils;
	
	@PostConstruct
	public void init() {
		utils=this;
	}
	
//	public static InitialDataUtils getUtils() {
//		return utils;
//	}
	
	private static List<BiliCategory> list1=null;
	private static List<BiliRank> list2=null;
	private static List<NbaRank> list3=null;
	private static HashMap<String, Object> map=null;
	
	//û�е�¼ʱ�����ݳ�ʼ����ҳ
	public static HashMap<String, Object> InitialData(){
		//��ȡ����
		 list1 = utils.biliCategoryServiceImpl.getAllCategory();
		 list2=utils.biliRankServiceImpl.getAllData();
		 list3=utils.nbaRankServiceImpl.getAllRank();
		 
		 //�����ݲ���map
		 map.put("biliCategory", list1);
		 map.put("biliRank", list2);
		 map.put("nbaRank", list3);
		 
		 return map;
	}
	
	//û�е�¼��ʼ��bili��ҳ������
	public static HashMap<String, Object> InitialBiliData(){
		list1 = utils.biliCategoryServiceImpl.getAllCategory();
		list2=utils.biliRankServiceImpl.getAllData();
		map.put("biliCategory", list1);
		map.put("biliRank", list2);
		return map;
	}
	
	public static HashMap<String, Object> InitialBiliDataByUser(){
		list1 = utils.biliCategoryServiceImpl.getAllCategory();
		list2=utils.biliRankServiceImpl.getAllData();
		map.put("biliCategory", list1);
		map.put("biliRank", list2);
		return map;
		//TODO
	}
	
	
	

}
