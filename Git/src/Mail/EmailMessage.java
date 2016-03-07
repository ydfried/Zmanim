package Mail;

import java.util.Date;
import java.util.TimeZone;

//import Mail.SendReceiveMail;
import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;
public class EmailMessage {
	Date s;
	String am = "am";
	String pm = "pm";
	String[][] zmanim = new String[4][2];
	String z = "Zmanim:";
	ComplexZmanimCalendar cmp = new ComplexZmanimCalendar();
	GeoLocation testloc = new GeoLocation("Brooklyn, NY", 40.638997, -73.993597, TimeZone.getDefault());
	String message;
		
		public EmailMessage() {
			cmp.setGeoLocation(testloc);
			System.out.println(testloc.toString());
			s = cmp.getSunrise();
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
					z = z + " " + zmanim[i][0] + " " + zmanim[i][1];
					System.out.printf("%-10s %-30s\n", zmanim[i][0], zmanim[i][1]);
					System.out.println(z);
			}
			message = "<div id=\":ar\" class=\"Am Al editable LW-avf\" hidefocus=\"true\" aria-label=\"Message Body\" g_editable=\"true\" role=\"textbox\" contenteditable=\"true\" tabindex=\"1\" style=\"direction: ltr; min-height: 80px;\"><table border =\"0\" width=\"100%\">"
	   +"<caption>ZmanimProject</caption>"
	   +"<tr>"
	     +"<th>Zman</th>"
	     +"<th>Time</th>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Henetz</td>"
	     +"<td>"+zmanim[0][1]+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Alos</td>"
	     +"<td>"+zmanim[1][1]+"</td>"
	     +"</tr>"
	     +"<tr>"
	     +"<td>Shma</td>"
	     +"<td>"+zmanim[2][1]+"</td>"
	     +"</tr>"
	     +"<tr>"
	     +"<td>Tefilah</td>"
	     +"<td>"+zmanim[3][1]+"</td>"
	   +"</tr>"
	   +"</table></div>";
			
		}
		public EmailMessage(String t){
			cmp.setGeoLocation(testloc);
			System.out.println(testloc.toString());
			s = cmp.getSunrise();
		
		}
		public String convert(Date zman, String mn) {
			String nString = zman.toString().substring(11, 20) + mn;
			return nString;
		}
		public String getMessage() {
			
			return message;
		}
	}



