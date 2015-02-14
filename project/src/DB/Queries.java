package DB;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Queries {
	
	public static JSONObject GetAllUserConferences(String email){
		JSONObject conferences = new JSONObject();
		try {
			conferences.put("0", "Test Conference Title1");
			conferences.put("1", "Test Conference Title2");
			conferences.put("2", "Test Conference Title3");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conferences;
	}
	
	
}


