package DB;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Queries {
	
	private static ArrayList<User> users; 
	private static ArrayList<Conference> conferences;

	
	Queries()
	{
		users.add(new User(0,"test","test","test@test.com","http://www.american.edu/uploads/profiles/large/chris_palmer_profile_11.jpg"));
		conferences.add(new Conference(0,1, "Test Conference"));
		
		
	}
	
	public static JSONArray GetUserConferences(String email)
	{
		JSONArray array = new JSONArray();
		JSONObject obj;
		User usr = null;
		for (int i=0;i<users.size();i++){
			if (users.get(i).getEmail().equals(email)){
				usr = users.get(i);
				break;
			}
		}
		
		for (int i=0;i<conferences.size();i++){
			if (conferences.get(i).getUserID() == usr.getId()){
				obj = new JSONObject();
				try {
					obj.accumulate(String.valueOf(conferences.get(i).getId())  , conferences.get(i).getName());
					array.put(obj);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return array;
	}

}


