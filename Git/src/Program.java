import java.util.TimeZone;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;


public class Program {

	public static void main(String[] args) {
		ComplexZmanimCalendar cmp = new ComplexZmanimCalendar();
		GeoLocation testloc = new GeoLocation("Brooklyn, NY", 40.6690, -73.9429, TimeZone.getDefault().getDefault());
		cmp.setGeoLocation(testloc);
		System.out.println(testloc.toString());
		
		
		System.out.println(cmp.getSofZmanShmaMGA16Point1Degrees()); //dddcfds

	}

}
