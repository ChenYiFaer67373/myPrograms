package pers.design.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.media.jfxmedia.control.VideoDataBuffer;

import pers.design.pojo.MusicListContent;
import pers.design.pojo.MusicTopList;
import pers.design.service.impl.MusicListContentServiceImpl;
import pers.design.service.impl.MusicTopListServiceImpl;
import pers.design.utils.TimeTransformUtils;

public class MusicSpider {
	private static MusicSpider instance=new MusicSpider();
	private MusicSpider() {}
	public static MusicSpider getInstance() {
		return instance;
	}
	
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	MusicTopListServiceImpl topListImpl=ac.getBean("musicTopListServiceImpl",MusicTopListServiceImpl.class);
	MusicListContentServiceImpl contentImpl=ac.getBean("musicListContentServiceImpl",MusicListContentServiceImpl.class);
	public void runSpider() throws IOException {
		
		List<MusicTopList> topList= topListImpl.selAll();
		ArrayList<String> apiUrls=new ArrayList<>();
		for (MusicTopList musicTopList : topList) {
			apiUrls.add(musicTopList.getApiUrl());
		}
		for (String apiUrl : apiUrls) {
			updateContentByApiUrl(apiUrl);
		}
		System.out.println("数据库更新完成！");
	}
	
	public void updateContentByApiUrl(String apiUrl) throws IOException {
		Document doc=Jsoup.connect(apiUrl).ignoreContentType(true)
				.header("Accept","*/*")
				.header("Accept-Encoding", "gzip, deflate")
				.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
				.header("Content-Type", "application/json;charset=UTF-8")
				.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
				.timeout(10000).get();
		Element body=doc.body();
		JSONObject object=JSONObject.parseObject(body.text());
		JSONObject data=object.getJSONObject("data");
		Integer listId=Integer.parseInt(data.getString("songListId"));//榜单id
		JSONArray songs=data.getJSONArray("songs");
		List<MusicListContent> contentList=new ArrayList<>();
		for(int i=0;i<songs.size();i++) {
			Integer singId=Integer.parseInt(songs.getJSONObject(i).getString("id"));//歌曲id
			String singName=songs.getJSONObject(i).getString("name");//歌名
			Integer t=songs.getJSONObject(i).getInteger("time");
			String time=TimeTransformUtils.toMinutesAndSeconds(t);//时间
			String singer=songs.getJSONObject(i).getString("singer");//歌手
			if(singer.length()>150) {
				singer=singer.substring(0, 150);
			}
			int rank=i+1;//排名
			String singUrl="https://music.163.com/song/media/outer/url?id="+singId+".mp3";//歌曲外链
			MusicListContent content=new MusicListContent(listId, singId, singName, time, singer, rank, singUrl);
			contentList.add(content);
		}
		contentImpl.delMusicListContent(listId);
		try {
			System.out.println("正在更新歌单"+listId);
			contentImpl.addAllContent(contentList);
		} catch (Exception e) {
			System.out.println("添加失败！");
		}
		
	}

}
