import java.util.TimeZone;


public class GetReminders {

	
	public static void getReminders(DB myDb){
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
		
		e.printStackTrace();
	}
	
	}
}
