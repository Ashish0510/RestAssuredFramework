package Session5;

import java.util.List;

import org.junit.experimental.theories.Theories;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class ResponseHeader {
	
	@Test
	void ValidatingResponseHeader() {
		RequestSpecification requestSpec= RestAssured.given();
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users/2");
		
		Response response=requestSpec.get();
		//String contentString=response.getContentType();
		
		/*String contentString=response.getHeader("Content-Type");
		
		System.out.println("The content Type :"+contentString);*/
		
	Headers	header=response.getHeaders();
	
	for (Header head:header) {
		
		System.out.println("The key is : "+head.getName()+" and "+"The value is :"+head.getValue() );
	}
		
		
		
	}

}
