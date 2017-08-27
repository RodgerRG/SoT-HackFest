package service;

import static spark.Spark.get;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResult;

import googleData.GoogleInteracter;
import models.LocationModel;
import models.TestModel;
import spark.Request;
import spark.Response;

public class ServiceImpl implements Service{
	private Gson gson = new Gson(); 
	
	public ServiceImpl() {
		get("/hello/:lat/:long", (req, res) -> testEndpoint(req));
		get("/locations/:lat/:long", (req, res) -> getLocations(req, res));
		get("/searchLocations/:lat/:long/:query", (req, res) -> searchLocations(req, res));
		get("/emergency/:lat/:long/:userID", (req, res) -> registerEvent(req, res));
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
			results = google.getLocations(Double.parseDouble(req.params(":lat")), Double.parseDouble(req.params(":long")), 4000);
		} catch (NumberFormatException e) {
			throw new RuntimeException();
		} catch (ApiException e) {
			throw new RuntimeException();
		} catch (InterruptedException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();	
		}
		
		ArrayList<LocationModel> output = new ArrayList<>();
		for(int i = 0; i < results.length; i++) {
			output.add(new LocationModel(results[i]));
		}
		return gson.toJson(output);
	}
	@Override
	public String searchLocations(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String registerEvent(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
	}

}
