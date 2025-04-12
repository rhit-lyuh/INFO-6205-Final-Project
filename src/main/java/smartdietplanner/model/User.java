package smartdietplanner.model;

import java.util.UUID;


public class User {

	//Data Field
	private String userID;
	private String userName;
	private String password;
//	private String firstName = "Not Provided.";  //default value
//	private String lastName = "Not Provided.";  //default value
//	private String email;
	
	//Cons
	public User(String userName, String password) {
		this.userID = UUID.randomUUID().toString();
		this.userName = userName;
		this.password = password;

	}
	
	//Getter & Setter
	//UUID
	public String getUserId() {
		return userID;
	}
	//
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
