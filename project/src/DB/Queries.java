package DB;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.webkit.JsPromptResult;



public class Queries {
	
	public static JSONArray GetAllUserConferences(String email){
		JSONObject con1 = new JSONObject();
		JSONObject con2 = new JSONObject();
	
		JSONArray array = new JSONArray();
		try {
				con1.put("id", 0);
				con1.put("name", "Test Conference 1");
				con1.put("pic", "https://www.globalreporting.org/SiteCollectionImages/Information%20Hub/Events/Canada%20conference%202012/canada-banner.PNG");
				con2.put("id", 1);
				con2.put("name", "Test Conference 2");
				con2.put("pic","https://phpconference.com/2014se/sites/default/files/ipc_spring_2014_logo.png");
				array.put(con1);
				array.put(con2);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	
}


