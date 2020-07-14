package pers.design.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pers.design.pojo.NbaRank;

public class NbaRankSpider {
	private static ArrayList<NbaRank> list=new ArrayList<NbaRank>();
	
	public static ArrayList<NbaRank> runSpider(){
		String url="https://nba.hupu.com/standings";
		try {
			Document doc = Jsoup.connect(url).get();
			Element element=doc.select("table").first();
			Elements trs=element.select("tr");
			getContent(trs, 2, 17);
			getContent(trs, 19, 34);
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static void getContent(Elements trs,int startRow,int endRow) {//抓取数据
		for(int i=startRow;i<endRow;i++) {
			Elements tds=trs.get(i).select("td");
			NbaRank team=new NbaRank();
			for(int j=0;j<4;j++) {
				String str=tds.get(j).text().toString();
				switch(j) {
					case 0: team.setRank(str);break;
					case 1:team.setTeamName(str);team.setTeamLink(tds.get(j).select("a").attr("href"));break;
					case 2:team.setWinCount(str);break;
					case 3:team.setLoseCount(str);break;
					default:break;
					}
				}
			if(endRow<19) {
				team.setBelong("东部");
			}else {
				team.setBelong("西部");
			}
			list.add(team);
			}
	}
}
