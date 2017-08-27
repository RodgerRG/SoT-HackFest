package service;

import spark.Request;
import spark.Response;

public interface Service {
	/**Test method on get method for spark. Call http://localhost:4567/hello to test. */
	String testEndpoint(Request req);
	
	String getLocations(Request req, Response res);
	
	String searchLocations(Request req, Response res);
	
	String registerEvent(Request req, Response res);
	
}
