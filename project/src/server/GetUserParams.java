
package server;

import Params.User;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import conferenceSelect.UserConferenceListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import pages.Login;
import server.API;

public class GetUserParams
extends AsyncTask<String, Void, String> {
    private String URL = String.valueOf(API.getURL()) + "login/mobile/";
    private Login context;
    private List<BasicNameValuePair> params;

    public GetUserParams(Context context) {
        this.context = (Login)context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     */
    protected String doInBackground(String ... arrstring) {
        params = new ArrayList();
        String string = arrstring[0];
        params.add(new BasicNameValuePair("email", string));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(this.URL);
        try {
            httpPost.setEntity((HttpEntity)new UrlEncodedFormEntity(this.params));
            HttpResponse httpResponse = defaultHttpClient.execute((HttpUriRequest)httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 204) {
                throw new NullPointerException();
            }
            Log.d((String)"stutus", (String)String.valueOf((int)httpResponse.getStatusLine().getStatusCode()));
            User.setUserParams(new JSONObject(new JSONTokener(new BufferedReader((Reader)new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8")).readLine())));
            return null;
        }
        catch (UnsupportedEncodingException var10_6) {
            var10_6.printStackTrace();
            return null;
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            context.StopDialogWithError("Network Error!");
            e.printStackTrace();
            return null;
        }
        catch (JSONException var7_9) {
            var7_9.printStackTrace();
            return null;
        }
        catch (NullPointerException var6_10) {
            return null;
        }
    }

    protected void onPostExecute(String string) {
        Login login = this.context;
        login.StopDialog();
        if (User.getId() == null) {
            login.StopDialogWithError("Login Failed! Please try again.");
            return;
        }
        Intent intent = new Intent(context, UserConferenceListView.class);
        this.context.startActivity(intent);
        login.finish();
    }

    protected void onPreExecute() {
    }
}

