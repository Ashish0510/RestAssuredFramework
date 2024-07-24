package AllTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	@Test
	public void testcase4() {
		JSONObject jsonData= new JSONObject();
		jsonData.put("name", "Amit");  
		jsonData.put("job", "Developer");  
		
		
		RestAssured.baseURI="https://reqres.in/api/users/726";
		RestAssured.given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().put()
		.then().statusCode(200)
		.log().all();
	}

}
