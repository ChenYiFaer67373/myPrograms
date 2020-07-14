package pers.design.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pers.design.pojo.BiliRank;
import pers.design.pojo.NewGame;
import pers.design.pojo.UserBiliCategory;
import pers.design.pojo.UserMusicList;
import pers.design.service.impl.BiliRankServiceImpl;
import pers.design.service.impl.MusicListContentServiceImpl;
import pers.design.service.impl.NewGameServiceImpl;
import pers.design.service.impl.UserBiliCategoryServiceImpl;
import pers.design.service.impl.UserMusicListServiceImpl;
import pers.design.service.impl.UserServiceImpl;
import pers.design.spider.BilibiliSpider;
import pers.design.spider.GameSpider;
import pers.design.spider.MusicSpider;
import pers.design.utils.InitialDataUtils;
import pers.design.utils.TimeTransformUtils;

public class Test {
	public static void main(String[] args) {
//		System.out.println(InitialDataUtils.InitialBiliData());
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		NewGameServiceImpl gameImpl= ac.getBean("newGameServiceImpl",NewGameServiceImpl.class);
		gameImpl.delAllData();
//		List<NewGame> list= GameSpider.runSpider(4, 6);
//		for (NewGame newGame : list) {
//			gameImpl.insertData(newGame);
//			System.out.println("结束插入");
//		}
//		GameSpider.runSpider();
//		gameImpl.delAllData();
		
//		BiliRankServiceImpl impl=ac.getBean("biliRankServiceImpl",BiliRankServiceImpl.class);
//		List<BiliRank> list=impl.selByKeyword("蔡徐坤");
//		System.out.println(list.toString());
//		BilibiliSpider.runSpider();
		
//		List<BiliRank> list=impl.selByPageAndCategoryId(2, 10, 1);
//		for (BiliRank biliRank : list) {
//			System.out.println(biliRank.toString());
//		}
		
//		UserMusicListServiceImpl impl=ac.getBean("userMusicListServiceImpl",UserMusicListServiceImpl.class);
//		List<UserMusicList> list=impl.selMyMusicList(5);
//		System.out.println(list.toString());
//		MusicSpider spider=MusicSpider.getInstance();
//		try {
//			spider.updateContentByApiUrl("https://api.itooi.cn/music/netease/songList?key=579621905&id=522969515&limit=10&offset=0");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		UserBiliCategoryServiceImpl impl=ac.getBean("userBiliCategoryServiceImpl",UserBiliCategoryServiceImpl.class);
		//impl.deleteMyCollectedCategory(5, 1);
//		List<UserBiliCategory> list=impl.selMyCollectedCategory(5);
//		System.out.println(list.toString());
//		impl.addMyCollectedCategory(5, 1);
		
//		MusicListContentServiceImpl impl=ac.getBean("musicListContentServiceImpl",MusicListContentServiceImpl.class);
//		impl.updateListContent();
		
//		String s="{\"result\":\"SUCCESS\",\"code\":200,\"data\":{\"songListId\":\"60131\",\"songListName\":\"日本Oricon周榜\",\"songListPic\":\"https://p1.music.126.net/Rgqbqsf4b3gNOzZKxOMxuw==/19029247741938160.jpg?param=400y400\",\"songListCount\":36,\"songListPlayCount\":33705272,\"songListDescription\":\"ORICONSTYLE CD单曲周榜，每周三更新，欢迎关注。\",\"songListUserId\":48160,\"songs\":[{\"id\":\"1359261019\",\"name\":\"大人サバイバー\",\"singer\":\"ラストアイドル\",\"pic\":\"http://p1.music.126.net/GClDeVLUTrImnebnkOPG5g==/109951164004552111.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359261019&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359261019&key=579621905\",\"time\":266},{\"id\":\"1358897025\",\"name\":\"ブランニューパレード\",\"singer\":\"GANG PARADE\",\"pic\":\"http://p2.music.126.net/vfma48nqFmNN7yw5PafIog==/109951164000620725.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1358897025&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1358897025&key=579621905\",\"time\":207},{\"id\":\"1359263334\",\"name\":\"イチリンソウ\",\"singer\":\"山本彩\",\"pic\":\"http://p2.music.126.net/PTW4NHQuiznTQjdvLSc6BA==/109951164004552234.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359263334&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359263334&key=579621905\",\"time\":226},{\"id\":\"1354213977\",\"name\":\"キュン\",\"singer\":\"日向坂46\",\"pic\":\"http://p2.music.126.net/Dfc0THIkkLSnjzed1V85Rw==/109951163950608905.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1354213977&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1354213977&key=579621905\",\"time\":300},{\"id\":\"1361024358\",\"name\":\"ステンダ\",\"singer\":\"Kore:ct\",\"pic\":\"http://p2.music.126.net/Ch10txqNjd2-gRltvEpH3Q==/109951164021760198.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1361024358&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1361024358&key=579621905\",\"time\":0},{\"id\":\"1355861659\",\"name\":\"ハルノヒ\",\"singer\":\"あいみょん\",\"pic\":\"http://p2.music.126.net/gLZ7SWdTvnXuSGqIQE1uig==/109951163967389137.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1355861659&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1355861659&key=579621905\",\"time\":326},{\"id\":\"1359818126\",\"name\":\"百色リメイン\",\"singer\":\"スタァライト九九組\",\"pic\":\"http://p2.music.126.net/tb1IoleGKzr8vR2PuWfQiA==/109951164009719058.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359818126&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359818126&key=579621905\",\"time\":276},{\"id\":\"1335387738\",\"name\":\"THROW YA FIST\",\"singer\":\"THE RAMPAGE from EXILE TRIBE\",\"pic\":\"http://p2.music.126.net/0o5j6RcKBarH74O4ilunTQ==/109951163745900354.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1335387738&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1335387738&key=579621905\",\"time\":246},{\"id\":\"1359281576\",\"name\":\"きゅん・きゅん・まっくす\",\"singer\":\"藍原ことみ/中島由貴/都丸ちよ/高森奈津美/藤本彩花\",\"pic\":\"http://p2.music.126.net/Q0ySQP9jfmB3HKGzA2KNiw==/109951164004718125.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359281576&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359281576&key=579621905\",\"time\":251},{\"id\":\"1359275278\",\"name\":\"ボン♡キュッ♡ボンは彼のモノ♡\",\"singer\":\"上坂すみれ\",\"pic\":\"http://p2.music.126.net/J2nflUd5LxVSSl-oCWBBHg==/109951164004641890.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359275278&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359275278&key=579621905\",\"time\":247},{\"id\":\"1359356681\",\"name\":\"君を待ってる\",\"singer\":\"King & Prince\",\"pic\":\"http://p2.music.126.net/TNsiqoMoDVXOWXedFZ3KMQ==/109951164005245726.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359356681&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359356681&key=579621905\",\"time\":279},{\"id\":\"1357775558\",\"name\":\"令和\",\"singer\":\"ゴールデンボンバー\",\"pic\":\"http://p2.music.126.net/yLAqEdQgIoT4v3Lr8gemtw==/109951163988149277.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1357775558&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1357775558&key=579621905\",\"time\":241},{\"id\":\"1348774387\",\"name\":\"床の間正座娘\",\"singer\":\"NMB48\",\"pic\":\"http://p2.music.126.net/9ezh-BXEA2eCn-8uwF61ZQ==/109951163892347251.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1348774387&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1348774387&key=579621905\",\"time\":247},{\"id\":\"1359357306\",\"name\":\"意志\",\"singer\":\"HKT48\",\"pic\":\"http://p2.music.126.net/oKjAbCLmHW7QH-Tv4-31yA==/109951164005239153.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359357306&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359357306&key=579621905\",\"time\":291},{\"id\":\"1321427920\",\"name\":\"YEAH YEAH YEAH\",\"singer\":\"早安家族\",\"pic\":\"http://p1.music.126.net/d4BAXaaOHB1ARKKPN3jgvw==/109951163633494017.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1321427920&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1321427920&key=579621905\",\"time\":304},{\"id\":\"1357399415\",\"name\":\"BLUE SAPPHIRE\",\"singer\":\"HIROOMI TOSAKA\",\"pic\":\"http://p1.music.126.net/pkt84V0x2P-Ol1qgkUojKw==/109951164017151483.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1357399415&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1357399415&key=579621905\",\"time\":213},{\"id\":\"536622304\",\"name\":\"Lemon\",\"singer\":\"米津玄師\",\"pic\":\"http://p1.music.126.net/6IeZ9MiSSDXifj74nzH6ww==/109951163561494000.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=536622304&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=536622304&key=579621905\",\"time\":255},{\"id\":\"1359282189\",\"name\":\"YOU (with 小田和正)\",\"singer\":\"HIROBA/小田和正\",\"pic\":\"http://p1.music.126.net/J9JFHvCGEPi03ZlNFBq5Vw==/109951164004714764.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359282189&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359282189&key=579621905\",\"time\":262},{\"id\":\"1358943583\",\"name\":\"Brave Rejection\",\"singer\":\"Hi!Superb\",\"pic\":\"http://p1.music.126.net/fHE04qnK6nRf6mC-42An-A==/109951164000970602.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1358943583&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1358943583&key=579621905\",\"time\":249},{\"id\":\"1354742743\",\"name\":\"Are you ready?\",\"singer\":\"BiS\",\"pic\":\"http://p1.music.126.net/4pZdenYb_IR9CXJOyr0qdQ==/109951163956223216.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1354742743&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1354742743&key=579621905\",\"time\":684},{\"id\":\"1294889666\",\"name\":\"パプリカ\",\"singer\":\"Foorin\",\"pic\":\"http://p1.music.126.net/ISOs4Ur943_QwZvb-erOpA==/109951163424360191.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1294889666&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1294889666&key=579621905\",\"time\":208},{\"id\":\"1358188790\",\"name\":\"Tone\",\"singer\":\"蒼井翔太\",\"pic\":\"http://p1.music.126.net/0HoNkib1a2zyJsp7Lf4ZEQ==/109951163992175591.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1358188790&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1358188790&key=579621905\",\"time\":248},{\"id\":\"1359286480\",\"name\":\"「デンドロビューム」\",\"singer\":\"DADAROMA\",\"pic\":\"http://p1.music.126.net/Sfb3Fl-gGqEDsrhnW7hK7A==/109951164004738970.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359286480&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359286480&key=579621905\",\"time\":247},{\"id\":\"1359275307\",\"name\":\"Blast!\",\"singer\":\"TRUE\",\"pic\":\"http://p1.music.126.net/Yw5QCrHfYZ5wLw8tWyropQ==/109951164004654499.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359275307&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359275307&key=579621905\",\"time\":262},{\"id\":\"1348847724\",\"name\":\"黒い羊\",\"singer\":\"欅坂46\",\"pic\":\"http://p2.music.126.net/q0TGfaspB9fVYsnsAtHILA==/109951163909458025.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1348847724&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1348847724&key=579621905\",\"time\":307},{\"id\":\"1350336759\",\"name\":\"Yes we are\",\"singer\":\"三代目 J Soul Brothers from EXILE TRIBE\",\"pic\":\"http://p2.music.126.net/F_WwA9H5ZKKFMMgh57nGsw==/109951163907526061.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1350336759&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1350336759&key=579621905\",\"time\":255},{\"id\":\"1352962680\",\"name\":\"きみと恋のままで終われない いつも夢のままじゃいられない\",\"singer\":\"倉木麻衣\",\"pic\":\"http://p2.music.126.net/bEdnlQ6hXRlQSpNp94iDxQ==/109951163938206627.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1352962680&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1352962680&key=579621905\",\"time\":274},{\"id\":\"1354736940\",\"name\":\"有超天シューター\",\"singer\":\"祭nine.\",\"pic\":\"http://p2.music.126.net/wWKrCy0lfgaYhl2R_MQjPg==/109951163956204752.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1354736940&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1354736940&key=579621905\",\"time\":226},{\"id\":\"1356285954\",\"name\":\"Ambitious Eve\",\"singer\":\"シャイニーカラーズ\",\"pic\":\"http://p2.music.126.net/MTwEJjdQOrD_OJGc7nJXGw==/109951163971758669.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1356285954&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1356285954&key=579621905\",\"time\":233},{\"id\":\"1357960098\",\"name\":\"Ain Soph Aur ~GRANBLUE FANTASY~\",\"singer\":\"鈴村健一\",\"pic\":\"http://p2.music.126.net/SBOO-FIUw6X7TJtjv7LJrQ==/109951163990117276.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1357960098&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1357960098&key=579621905\",\"time\":256},{\"id\":\"1331529927\",\"name\":\"がってんShake!\",\"singer\":\"祭nine.\",\"pic\":\"http://p2.music.126.net/uHEFDsPBlKc5SUK5AM8jLA==/109951163709024942.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1331529927&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1331529927&key=579621905\",\"time\":239},{\"id\":\"547973442\",\"name\":\"HARE晴れカーニバル\",\"singer\":\"祭nine.\",\"pic\":\"http://p2.music.126.net/ls0nIq2j4tefRvZeIeIP7w==/109951163211859399.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=547973442&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=547973442&key=579621905\",\"time\":253},{\"id\":\"1321382222\",\"name\":\"Memorial\",\"singer\":\"King & Prince\",\"pic\":\"http://p2.music.126.net/nfS82fd8Apu4BFP47nf_9g==/109951163634928165.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1321382222&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1321382222&key=579621905\",\"time\":286},{\"id\":\"1359261373\",\"name\":\"mummy mummy\",\"singer\":\"BIGMAMA\",\"pic\":\"http://p2.music.126.net/3U8V-682f9G7fmEZrZKzoQ==/109951164004553558.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359261373&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359261373&key=579621905\",\"time\":234},{\"id\":\"565966016\",\"name\":\"シンデレラガール\",\"singer\":\"King & Prince\",\"pic\":\"http://p2.music.126.net/KBWmO7_aiHt8pEiAcPXlpw==/109951163311847550.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=565966016&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=565966016&key=579621905\",\"time\":253},{\"id\":\"1359787531\",\"name\":\"ゴールデンアフタースクール\",\"singer\":\"OxT\",\"pic\":\"http://p2.music.126.net/z7IVKLN_4kK1CJfgKAUmng==/109951164009458477.jpg?param=400y400\",\"lrc\":\"https://api.itooi.cn/music/netease/lrc?id=1359787531&key=579621905\",\"url\":\"https://api.itooi.cn/music/netease/url?id=1359787531&key=579621905\",\"time\":228}]}}";
//		JSONObject object=JSONObject.parseObject(s);
//		JSONObject data=object.getJSONObject("data");
//		Integer listId=Integer.parseInt(data.getString("songListId"));//榜单id
//		JSONArray songs=data.getJSONArray("songs");
//		for(int i=0;i<songs.size();i++) {
//			Integer singId=Integer.parseInt(songs.getJSONObject(i).getString("id"));//歌曲id
//			String singName=songs.getJSONObject(i).getString("name");//歌名
//			Integer t=songs.getJSONObject(i).getInteger("time");
//			String time=TimeTransformUtils.toMinutesAndSeconds(t);//时间
//			String singer=songs.getJSONObject(i).getString("singer");//歌手
//			int rank=i+1;//排名
//			String singUrl="https://music.163.com/song/media/outer/url?id="+singId+".mp3";//歌曲外链
//			System.out.println(listId+" "+singId+" "+singName+" "+time+" "+singer+" "+rank+" "+singUrl);
//			
//		}
		
		
		
		
		
		
	}
	public void test() {
//		HashMap<String, Object> map=InitialDataUtils.InitialData();
//		System.out.println(map);
		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		BiliCategoryServiceImpl impl=ac.getBean("biliCategoryServiceImpl",BiliCategoryServiceImpl.class);
		
//		List<NewGame> list= GameSpider.runSpider(4, 6);
//		for (NewGame newGame : list) {
//			System.out.println(newGame.toString());
//		}
	}
}
