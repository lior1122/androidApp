package server;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Post {
	
	public HttpResponse postData(String url, List<BasicNameValuePair> params) {
	    // Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(url);
	    HttpResponse response = null;

	try {
	    // Add your data
	    httppost.setEntity(new UrlEncodedFormEntity(params));

	    // Execute HTTP Post Request
	     response = httpclient.execute(httppost);
	    

	} catch (ClientProtocolException e) {
	    // TODO Auto-generated catch block
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	}
		return response;
	}

}
