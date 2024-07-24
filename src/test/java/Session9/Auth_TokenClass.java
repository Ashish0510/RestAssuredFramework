package Session9;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Auth_TokenClass {

	@Test
	void BearerTokenDemo() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://gorest.co.in/");
		requestSpecification.basePath("public/v2/users");

		JSONObject payloadJsonObject = new JSONObject();
		payloadJsonObject.put("name", "Aman");
		payloadJsonObject.put("gender", "Male");
		payloadJsonObject.put("email", "Ashish09@yopmail.com");
		payloadJsonObject.put("status", "Active");

		Response response = requestSpecification
				.headers("Authorization", "Bearer ac0668778afc13deeb582d0f1b0817ccc8e876ac53fdbe74beb5a6b707e91434")
				.contentType(ContentType.JSON).body(payloadJsonObject.toJSONString()).post();
		ResponseBody responseBody=response.getBody();
		int statusCode=response.getStatusCode();
        String BodyString=response.getBody().asString();
		
		System.out.println("The status of post request is :"+statusCode );
		System.out.println("The status of post request is :"+BodyString );
		
		JsonPath jasonpathveiw=responseBody.jsonPath();
		String bodyEmailString=jasonpathveiw.get("email");
		
		System.out.println("The email present in the post Request is: "+bodyEmailString );
		
		Assert.assertEquals(bodyEmailString, "Ashish09@yopmail.com");
		
	//	Assert.assertEquals(false, null)

		// https://gorest.co.in/public/v2/users
	}

}
