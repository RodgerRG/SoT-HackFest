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
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

public class GoogleInteracter {
	
	private List<LatLng> locations;
	
	public GoogleInteracter() {
		
	}
	
	
	
	 public static void main(String[] args) throws ApiException, InterruptedException, IOException {
		 
		 GeoApiContext context = new GeoApiContext.Builder()
				    .apiKey("AIzaSyAQiwpugiJrQn0sdELdxj40ukpjr67kj7w")
				    .build();
		 
		 NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, new LatLng(-36.848461,174.763336));
		 
		 request.radius(10000);
		 
		 PlacesSearchResponse response = request.await();
		 PlacesSearchResult[] results = response.results;
		 
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(results));
		 
		 /*GeocodingApiRequest request = GeocodingApi.geocode(context, "13A Newhaven Tce, Mairangi Bay, Auckland");
		 
		 GeocodingResult[] results = PlacesApi.nearbySearchQuery(context, request);
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				System.out.println(gson.toJson(results[0].addressComponents));*/
	  }

}
