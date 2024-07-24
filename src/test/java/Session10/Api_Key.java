package Session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Api_Key {
	
	@Test
	void ApikeyIn_parameter() {
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.baseUri("https://api.openweathermap.org/");
		requestSpecification.basePath("data/2.5/weather");
		requestSpecification.queryParam("q","Faridabad");
		requestSpecification.queryParam("appid","b3234bcb70449d75b830a7c5c1f5aa3d");
		
		Response response=requestSpecification.get();
		ResponseBody responseBody=response.getBody();
		
		int statuscode=response.getStatusCode();
		
		System.out.println("The response body is :"+responseBody.asString() );
		Assert.assertEquals(statuscode, 200);
		
		
	}
	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

}
