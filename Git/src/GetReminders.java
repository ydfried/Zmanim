import java.util.TimeZone;


public class GetReminders {

	
	public static void getReminders(DB myDb){
		try {
		myDb = new DB();
		while(myDb.rs.next()){
			
			float lat = myDb.rs.getFloat("lat");
			float lon = myDb.rs.getFloat("longt");
			
			String timeZone = TimeZoneMapper.latLngToTimezoneString(lat, lon);
			
			EmailMessage message = new EmailMessage(lat, lon, TimeZone.getTimeZone(timeZone));
			new SendReceiveMail(myDb.rs.getString("email"), "Zmanim", message.getMessage());
			new UsersReminder(myDb.rs.getString("phone"), "", lat, lon, 
					TimeZone.getTimeZone(timeZone), 
					myDb.rs.getBoolean("alos"), myDb.rs.getBoolean("yakir"), myDb.rs.getBoolean("sunrise"), 
					myDb.rs.getBoolean("shma1"), myDb.rs.getBoolean("shma2"), myDb.rs.getBoolean("tfila"), 
					myDb.rs.getBoolean("plag"), myDb.rs.getBoolean("sunset"));
			
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}
}
