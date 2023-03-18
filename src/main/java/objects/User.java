package objects;

public class User {

	private String user;
	private String user_id;
	private String password;
	
	public User(String user_id,String user) {
		this.user_id = user_id;
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	
	
	 
}
