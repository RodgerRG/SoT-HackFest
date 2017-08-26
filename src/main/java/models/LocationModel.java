package models;

import com.google.maps.internal.LatLngAdapter;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResult;

public class LocationModel {
	/**create an enum that stores the different types of locations that could be represented */
	private static enum LocationType {
		HOSPITAL, GP, POLICE, FIRESERVICE, DEFIB, USER, EMERGENCY, UNKNOWN, PHARMACY;
	}
	
	private String name;
	private double latitude;
	private double longitude;
	private String description;
	private int openingTime;
	private int closingTime;
	private float rating;
	private LocationType type;
	
	public LocationModel(PlacesSearchResult result) {
		name = result.name;
		LatLng location = result.geometry.location;
		latitude = location.lat;
		longitude = location.lng;
		description = result.formattedAddress;
		openingTime = result.openingHours.periods[0].open.time.getHourOfDay();
		closingTime = result.openingHours.periods[0].close.time.getHourOfDay();
		rating = result.rating;
		for(int i = 0; i < result.types.length; i++) {
			switch (result.types[i]) {
				case "hospital" :
					type = LocationType.HOSPITAL;
					break;
				case "fire_station" :
					type = LocationType.FIRESERVICE;
					break;
				case "police" :
					type = LocationType.POLICE;
					break;
				case "doctor":
					type = LocationType.GP;
					break;
				case "pharmacy" :
					type = LocationType.PHARMACY;
					break;
				default :
					type = LocationType.UNKNOWN;
					break;
			}
		}
	}
	
	public LocationModel(String json) {
		
	}
}
