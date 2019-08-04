package prjTestJsonTest;

import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class ParserJson {

	public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
		 System.out.println("\n json = " + json.toString());
	    Iterator<String> keys = json.keys();
	    while(keys.hasNext()){
	        String key = keys.next();
	        System.out.println("\n key = " + key);
	        String val = null;
	        try{
	             JSONObject value = json.getJSONObject(key);
	             parse(value,out);
	        }catch(Exception e){
	            val = json.getString(key);
	        }

	        if(val != null){
	            out.put(key,val);
	        }
	    }
	    return out;
	}	
	
}
