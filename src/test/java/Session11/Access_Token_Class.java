package Session11;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Access_Token_Class {

	static String accessString;
	static String LoginAccessString;

	@Test

	void GenerateAccessTokenRegistration() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("http://127.0.0.1:8000/");
		requestSpecification.basePath("api/user/register/");

		JSONObject payloadJsonObject = new JSONObject();
		payloadJsonObject.put("email", "Ashish67@yopmail.com");
		payloadJsonObject.put("name", "samson");
		payloadJsonObject.put("password", "Password@123");
		payloadJsonObject.put("password2", "Password@123");

		Response response = requestSpecification.contentType(ContentType.JSON).body(payloadJsonObject.toJSONString())
				.post();
		String bodyString = response.getBody().asString();
		int statuscode = response.getStatusCode();

		System.out.println("The Body in  response :" + bodyString);
		JsonPath jsonpathview = response.jsonPath();
		accessString = jsonpathview.get("token.access");

		System.out.println("the access token after Registration:" + accessString);

		Assert.assertEquals(statuscode, 201, "The user successfully Registered");

	}

	@Test(dependsOnMethods = "GenerateAccessTokenRegistration")
	void usingAccessTokenLogin() {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("http://127.0.0.1:8000/");
		requestSpecification.basePath("api/user/login/");

		JSONObject payloadJsonObject = new JSONObject();
		payloadJsonObject.put("email", "Ashish67@yopmail.com");
		payloadJsonObject.put("password", "Password@123");

		Response response = requestSpecification.headers("Authorization", accessString).contentType(ContentType.JSON)
				.body(payloadJsonObject.toJSONString()).post();

		String bodyString = response.getBody().asString();
		int statuscode = response.getStatusCode();

		System.out.println("The Body in  response :" + bodyString);
		JsonPath jsonpathview = response.jsonPath();
		String LoginAccess = jsonpathview.get("token.access");
		// String LoginAccessString = jsonpathview.get("token.access");
		LoginAccessString = "Bearer " + LoginAccess;

		System.out.println("the access token after login:" + accessString);
		System.out.println("the access token after login:" + LoginAccessString);

		Assert.assertEquals(statuscode, 200, "The user successfully logged in");

	}

	@Test(dependsOnMethods = "usingAccessTokenLogin")
	void GetprofileAfterloginAccessLogin() {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("http://127.0.0.1:8000/");
		requestSpecification.basePath("api/user/profile/");
		System.out.println("Profile method invoked");

		Response response = requestSpecification.headers("Authorization", LoginAccessString).get();

		System.out.println("Response executed");

		String bodyString = response.getBody().asString();
		int statuscode = response.getStatusCode();

		System.out.println("got the status code");

		System.out.println("The Body in  response :" + bodyString);
		ResponseBody responseBody = response.getBody();
		JsonPath jsonpathview = responseBody.jsonPath();
		System.out.println("jsonpathview executed");

		// String profileid = jsonpathview.get("id");
		// String profileName= jsonpathview.get("name");

		// System.out.println("got the id and name ");

		// System.out.println("The profile id and name :"+profileid +" ,"+profileName);

		Assert.assertEquals(statuscode, 200);

	}
}
