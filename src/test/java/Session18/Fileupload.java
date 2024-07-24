package Session18;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Fileupload {
	
	@Test
	void To_Fileupload() {
		
		File testfile=new File (".//Demofile//Ashish.txt");
		RequestSpecification requestSpecification=RestAssured.given();
		
		requestSpecification.baseUri("http://httpbin.org/post");
		requestSpecification.multiPart("file", testfile);
		
		Response response=requestSpecification.post();
		 
		response.prettyPrint();
		
		
		
	}

}
