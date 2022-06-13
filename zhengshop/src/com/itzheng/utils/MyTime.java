package com.itzheng.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyTime {
	
	public static String getTime() {

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String str = simpleDateFormat.format(date);
		//05/12/2021 1:56 PM
		GregorianCalendar ca = new GregorianCalendar();
	    int a  = ca.get(GregorianCalendar.AM_PM);
	    
	    String wk = "AM";
	    
	    if(a == 1) {
	    	wk = "PM";
	    }
	    if(a == 0) {
	    	wk = "AM";
	    }

	    System.out.println(str+" "+wk);
	    return str+" "+wk;
	}

}
