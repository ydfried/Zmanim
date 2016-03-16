import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;

 


public class Program {

	public static void main(String[] args) {		
			
			Timer timer = new Timer();
	        Calendar date = Calendar.getInstance();
	        //Setting the date from when you want to activate scheduling
	        date.set(2016, 2, 16, 1, 00);
	        System.out.println(date.getTime());
	        //execute every 3 seconds
	        timer.schedule(new DailyRun(), date.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
	
		//DailyRun test = new DailyRun();
	//test.run();
	
	}

}
