package pers.design.spider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.ws.api.Cancelable;

import pers.design.pojo.NewGame;
import pers.design.service.impl.NewGameServiceImpl;

public class GameSpider {
	private static List<NewGame> list=new ArrayList<>();
	
	public static int runSpider(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		NewGameServiceImpl impl=ac.getBean("newGameServiceImpl",NewGameServiceImpl.class);
		List<String> urlList=new ArrayList<>();//保存要爬的链接
		Calendar cale=Calendar.getInstance();//设置年份和月份
		int Year=cale.get(Calendar.YEAR);
		int startMonth=cale.get(Calendar.MONTH)+1;
		int endMonth;
		if(startMonth<11) {
			endMonth=startMonth+2;
		}else {
			endMonth=12;
		}
		for(int i=startMonth;i<=endMonth;i++) {
			String url;
			for(int j=1;j<=3;j++) {
				if(i<10) {
					url="https://www.3dmgame.com/release/pc"+Year+"0"+i+"_"+j;
				}else {
					url="https://www.3dmgame.com/release/pc"+Year+i+"_"+j;
				} 
				urlList.add(url);
			}
			
		}
		impl.delAllData();
		for(int j=0;j<urlList.size();j++) {
			try {
				Document doc= Jsoup.connect(urlList.get(j)).get();
				Elements eles=doc.select("div.lis");
				for(int i=0;i<eles.size();i++) {
					NewGame g=new NewGame();
					String name= eles.get(i).select("div.bt a").text().toString();
					String introduceUrl=eles.get(i).select("div.bt a").attr("href");
					Elements lis=eles.get(i).select("ul.infolis li");
					String company=lis.get(1).text().toString();
					String date=lis.get(2).text().toString();
					String type=lis.get(3).text().toString();
					String score=eles.get(i).select("div.scobox div span").text().toString();
					String img=eles.get(i).select(".img img").attr("src").toString();
					g.setName(name);
					g.setCompany(company.substring((company.lastIndexOf("："))+1));
					g.setDate(date.substring((date.lastIndexOf("："))+1));
					g.setType(type.substring((type.lastIndexOf("："))+1));
					g.setScore(score);
					g.setImg(img);
					g.setIntroduceUrl(introduceUrl);
					list.add(g);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return impl.updateData(list);
	}
}
