package pers.design.utils;

public class TimeTransformUtils {
	public static String toMinutesAndSeconds(int number) {
		int hours;
		int minutes;
		int seconds;
		hours=number/3600;
		number=number-hours*3600;
		minutes=number/60;
		number=number-minutes*60;
		seconds=number;
		
		String s="";
		String m="";
		String h="";
		if(seconds<10) {
			s="0"+seconds;
		}else {
			s=seconds+"";
		}
		if(minutes<10) {
			m="0"+minutes;
		}else {
			m=minutes+"";
		}
		if(hours<10) {
			h="0"+hours;
		}else {
			h=hours+"";
		}
		if(hours==0) {
			return m+":"+s;
		}else {
			return h+":"+m+":"+s;
		}
		
	}
}
