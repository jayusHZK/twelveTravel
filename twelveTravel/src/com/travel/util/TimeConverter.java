package com.travel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {
	public String NumIsTime(Integer time){
		String result1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(time * 1000));
		System.out.println("10位数的时间戳（秒）--->Date:" + result1);
		return result1;
	}
}
