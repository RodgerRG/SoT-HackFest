package models;

public class LocationModel {
	/**create an enum that stores the different types of locations that could be represented */
	private static enum LocationType {
		HOSPITAL, GP, POLICE, FIRESERVICE, DEFIB, USER, EMERGENCY;
	}
	
	private String name;
	private double latitude;
	private double longitude;
	private String description;
	private int openingTime;
	private int closingTime;
	private float business;
	private LocationType type;
	
	public LocationModel(String name, String description, double latitude, double longitude, int openingTime, int closingTime, float business, LocationType type) {
		
	}
	
	public LocationModel(String json) {
		
	}
}
