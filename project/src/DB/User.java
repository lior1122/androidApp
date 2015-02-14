package DB;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String pic;

	
	User(int id,String fn,String ln,String email, String picLink){
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.email = email;
		this.pic = picLink;
		
	}


	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getPic() {
		return pic;
	}

}
