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
	
	 public HttpResponse postData(String string, List<BasicNameValuePair> list) {
	        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(string);
	        try {
	            httpPost.setEntity(new UrlEncodedFormEntity(list));
	            HttpResponse httpResponse = defaultHttpClient.execute(httpPost);
	            return httpResponse;
	        }
	        catch (IOException e) {
	            return null;
	        }

	    }

}
