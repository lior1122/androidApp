package Params;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Conference {
	private static JSONArray userConferences;
	private static JSONObject selectedConference;

	private static String id;
	private static String name;
	private static String address;
	private static String mapUrl;
	private static String generalDetails;
	
	public static JSONObject getSelectedConference() {
		return selectedConference;
	}

	public static void setSelectedConference(JSONObject selectedConference) {
		Conference.selectedConference = selectedConference;
	}


	public static void setUserConferences(JSONArray userConferences) {
		Conference.userConferences = userConferences;
	}
	
	public static JSONArray getUserConferences() {
		return userConferences;
	}

	public static void SetConference(JSONObject conference) {
		try {
			Conference.mapUrl = conference.get("map_url").toString();
			Conference.name = conference.get("name").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static String getId() {
		return id;
	}

	public static String getName() {
		return name;
	}

	public static String getAddress() {
		return address;
	}

	public static String getMapUrl() {
		return mapUrl;
	}

	public static String getGeneralDetails() {
		return generalDetails;
	}
	
	

}
