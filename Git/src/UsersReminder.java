import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;

// each UsersReminder Object will store the users location and desired reminders as booleans 
// for now we are only offering a few options

public class UsersReminder {
	
	public GeoLocation location;
	public boolean alos;
	public boolean sunrise;
	public boolean sofZmanShma;
	public boolean sofZmanTfila;
	public boolean plag;
	public boolean sunset;	
	
	public ComplexZmanimCalendar calendar;
	
	//ArrayList<Date> times = new ArrayList<Date>();
	Map<String,Date> times;


	public UsersReminder (String location, double lat, double lon, TimeZone timezone, boolean a, boolean su, boolean shma, boolean tfila, boolean p, boolean sun){
		GeoLocation loc = new GeoLocation(location, lat, lon, timezone);
		calendar = new ComplexZmanimCalendar(loc);
		
		alos = a;
		sunrise = su;
		sofZmanShma = shma;
		sofZmanTfila = tfila;
		plag = p;
		sunset = sun;
		
	}
	
	public void getTimes(){
		if (alos)
			times.put("alos",(this.calendar.getAlosHashachar()));
		if (sunrise)
			times.put("sunrise",(this.calendar.getSunrise()));
		if (sofZmanShma)
			times.put("Sof ZMan Krias Shma",(this.calendar.getSofZmanShmaGRA()));
		if (sofZmanTfila)
			times.put("Sof ZMan Tfila",(this.calendar.getSofZmanTfilaGRA()));
		if (plag)
			times.put("Plag Hamincha",(this.calendar.getPlagHamincha()));
		if (sunset)
			times.put("sunset",(this.calendar.getSunset()));
	}

}