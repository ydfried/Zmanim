import java.util.Date;
import java.util.TimeZone;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;


public class Program {

	public static void main(String[] args) {
		String am = "am";
		String pm = "pm";
		String[][] zmanim = new String[4][2];
		ComplexZmanimCalendar cmp = new ComplexZmanimCalendar();
		GeoLocation testloc = new GeoLocation("Brooklyn, NY", 40.6690, -73.9429, TimeZone.getDefault().getDefault());
		cmp.setGeoLocation(testloc);
		System.out.println(testloc.toString());
		
		Long shZ = cmp.getShaahZmanis16Point1Degrees();
		zmanim[0][0] = "Henetz";
		zmanim[0][1] = convert(cmp.getSunrise(), am);
		zmanim[1][0] = "Alos";
		zmanim[1][1] = convert(cmp.getAlos16Point1Degrees(), am);
		zmanim[2][0] = "Shma";
		zmanim[2][1] = convert(cmp.getSofZmanShmaMGA16Point1Degrees(), am);
		zmanim[3][0] = "Tefilah";
		zmanim[3][1] = convert(cmp.getSofZmanTfilaMGA16Point1Degrees(), am);

		for (int i = 0; i <= 3; i++) {
				System.out.printf("%-10s %-30s\n", zmanim[i][0], zmanim[i][1]);
		}
	}
	public static String convert(Date zman, String mn) {
		String nString = zman.toString().substring(11, 20) + mn;
		return nString;
	}
}
