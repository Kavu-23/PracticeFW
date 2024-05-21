package javaBasic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SupportDate {

	public static void main(String[] args) {
		
		/*Date d=new Date();
		System.out.println(d.toString());*/ //todays date from system
		Date d=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
		String actDate = sim.format(d);
		System.out.println(actDate);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dataReq = sim.format(cal.getTime());
		System.out.println(dataReq);
		
		
		

	}

}
