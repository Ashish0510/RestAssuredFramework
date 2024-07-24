package Session6;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.Theories;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseBodyClass {

	@Test
	void RequestBody() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users/?page=2");

		Response response = requestSpecification.get();
		ResponseBody responseBody = response.getBody();
		String reString = responseBody.asString();
		System.out.println("the body String is : " + reString);
		
		
		// to find the particular name contains in the whole response body
		Assert.assertEquals(reString.contains("George"), true);
		
		
		
		
		// to find the particular data in the array of the body
		JsonPath JSONObject = responseBody.jsonPath();
		String jsonString = JSONObject.get("data[0].first_name");
		Assert.assertEquals(jsonString, "George");

	}

}
