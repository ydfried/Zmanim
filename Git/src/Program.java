import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;




public class Program {

	public static void main(String[] args) {

		DB myDb;
		
		try {
			myDb = new DB();
			while(myDb.rs.next()){
				float lat = myDb.rs.getFloat("lat");
				float lon = myDb.rs.getFloat("longt");
				String timeZone = TimeZoneMapper.latLngToTimezoneString(lat, lon);
				new UsersReminder(myDb.rs.getString("phone"), "", lat, lon, 
						TimeZone.getTimeZone(timeZone), 
						myDb.rs.getBoolean("alos"), myDb.rs.getBoolean("sunrise"), 
						myDb.rs.getBoolean("shma"), myDb.rs.getBoolean("tfila"), 
						myDb.rs.getBoolean("plag"), myDb.rs.getBoolean("sunset"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*try {
			SMS.test("9175620150", "this is a Test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
//		System.out.println(cmp.getSofZmanShmaMGA16Point1Degrees()); //dddcfds

		//String timeZone = TimeZoneMapper.latLngToTimezoneString(40.6639, -73.9399);
		
		//UsersReminder LeviPerelmuter = new UsersReminder("Brooklyn, NY", 40.6639, -73.9399,TimeZone.getTimeZone(timeZone),true, true, true, true, true, true);
		
		
		
		
	}

}
