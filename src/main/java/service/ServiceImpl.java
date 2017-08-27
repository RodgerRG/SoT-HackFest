package service;

import static spark.Spark.get;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResult;

import googleData.GoogleInteracter;
import models.EventModel;
import models.EventModel.EventType;
import models.LocationModel;
import spark.Request;
import spark.Response;

public class ServiceImpl implements Service{
	private Gson gson = new Gson(); 
	private EventModel newEvent;
	
	public ServiceImpl() {
		get("/hello/:lat/:long", (req, res) -> testEndpoint(req));
		get("/locations/:lat/:long/:radius", (req, res) -> getLocations(req, res));
		get("/searchLocations/:lat/:long/:radius/:query", (req, res) -> searchLocations(req, res));
		get("/emergency/:lat/:long/:userID/:eventType", (req, res) -> registerEvent(req, res));
	}
	@Override
	public String testEndpoint(Request req) {
		//return gson.toJson(new TestModel());
		System.out.println(Double.parseDouble("-1.354363"));
		return "You are at " + req.params(":lat") + " " + req.params(":long");
	}
	@Override
	public String getLocations(Request req, Response res) {
		GoogleInteracter google = new GoogleInteracter();
		PlacesSearchResult[] results = new PlacesSearchResult[0];
		try {
			results = google.getLocations(Double.parseDouble(req.params(":lat")), Double.parseDouble(req.params(":long")), Integer.parseInt(req.params(":radius")));
		} catch (NumberFormatException | ApiException | InterruptedException | IOException e) {
			return e.toString();
		}
		ArrayList<LocationModel> output = createLocationModels(results);
		
		return gson.toJson(output);
	}
	@Override
	public String searchLocations(Request req, Response res) {
		GoogleInteracter google = new GoogleInteracter();
		PlacesSearchResult[] results = new PlacesSearchResult[0];
		
		try {
			results = google.getSearchResults(Double.parseDouble(req.params(":lat")), Double.parseDouble(req.params(":long")), Integer.parseInt(req.params(":radius")), req.params(":query"));
		} catch (NumberFormatException | ApiException | InterruptedException | IOException e) {
			return e.toString();
		}
		ArrayList<LocationModel> output = createLocationModels(results);
		
		return gson.toJson(output);
	}
	@Override
	public String registerEvent(Request req, Response res) {
		EventType type;
		switch(req.params(":eventType")) {
		case "heart" :
			type = EventType.HEART;
			break;
		case "asthma" :
			type = EventType.ASTHMA;
			break;
		case "allergy" :
			type = EventType.ALLERGY;
			break;
			default :
				type = EventType.EMERGENCY;
		}
			newEvent = new EventModel(Double.parseDouble(req.params(":lat")), Double.parseDouble(req.params(":long")), Integer.parseInt(req.params(":userID")), type);
		
		//TODO add a call to the database to store the new event.	
		this.update();
		
		return "Done";
	}
	
	private String update() {
		//TODO event is dispatched to all clients that a new event has occurred.
		return gson.toJson(newEvent);
	}
	
	private ArrayList<LocationModel> createLocationModels(PlacesSearchResult[] results) {
		ArrayList<LocationModel> output = new ArrayList<>();
		for(int i = 0; i < results.length; i++) {
			output.add(new LocationModel(results[i]));
		}
		return output;
	}

}
