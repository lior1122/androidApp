
package server;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import server.Post;

public class API {
    private static String URL = "http://52.11.114.161:8080/ws/excon/";

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject GetConferenceInfo(String string) {
        Post post = new Post();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new BasicNameValuePair("id", string));
        HttpResponse httpResponse = post.postData(String.valueOf((Object)URL) + "ConferenceInfo", (List<BasicNameValuePair>)arrayList);
        try {
            JSONObject jSONObject = new JSONObject(new JSONTokener(new BufferedReader((Reader)new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8")).readLine()));
            Log.d((String)"response", (String)jSONObject.toString());
            return jSONObject;
        }
        catch (UnsupportedEncodingException var9_5) {
            var9_5.printStackTrace();
            do {
                return null;
            } while (true);
        }
        catch (IllegalStateException var8_6) {
            var8_6.printStackTrace();
            return null;
        }
        catch (IOException var7_7) {
            var7_7.printStackTrace();
            return null;
        }
        catch (JSONException var6_8) {
            var6_8.printStackTrace();
            return null;
        }
    }

    public static JSONArray GetUserConferences(String string) {
        return null;
    }

    public static JSONObject GetUserParams(String string) {
        return null;
    }

    public static String getURL() {
        return URL;
    }
}

