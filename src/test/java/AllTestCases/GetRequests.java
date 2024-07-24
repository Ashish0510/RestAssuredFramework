package AllTestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequests {
	
	@Test
	public void firstGetRequest() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Status code of the api :"+ response.getStatusCode() );
		System.out.println("Status code of the api :"+ response.getBody().asString());
		System.out.println("Status code of the api :"+ response.getTime() );
		System.out.println("Status code of the api :"+ response.getHeader("Content-Type") );
		
		System.out.println("Status code of the Api :"+response.sessionId());
		
		System.out.println("status code of the Api :"+response.sessionId());
	   
	   
		int ActualStatusCode=response.getStatusCode();
		int ExpectedStatusCode=200;
		
		
		Assert.assertEquals(ExpectedStatusCode, ActualStatusCode);
		
	}
// BDD style 
	@Test
	public void Testcase2() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().queryParam("page","2")
		.when().get()
		.then().statusCode(200);
	}
}
