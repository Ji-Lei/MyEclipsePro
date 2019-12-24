package com.air.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	public static String nowTime() {
		String nowTime="";
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		nowTime=dateFormat.format(date);
		return nowTime;
	}
}
