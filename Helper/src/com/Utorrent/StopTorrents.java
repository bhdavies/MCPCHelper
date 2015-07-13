package com.Utorrent;

import java.util.Date;
import java.util.Calendar;

public class StopTorrents implements  Runnable {
	
	
	
	public void run() {
		UtorrentActions ua = new UtorrentActions();
		int code = ua.webUiLogin();
		if(code == 200){
			ua.killSeeders(ua.getTorrents());
			try {
				Thread.sleep(getWaitTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static long getWaitTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int houreOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		if(houreOfDay > 15 && houreOfDay < 21){
			return 300000l; //5 min
		}
		return 3600000; //60 min
	}


}
