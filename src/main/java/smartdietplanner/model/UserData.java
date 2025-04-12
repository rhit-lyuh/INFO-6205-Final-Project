package smartdietplanner.model;

import java.util.UUID;

public class UserData {
	
	//Data Field
	private static UserData data;
	
	private String userName;
	private String uuid;
	
	//Cons
	private UserData() {}

	//Get data(instance)
	public static UserData getData() {
		if(data == null) {
			data = new UserData();
		}
		return data;
	}
	
	//Set data
	public void setUserData(String userName, String uuid) {
		this.userName = userName;
		this.uuid = uuid;
	}
	
	//Getter
	public String getUserName() {
		return userName;
	}
	
	public String getUUID() {
		return uuid;
	}
	
}
