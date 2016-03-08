import java.util.ArrayList;
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
	


	public UsersReminder (String phoneNumber, String location, double lat, double lon, TimeZone timezone, boolean a, boolean su, boolean shma, boolean tfila, boolean p, boolean sun){
		this.phoneNumber = phoneNumber;
		this.location = new GeoLocation(location, lat, lon, timezone);
		this.calendar = new ComplexZmanimCalendar(this.location);	
		
		if(a)
			timer.schedule(new MyTimeTask("Alos now!", this.phoneNumber), this.calendar.getAlosHashachar());
		if(su)
			timer.schedule(new MyTimeTask("sunrise now!", this.phoneNumber), this.calendar.getSunrise());
		if(shma)
			timer.schedule(new MyTimeTask("sof Zman Sham now!", this.phoneNumber), this.calendar.getSofZmanShmaGRA());
		if(tfila)
			timer.schedule(new MyTimeTask("sof Zman tfila now!", this.phoneNumber), this.calendar.getSofZmanTfilaGRA());
		if(p)
			timer.schedule(new MyTimeTask("plag hamincha now!", this.phoneNumber), this.calendar.getPlagHamincha());
		if(sun)
			timer.schedule(new MyTimeTask("sunset now!", this.phoneNumber), this.calendar.getSunset());    

	}
	
}