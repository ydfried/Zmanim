import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;

// each UsersReminder Object will store the users location and desired reminders as booleans 
// for now we are only offering a few options

public class UsersReminder {
	
	private GeoLocation location;
	
	private ComplexZmanimCalendar calendar;

	private Timer timer = new Timer();
	
	private String phoneNumber;
	


	public UsersReminder (String phoneNumber, String location, double lat, double lon, TimeZone timezone, boolean a, boolean y, boolean su, boolean shma1, boolean shma2, boolean tfila, boolean p, boolean sun){
		this.phoneNumber = phoneNumber;
		this.location = new GeoLocation(location, lat, lon, timezone);
		this.calendar = new ComplexZmanimCalendar(this.location);	
		//this.calendar.getCalendar().roll(Calendar.DAY_OF_YEAR, 1);
		
		System.out.println(this.calendar.getAlosHashachar());
		System.out.println(this.calendar.getSunrise());
		System.out.println(this.calendar.getSofZmanShmaGRA());
		
		if(a)
			timer.schedule(new MyTimeTask("Alos now!", this.phoneNumber), this.calendar.getAlosHashachar());
		if(y)
			timer.schedule(new MyTimeTask("Mi'sh'yakir now!", this.phoneNumber), this.calendar.getMisheyakir10Point2Degrees());
		if(su)
			timer.schedule(new MyTimeTask("sunrise now!", this.phoneNumber), this.calendar.getSunrise());
		if(shma1)
			timer.schedule(new MyTimeTask("sof Zman Shma now!", this.phoneNumber), this.calendar.getSofZmanShmaMGA16Point1Degrees());
		if(shma2)
			timer.schedule(new MyTimeTask("sof Zman Shma now!", this.phoneNumber), this.calendar.getSofZmanShmaGRA());
		if(tfila)
			timer.schedule(new MyTimeTask("sof Zman tfila now!", this.phoneNumber), this.calendar.getSofZmanTfilaGRA());
		if(p)
			timer.schedule(new MyTimeTask("plag hamincha now!", this.phoneNumber), this.calendar.getPlagHamincha());
		if(sun)
			timer.schedule(new MyTimeTask("sunset now!", this.phoneNumber), this.calendar.getSunset());    

	}
	
}