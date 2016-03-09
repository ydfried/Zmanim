

import java.util.Date;
import java.util.TimeZone;


//import Mail.SendReceiveMail;
import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;
public class EmailMessage {
	Date s;
	String am = "am";
	String pm = "pm";
	String z = "Zmanim:";
	String alos, yakir, hanetz, shma1, shma2, tefila, chatzos, minchaG, plag, minchaK, shkia, tzeis1, tzeis2, tzeis3;
	
	String message;
		
		public EmailMessage(double lat, double longitude, TimeZone timeZone) {
			ComplexZmanimCalendar cmp = new ComplexZmanimCalendar();
			GeoLocation testloc = new GeoLocation("Brooklyn, NY", lat, longitude, timeZone);
			cmp.setGeoLocation(testloc);
			System.out.println(testloc.toString());
			
			Long shZ = cmp.getShaahZmanis16Point1Degrees();
			hanetz = convert(cmp.getSunrise(), am);
			yakir = convert(cmp.getMisheyakir11Degrees(), am);
			alos = convert(cmp.getAlos16Point1Degrees(), am);
			shma1 = convert(cmp.getSofZmanShmaMGA16Point1Degrees(), am);
			shma2 = convert(cmp.getSofZmanShmaGRA(), am);
			tefila = convert(cmp.getSofZmanTfilaMGA16Point1Degrees(), am);
			chatzos = covert(cmp.getChatzos());
			minchaG = convert(cmp.getMinchaGedola16Point1Degrees(), pm);
			plag = convert(cmp.getPlagHamincha16Point1Degrees(), pm);
			minchaK = convert(cmp.getMinchaKetana16Point1Degrees(), pm);
			shkia = convert(cmp.getSofZmanTfilaMGA16Point1Degrees(), pm);
			tzeis1 = convert(cmp.getTzais(), pm);
			tzeis2 = convert(cmp.getTzais16Point1Degrees(), pm);
			tzeis3 = convert(cmp.getTzais72(), pm);
			
			
			message = "<div id=\":ar\" class=\"Am Al editable LW-avf\" hidefocus=\"true\" aria-label=\"Message Body\" g_editable=\"true\" role=\"textbox\" contenteditable=\"true\" tabindex=\"1\" style=\"direction: ltr; min-height: 80px;\"><table border =\"0\" width=\"100%\">"
	   +"<caption>ZmanimProject</caption>"
	   +"<tr>"
	     +"<th>Zman</th>"
	     +"<th>Time</th>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Alos</td>"
	     +"<td>"+alos+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Mi'Sh'Yakir</td>"
	     +"<td>"+yakir+"</td>"
	     +"</tr>"
	     +"<tr>"
	     +"<td>Sof Zman Krias Shma MG\"A</td>"
	     +"<td>"+shma1+"</td>"
	     +"</tr>"
	     +"<tr>"
	     +"<td>Sof Zman Krias Shma GRA</td>"
	     +"<td>"+shma2+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Sof Zman Tefila</td>"
	     +"<td>"+tefila+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Chatzos</td>"
	     +"<td>"+chatzos+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Mincha Gedola</td>"
	     +"<td>"+minchaG+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Plag Hamincha</td>"
	     +"<td>"+plag+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Mincha K'tana</td>"
	     +"<td>"+minchaK+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Sh'kia</td>"
	     +"<td>"+shkia+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Tzeis 1</td>"
	     +"<td>"+tzeis1+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Tzeis 2</td>"
	     +"<td>"+tzeis2+"</td>"
	   +"</tr>"
	   +"<tr>"
	     +"<td>Tzeis R\"T</td>"
	     +"<td>"+tzeis3+"</td>"
	   +"</tr>"
	   +"</table></div>";
			
		}
		
		private String covert(Date zman) {
			String nString = zman.toString().substring(11, 20);
			if (nString.startsWith("11")) {
				nString += "am";
			}
			else
				nString += "pm";
			return nString;
		}

		public String convert(Date zman, String mn) {
			String nString = zman.toString().substring(11, 20) + mn;
			return nString;
		}
		public String getMessage() {
			
			return message;
		}
	}



