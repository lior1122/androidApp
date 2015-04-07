package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;
import android.webkit.WebView.FindListener;

public class API {
	
	private static String URL = "http://ec2-54-191-3-32.us-west-2.compute.amazonaws.com:8080/server/";
	//private static String URL = "http://10.100.102.7:8080/ExconWS/excon/";
	
	public static JSONObject GetUserParams(String email)
	{
		//GetUserParams g  = new GetUserParams();
		//return g.doInBackground(email);
		return null;
	}
	
	
	public static JSONArray GetUserConferences(String id)
	{
	
		
		return null;
	}
	
	
	public static JSONObject GetConferenceInfo(String id)
	{
		Post post  = new Post();
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("id", id));
		HttpResponse res = post.postData(URL+"ConferenceInfo", params);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(res.getEntity().getContent(), "UTF-8"));
			String json = reader.readLine();
			JSONTokener tokener = new JSONTokener(json);
			JSONObject finalResult = new JSONObject(tokener);
			Log.d("response", finalResult.toString());
			return finalResult;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
		
		
		
	}
	
	

}
