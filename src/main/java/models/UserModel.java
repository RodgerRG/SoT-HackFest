package models;

public class UserModel {
	public static enum UserType {
		GUEST, USER, ADMIN, SUPERUSER;
	}
	
	private double latitude;
	private double longitude;
	private int userID;
	private String email;
	private String phone;
	private UserType type;
	
	public UserModel(double latitude, double longitude, int userID, String email, String phone, UserType type) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.userID = userID;
		this.email = email;
		this.phone = phone;
		this.type = type;
	}
	
}
