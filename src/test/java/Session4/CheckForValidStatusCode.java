package Session4;


import java.nio.ReadOnlyBufferException;

import javax.sound.sampled.Line;

import org.apache.http.StatusLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidStatusCode {
	
	
	@Test(enabled=false)
	public void StatusCodeValidation() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification requestspecf= RestAssured.given();
		
		   Response response=requestspecf.get();
		   int ActualStatusCode =response.getStatusCode();
		   
		   Assert.assertEquals(ActualStatusCode, 200);
		   
		  String  statusLine=response.getStatusLine();
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","statusline String Line is validated" );
		

		}
	
	@Test(enabled=false)
	public void ValidatingusingValidatedResponse() {
		// instead of Assertion we can use ValidatableRespnose class 
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification requestspecf= RestAssured.given();
		
		
		          Response response=requestspecf.get();
		          
		         ValidatableResponse validresponse=response.then();
		         
		         //unlike Assertion we  have to write only expected response
		         
		         validresponse.statusCode(200);
		         // if the first validation true then only second will execute.
		         
		         validresponse.statusLine("HTTP/1.1 200 OK");
		         
	}
	
	@Test
	public void InBdd_Style() {
		RestAssured.given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	}
}
