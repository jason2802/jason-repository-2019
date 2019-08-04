package prjTestJsonTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Start {

	 public static void main(String[] args) throws JSONException	  {
	       
	    System.out.println("--------------- " );
	    String json0 = "{'ipinfo': {'ip_address': '131.208.128.15','ip_type': 'Mapped','Location': {'continent': 'north america','latitude': 30.1,'longitude': -81.714,'CountryData': {'country': 'united states','country_code': 'us'},'region': 'southeast','StateData': {'state': 'florida','state_code': 'fl'},'CityData': {'city': 'fleming island','postal_code': '32003','time_zone': -5}}}}";
	    
	    String json = "{\r\n" + 
	    		"   \"ipinfo\":{\r\n" + 
	    		"				\"000\": {\r\n" + 
	    		"					\"component\": \"c\",\r\n" + 
	    		"					\"determinantType\": \"dt\",\r\n" + 
	    		"					\"determinant\": \"d\",\r\n" + 
	    		"					\"header\": \"h\",\r\n" + 
	    		"					\"determinantvalue\": \"null\"\r\n" + 
	    		"				},\r\n" + 
	    		"				\"001\": {\r\n" + 
	    		"					\"component\": \"t\",\r\n" + 
	    		"					\"determinantType\": \"i\",\r\n" + 
	    		"					\"determinant\":\"ld\",\r\n" + 
	    		"					\"header\": \"D\",\r\n" + 
	    		"					\"determinantvalue\": \"null\"\r\n" + 
	    		"				},\r\n" + 
	    		"				\"002\": {\r\n" + 
	    		"					\"component\": \"x\",\r\n" + 
	    		"					\"determinantType\": \"id\",\r\n" + 
	    		"					\"determinant\": \"pld\",\r\n" + 
	    		"					\"header\": \"P\",\r\n" + 
	    		"					\"determinantValue\": \"null\"\r\n" + 
	    		"				}\r\n" + 
	    		"			}\r\n" + 
	    		"}";
	    
	    JSONObject object = new JSONObject(json);

	    JSONObject info = object.getJSONObject("ipinfo");

	    Map<String,String> out = new HashMap<String, String>();

	    ParserJson.parse(info,out);

	    String latitude = out.get("latitude");
	    String longitude = out.get("longitude");
	    String city = out.get("city");
	    String state = out.get("state");
	    String country = out.get("country");
	    String postal = out.get("postal_code");

	    System.out.println("Latitude : " + latitude + " LongiTude : " + longitude + " City : "+city + " State : "+ state + " Country : "+country+" postal "+postal);

	    System.out.println("ALL VALUE " + out);
	    
	    String message= "B306_RS100\r\n" + 
	    		"00010351200000ALIMENTI                 LETIZIA             1ITAITLLMNLTZ84P60C933WF19840920COMO                     COITA                                        VIA LARIO 70                                                                    22030    LIPOMO                             COITAVKC4024-2500-3023-8013    AA AA LETIZIA ALIMENTI                                    20130131EMP310-961-227*0          AA AA 00000000030000000000000024140-00000000052018\r\n" + 
	    		"B306_RS 00\r\n" + 
	    		"00082018051420180512               013        97800000000002000+97800000000002000+010354024250030238013       4024250030238013       TRIANON PALACE           78VERSAILLES FR74975876184201238950308TRIANON PALACE           78VERSAILLES      FR 78000                   BP006C413831B000131870700001N 000000000000000000000000000000000000000000000000000000000000000000201804242018051200010001   0000000000000000   000000000000000   000000000000   0000000000000   0                                         05120171110  57980152300013 5  000000000            0000                                                                                      00000000                                                      00010002\r\n" + 
	    		"B306_RS 00\r\n" + 
	    		"00082018051520180513               013        97800000000000030+97800000000000030+010354024250030238013       4024250030238013       NEXI PAYMENTS SPS        MILANO       IT74935008269826921637031NEXI PAYMENTS SPS        MILANO            ITA20149                           5499B626260302703707Y5000000000000000000000000000000000000000000000000000000000000000000201804242018051300010001   0000000000000000   000000000000000   000000000000   0000000000000   0                                         05120180927 13027037           000000000            0000                                                                                      00000000                                                      00020003\r\n" + 
	    		"B306_RS 00\r\n" + 
	    		"00082018051620180513               013        97800000000000030+97800000000000030+010354024250030238013       4024250030238013       NEXI PAYMENTS SPS        MILANO       IT74935008269826921637031NEXI PAYMENTS SPS        MILANO            ITA20149                           5499B626260302703707Y5000000000000000000000000000000000000000000000000000000000000000000201804242018051300020001   0000000000000000   000000000000000   000000000000   0000000000000   0                                         05120180927 13027037           000000000            0000                                                                                      00000000                                                      00030004";
	    
	    String[] arrMessage = message.split("B306_RS");
	    for (int i = 0; i < arrMessage.length; i++) {
	    	if ( i > 1 ) {
				// System.out.println(" \n\n i = " + i + " \n " + arrMessage[i]);
				Integer j = arrMessage[i].indexOf("\n");
				String message2 = "";
				if ( j > 0 ) { 
					message2 = arrMessage[i].split("\n")[1];
				}
				System.out.println(" \n numero i = " +  i + " --> j = " + j +  " --> message2 = " + message2 );
	    	}
		}
	    
	  }
	 
}
