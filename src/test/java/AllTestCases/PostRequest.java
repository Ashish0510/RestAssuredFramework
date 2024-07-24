package AllTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void testCase3() {
		JSONObject jsonData= new JSONObject();
		jsonData.put("name", "Ashish");  
		jsonData.put("job", "QA");  
		
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON)
		.body(jsonData.toJSONString()).
		when().post().then().statusCode(201).log().all();
	}

}
