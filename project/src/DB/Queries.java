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
		JSONObject con3 = new JSONObject();
	
		JSONArray array = new JSONArray();
		try {
				con1.put("id", 0);
				con1.put("name", "Test Conference 1");
				con1.put("pic", "https://www.globalreporting.org/SiteCollectionImages/Information%20Hub/Events/Canada%20conference%202012/canada-banner.PNG");
				con2.put("id", 1);
				con2.put("name", "Test Conference 2");
				con2.put("pic","http://2013.metcconference.org/pluginfile.php/2/course/section/1/ISTE%202013%20Conference.png");
				con3.put("id",2);
				con3.put("name", "Test Conference 2");
				con3.put("pic","http://www.williampennfoundation.org/ArticleFiles/317/NALAC%20conference.png");
				array.put(con1);
				array.put(con2);
				array.put(con3);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	
}


