package googleData;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PendingResult;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

public class GoogleInteracter {
	
	private GeoApiContext context;
	
	public GoogleInteracter() {
		context = new GeoApiContext.Builder()
			    .apiKey("AIzaSyAQiwpugiJrQn0sdELdxj40ukpjr67kj7w")
			    .build();
		
	}
	
	/**
	 * 
	 * Returns a list of emergency places of interests - hospitals, police stations, doctors, pharmacies - 
	 * within a specified radius boundary from the user's current location.
	 * 
	 * 
	 * @param lat - Latitude of the user's current location.
	 * @param lng - Longitude of the user's current location.
	 * @param radius - The radius of the search boundary for nearby Places in metres.
	 * @return
	 * @throws ApiException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public PlacesSearchResult[] getLocations(double lat, double lng, int radius) throws ApiException, InterruptedException, IOException {
		
		NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, new LatLng(lat,lng));
		 
		 request.radius(radius);
		 request.type(PlaceType.HOSPITAL,PlaceType.POLICE,PlaceType.DOCTOR,PlaceType.PHARMACY);
		 
		 PlacesSearchResponse response = request.await();
		 PlacesSearchResult[] results = response.results;
		 
		 return results;
	}
	
	/**
	 * 
	 * Returns a list of results matching the user's search keyword that is within a specified
	 * radius from the user's location.
	 * 
	 * 
	 * @param lat - Latitude of the user's current location.
	 * @param lng - Longitude of the user's current location.
	 * @param radius - The radius of the search boundary for nearby Places in metres.
	 * @param keyword - 
	 * @return
	 * @throws ApiException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public PlacesSearchResult[] getSearchResults(double lat, double lng, int radius, String keyword) throws ApiException, InterruptedException, IOException {
		
		NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, new LatLng(lat,lng));
		
		request.radius(radius);
		
		request.keyword(keyword);
		
		return request.await().results;
	}
}
