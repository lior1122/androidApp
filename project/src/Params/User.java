
package Params;

import Params.Conference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private static String age;
    private static List<Conference> conferences;
    private static String email;
    private static String fname;
    private static String gender;
    private static String headLine;
    private static String id;
    private static String lname;
    private static String userPic;

    public static String getAge() {
        return age;
    }

    public static String getEmail() {
        return email;
    }

    public static String getFname() {
        return fname;
    }

    public static String getGender() {
        return gender;
    }

    public static String getHeadLine() {
        return headLine;
    }

    public static String getId() {
        return id;
    }

    public static String getLname() {
        return lname;
    }

    public static String getUserPic() {
        return userPic;
    }

    public static void setUserParams(String string, String string2, String string3, String string4) {
        fname = string;
        lname = string2;
        headLine = string3;
        userPic = string4;
    }

    public static void setUserParams(JSONObject jSONObject) throws JSONException {
        fname = jSONObject.getString("first");
        lname = jSONObject.getString("last");
        id = jSONObject.getString("id");
        userPic = jSONObject.getString("pic");
        gender = jSONObject.getString("gender");
        age = jSONObject.getString("age");
        Conference.setUserConferences(jSONObject.getJSONArray("conferences"));
    }

    public List<Conference> getConferences() {
        return conferences;
    }
}

