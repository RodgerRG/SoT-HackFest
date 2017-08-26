package googleData;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class GoogleInteracter {
	
	 public static void main(String[] args) throws ApiException, InterruptedException, IOException {
		 
		 GeoApiContext context = new GeoApiContext.Builder()
				    .apiKey("AIzaSyAQiwpugiJrQn0sdELdxj40ukpjr67kj7w")
				    .build();
		 
		 GeocodingResult[] results =  GeocodingApi.geocode(context,
				    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				System.out.println(gson.toJson(results[0].addressComponents));
	  }
	
	
	
	

}
