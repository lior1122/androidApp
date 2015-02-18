package Params;

public class UserParams {
	private static String fname;
	private static String lname;
	private static String headLine;
	private static String userPic;
	
	public static String getFname() {
		return fname;
	}

	public static void setFname(String fname) {
		UserParams.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public static void setLname(String lname) {
		UserParams.lname = lname;
	}

	public static String getHeadLine() {
		return headLine;
	}

	public static void setHeadLine(String headLine) {
		UserParams.headLine = headLine;
	}

	public static String getUserPic() {
		return userPic;
	}

	public static void setUserPic(String userPic) {
		UserParams.userPic = userPic;
	}

	public  UserParams() {
		// TODO Auto-generated constructor stub
	}
	

}
