
import java.io.*;
	import java.net.*;
	import java.util.*;
	import java.text.*;

import javax.lang.model.element.Element;

import org.jdom2.input.SAXBuilder;
     
    public class SMS {
     
        public static void text(String phonenumber, String message) throws Exception {
     
            String data = "User=perelmuter&Password=**********&PhoneNumbers[]="+phonenumber+"&PhoneNumbers[]="+phonenumber+"&Subject=From Levi&Message="+message+"&StampToSend=1305582245&MessageTypeID=1";
     
            URL url = new URL("https://app.eztexting.com/sending/messages?format=xml");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
     
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
     
    	int responseCode = conn.getResponseCode();
            System.out.println("Response code: " + responseCode);
     
            boolean isSuccesResponse = responseCode < 400;
     
            InputStream responseStream = isSuccesResponse ? conn.getInputStream() : conn.getErrorStream();
     
            //Use JDOM (http://www.jdom.org) for xml response handling
    	org.jdom2.Element response = new SAXBuilder().build(responseStream).getRootElement(); 
    	System.out.println("Status: " + response.getChildText("Status"));
            System.out.println("Code: " + response.getChildText("Code"));
            if (isSuccesResponse) {
                org.jdom2.Element entry = response.getChild("Entry");
                System.out.println("Message ID: " + entry.getChildText("ID"));
                System.out.println("Subject: " + entry.getChildText("Subject"));
                System.out.println("Message: " + entry.getChildText("Message"));
                System.out.println("Message Type ID: " + entry.getChildText("MessageTypeID"));
                System.out.println("Total Recipients: " + entry.getChildText("RecipientsCount"));
                System.out.println("Credits Charged: " + entry.getChildText("Credits"));
                System.out.println("Time To Send: " + entry.getChildText("StampToSend"));
                System.out.println("Phone Numbers: " + implodeXML(entry.getChild("PhoneNumbers"), ", "));
                System.out.println("Locally Opted Out Numbers: " + implodeXML(entry.getChild("LocalOptOuts"), ", "));
                System.out.println("Globally Opted Out Numbers: " + implodeXML(entry.getChild("GlobalOptOuts"), ", "));
            } else {
                System.out.println("Errors: " + implodeXML(response.getChild("Errors"), "\n"));
            }
     
            responseStream.close(); 
            wr.close();
        }
     
        public static String implodeXML(org.jdom2.Element element, String delim) {
    	if (element == null) return "";
    	List objs = element.getChildren();
            StringBuffer buf = new StringBuffer();
            int size = objs.size();
     
            for (int i=0; i<size - 1; i++) {
                buf.append(((org.jdom2.Element)(objs.get(i))).getText() + delim);
            }
     
            if (size != 0) {
                buf.append(((org.jdom2.Element)(objs.get(size - 1))).getText());
            }
     
            return buf.toString();
        }
     
    }