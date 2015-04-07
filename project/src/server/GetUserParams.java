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
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import pages.Login;
import conferenceSelect.UserConferenceListView;
import Params.Conference;
import Params.User;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class GetUserParams extends AsyncTask<String, Void, String> {

	private static String URL = "http://ec2-54-191-3-32.us-west-2.compute.amazonaws.com:8080/ws/excon/login/mobile/";
	private List<BasicNameValuePair> params;
	private Context context;
	
	@Override
	protected String doInBackground(String...email) {
		params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("email", email[0]));
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
			JSONObject finalResult = new JSONObject(tokener);
			Log.d("response", finalResult.toString());
			User.setUserParams(finalResult);
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
	protected void onPreExecute() {

	}


	
	public GetUserParams(Context ctx)
	{
		context = ctx;

	}



}
