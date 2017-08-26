package models;

public class EventModel {
	private static enum EventType {
		HEART, ASTHMA, ALLERGY;
	}
	
	private double latitude;
	private double longitude;
	private int userID;
	private EventType type;
	
	public EventModel(double latitude, double longitude, int userID, EventType type) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.userID = userID;
		this.type = type;
	}
	
	
}
