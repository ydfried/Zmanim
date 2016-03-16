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

		Date alos = this.calendar.getAlosHashachar();
		Date yakir = this.calendar.getMisheyakir10Point2Degrees();
		Date hanetz = this.calendar.getSunrise();
		Date shmaMGA = this.calendar.getSofZmanShmaMGA16Point1Degrees();
		Date shmaGRA = this.calendar.getSofZmanShmaGRA();
		Date tefila = this.calendar.getSofZmanTfilaGRA();
		Date plag = this.calendar.getPlagHamincha();
		Date shkia = this.calendar.getSunset();

		

		if(a && new Date().before(dateMinus(alos)))
			timer.schedule(new MyTimeTask("Alos now! " + EmailMessage.convert(alos), this.phoneNumber), dateMinus(alos));
		if(y && new Date().before(dateMinus(yakir)))
			timer.schedule(new MyTimeTask("Mi'sh'yakir now! " + EmailMessage.convert(yakir), this.phoneNumber), dateMinus(yakir));
		if(su && new Date().before(dateMinus(hanetz)))
			timer.schedule(new MyTimeTask("sunrise now! " + EmailMessage.convert(hanetz), this.phoneNumber), dateMinus(hanetz));
		if(shma1 && new Date().before(dateMinus(shmaMGA)))
			timer.schedule(new MyTimeTask("sof Zman Shma now! "  + EmailMessage.convert(shmaMGA), this.phoneNumber), dateMinus(shmaMGA));
		if(shma2 && new Date().before(dateMinus(shmaGRA)))
			timer.schedule(new MyTimeTask("sof Zman Shma now! " + EmailMessage.convert(shmaGRA), this.phoneNumber), dateMinus(shmaGRA));
		if(tfila && new Date().before(dateMinus(tefila)))
			timer.schedule(new MyTimeTask("sof Zman tfila now! " + EmailMessage.convert(tefila), this.phoneNumber), dateMinus(tefila));
		if(p && new Date().before(dateMinus(plag)))
			timer.schedule(new MyTimeTask("plag hamincha now! " + EmailMessage.convert(plag), this.phoneNumber), dateMinus(plag));
		if(sun && new Date().before(dateMinus(shkia)))
			timer.schedule(new MyTimeTask("sunset now! " + EmailMessage.convert(shkia), this.phoneNumber), dateMinus(shkia));    

	}
	public static Date dateMinus(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.MINUTE, -5);
		  Date d = cal.getTime();
		  return d;
		}
	
}