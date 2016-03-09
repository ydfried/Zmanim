

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;
public class EmailMessage {
	
	String alos, yakir, hanetz, shma1, shma2, tefila, chatzos, minchaG, plag, minchaK, shkia, tzeis1, tzeis2, tzeis3;
	
	String message;
		
		public EmailMessage(double lat, double longitude, TimeZone timeZone) {
			GeoLocation loc = new GeoLocation("Brooklyn, NY", lat, longitude, timeZone);
			ComplexZmanimCalendar cmp = new ComplexZmanimCalendar(loc);
		
			
			
			Long shZ = cmp.getShaahZmanis16Point1Degrees();
			
			yakir = convert(cmp.getMisheyakir10Point2Degrees());
			alos = convert(cmp.getAlosHashachar());
			hanetz = convert(cmp.getSeaLevelSunrise());
			shma1 = convert(cmp.getSofZmanShmaMGA16Point1Degrees());
			shma2 = convert(cmp.getSofZmanShmaGRA());
			tefila = convert(cmp.getSofZmanTfilaMGA16Point1Degrees());
			chatzos = convert(cmp.getChatzos());
			minchaG = convert(cmp.getMinchaGedola30Minutes());
			plag = convert(cmp.getPlagHamincha());
			minchaK = convert(cmp.getMinchaKetana());
			shkia = convert(cmp.getSunset());
			tzeis1 = convert(cmp.getTzais());
			tzeis2 = convert(cmp.getTzais72Zmanis());
			tzeis3 = convert(cmp.getTzais72());
			
			
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
	     +"<td>Ha'netz</td>"
	     +"<td>"+hanetz+"</td>"
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
		
		public String convert(Date zman) {

			String nString = new SimpleDateFormat("hh:mm:ss a").format(zman);
						
			return nString;
			
		}
		public String getMessage() {
			
			return message;
		}
	}



