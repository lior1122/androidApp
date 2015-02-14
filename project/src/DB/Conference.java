package DB;

public class Conference {
	
	private int id;
	private String name;
	private int userID;
	
	public Conference(int id,int uid, String name) {
		this.id = id;
		this.userID = uid;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getUserID(){
		return userID;
	}
	

}
