package compliment_sender;
import com.fasterxml.jackson.core.JsonParser;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import org.json.*;


public class sender {
	public static final String ACCOUNT_SID = "UNKNOWN";
	  public static final String AUTH_TOKEN = "UNKNOWN";
	  
	  public static String sendGetRequest()
	  {
		  try 
		  {
			  URL url = new URL("https://complimentr.com/api");
			  String json = "{"+"\"compliment\": \" \""+"}";
			  HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
			  httpURLConnection.setRequestMethod("GET");
			  String line = "";
			  InputStreamReader inputs = new InputStreamReader(httpURLConnection.getInputStream());
			  BufferedReader buff = new BufferedReader(inputs);
			  StringBuilder response = new StringBuilder(); 
			  while((line=buff.readLine())!=null)
			  {
				  response.append(line);
			  }
			  buff.close();
			return response.toString();
		  }
		  
		  catch (Exception e)
		  {
			  return "Error";
		  }
	  }

	  public static void main(String[] args) {	  
		
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+ANUNKNOWNPHONENUMBER"), // to
                        new PhoneNumber("+ANUNKNOWNPHONENUMBER"), // from
                        sendGetRequest())
                .create();

        System.out.println(message.getSid());
	  }

}
