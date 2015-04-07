package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;







import pages.Login;
import conferenceSelect.UserConferenceListView;
import Params.Conference;
import Params.User;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class GetUserConferences extends AsyncTask<Void, Void, Void> {

	private static String URL = "http://ec2-54-191-3-32.us-west-2.compute.amazonaws.com:8080/ws/excon/conferences/user_conferences/";
	private List<BasicNameValuePair> params;
	private Context context;

	@Override
	protected Void doInBackground(Void... param) {
		params = new ArrayList<BasicNameValuePair>();
		while(User.getId() == null){}
		params.add(new BasicNameValuePair("uid", User.getId()));
		BufferedReader reader;
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(URL);
	    HttpResponse response = null;

	    try {
			httppost.setEntity(new UrlEncodedFormEntity(params));
			response = httpclient.execute(httppost);
	    	reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			String json = reader.readLine();
			
			JSONTokener tokener = new JSONTokener(json);
			JSONObject conferences = new JSONObject(tokener);
			JSONArray finalResult = conferences.getJSONArray("conference");

			Params.Conference.setUserConferences(finalResult);
			
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
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


	
	@Override
	protected void onPostExecute(Void result) {
		Login login = (Login)context;
		login.stopDialog();
	   	Intent intent = new Intent(context, UserConferenceListView.class);
	   	context.startActivity(intent);
	}



	@Override
	protected void onPreExecute() {

	}



	
	public GetUserConferences(Context ctx)
	{
		context = ctx;
	}



}
