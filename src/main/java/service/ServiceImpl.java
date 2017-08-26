package service;

import static spark.Spark.get;

import com.google.gson.Gson;

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
		return gson.toJson(new TestModel());
		//return "You are at " + req.params(":lat") + " " + req.params(":long");
	}
	@Override
	public String getLocations(Request req, Response res) {
		// TODO Auto-generated method stub
		return null;
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
