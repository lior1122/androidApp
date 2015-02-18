package Params;

import org.json.JSONArray;

public class Params {
	
	private static JSONArray usersConferences;

	public static JSONArray getUsersConferences() {
		return usersConferences;
	}

	public static void setUsersConferences(JSONArray usersConferences) {
		Params.usersConferences = usersConferences;
	}
	
	


}
