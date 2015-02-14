package DB;

public class User_Conference {
	private int userID;
	private int conferenceID;
	
	public User_Conference(int uid,int cid) {
		userID = uid;
		conferenceID = cid;
	}

	public int getUserID() {
		return userID;
	}

	public int getConferenceID() {
		return conferenceID;
	}

}
