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
	
	public GeoLocation location;
	public boolean alos;
	public boolean sunrise;
	public boolean sofZmanShma;
	public boolean sofZmanTfila;
	public boolean plag;
	public boolean sunset;	
	
	public ComplexZmanimCalendar calendar;
	
	Date alosTime;
	Date sunriseTime;
	Date sofZmanShmaTime;
	Date sofZmanTfilaTime;
	Date plagTime;
	Date sunsetTime;


	public UsersReminder (String location, double lat, double lon, TimeZone timezone, boolean a, boolean su, boolean shma, boolean tfila, boolean p, boolean sun){
		GeoLocation loc = new GeoLocation(location, lat, lon, timezone);
		calendar = new ComplexZmanimCalendar(loc);
		
		alos = a;
		sunrise = su;
		sofZmanShma = shma;
		sofZmanTfila = tfila;
		plag = p;
		sunset = sun;
		
		alosTime = this.calendar.getAlosHashachar();
		sunriseTime = this.calendar.getSunrise();
		sofZmanShmaTime = this.calendar.getSofZmanShmaGRA();
		sofZmanTfilaTime = this.calendar.getSofZmanTfilaGRA();
		plagTime = this.calendar.getPlagHamincha();
		sunsetTime = this.calendar.getSunset();
		
	}
	

	private static class MyTimeTask extends TimerTask
	{

	    public void run()
	    {
	        System.out.println("its time!");
	    }
	}
	
	public void timers(){
	Timer timer = new Timer();

    timer.schedule(new MyTimeTask(), this.alosTime);
    timer.schedule(new MyTimeTask(), this.sunriseTime);
    timer.schedule(new MyTimeTask(), this.sofZmanShmaTime);
    timer.schedule(new MyTimeTask(), this.sofZmanTfilaTime);
    timer.schedule(new MyTimeTask(), this.plagTime);
    timer.schedule(new MyTimeTask(), this.sunsetTime);
    timer.schedule(new MyTimeTask(), alosTime);
    

	}
	
}