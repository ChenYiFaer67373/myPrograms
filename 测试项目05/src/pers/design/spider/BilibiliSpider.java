

package pers.design.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.design.pojo.BiliCategory;
import pers.design.pojo.BiliRank;
import pers.design.service.impl.BiliCategoryServiceImpl;
import pers.design.service.impl.BiliRankServiceImpl;

public class BilibiliSpider {
	private static ArrayList<BiliRank> list=new ArrayList<BiliRank>();
	public static void runSpider() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		BiliCategoryServiceImpl category=ac.getBean("biliCategoryServiceImpl",BiliCategoryServiceImpl.class);
		BiliRankServiceImpl rank=ac.getBean("biliRankServiceImpl",BiliRankServiceImpl.class);
		rank.ClearRankTable();
		List<BiliCategory> categoryList=category.getAllCategory();
		for (BiliCategory c : categoryList) {
			getContentByUrl(c.getCategoryUrl(),c.getCategoryId());
		}
		rank.InsertAllRank(list);
		System.out.println("数据已插入完成");
	}
	
	private static void getContentByUrl(String url,int categoryId) {
		try {
			Document doc=Jsoup.connect(url).get();
			Elements eles=doc.select("div.info");
			System.out.println(eles.size());
			for(int i=0;i<eles.size();i++) {
				BiliRank br=new BiliRank();
				String videoName=eles.get(i).select("a.title").text().toString();
				if(videoName.length()>=42) {
					videoName=videoName.substring(0, 40)+"...";
				}
				String videoUrl="https:"+eles.get(i).select("a.title").attr("href").toString();
				
				Elements infos=eles.get(i).select("div.detail span");
				String cnTimes=infos.get(0).ownText().toString();
				int playTimes=0;
				if (cnTimes.contains("万")) {
					Double d=Double.valueOf(cnTimes.replace("万", "").trim())*10000;
					playTimes=d.intValue();
				}else if(cnTimes.contains("亿")) {
					Double d=Double.valueOf(cnTimes=cnTimes.replace("亿", "").trim())*100000000;
					playTimes=d.intValue();
				}
				else {
					playTimes=Integer.parseInt(cnTimes);
				}
				String danmuNum=infos.get(1).ownText().toString();
				String upLoader=infos.get(2).ownText().toString();
				
				String upLoaderUrl="https:"+eles.get(i).select("div.detail a").attr("href").toString();
				
				int score=Integer.parseInt(eles.get(i).select("div.pts div").text().toString());
				br.setCategoryId(categoryId);
				br.setRanking(i+1);
				br.setVideoName(videoName);
				br.setPlayTimes(playTimes);
				br.setDanmuNum(danmuNum);
				br.setUpLoader(upLoader);
				br.setScore(score);
				br.setVideoUrl(videoUrl);
				br.setUpLoaderUrl(upLoaderUrl);
				br.setCnTimes(cnTimes);
				br.toString();
				list.add(br);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
