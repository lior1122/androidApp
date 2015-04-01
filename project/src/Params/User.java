package Params;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class User {
	private static String fname;
	private static String lname;
	private static String headLine;
	private static String userPic;
	private static String id;
	private static String email;
	private static String gender;
	private static String age;
	
	


	public static String getFname() {
		return fname;
	}

	public static String getLname() {
		return lname;
	}

	public static String getHeadLine() {
		return headLine;
	}

	public static String getUserPic() {
		return userPic;
	}

	public static String getId() {
		return id;
	}

	public static String getEmail() {
		return email;
	}

	public static String getGender() {
		return gender;
	}

	public static String getAge() {
		return age;
	}

	public static void setUserParams(JSONObject uParams) throws JSONException {
		
		fname = uParams.getString("first");
		lname = uParams.getString("last");
		id = uParams.getString("id");
		userPic = uParams.getString("picLink");
		gender = uParams.getString("gender");
		age = uParams.getString("age");
		}
	
	public static void setUserParams(String fname, String lname,String headline,String userPic)
	{
		User.fname = fname;
		User.lname = lname;
		User.headLine = headline;
		User.userPic = userPic;
		
	}
	

}
