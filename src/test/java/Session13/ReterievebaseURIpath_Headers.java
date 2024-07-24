package Session13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ReterievebaseURIpath_Headers {
	
	@Test
	void reterieveBasepathuri_and_Headers() {
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users");
		
		JSONObject payloadJsonObject=new JSONObject();
		payloadJsonObject.put("name", "Ashish");
		payloadJsonObject.put("job", "QA");
		
		Response response=requestSpecification.contentType(ContentType.JSON).
				body(payloadJsonObject.toJSONString()).post();
		
		QueryableRequestSpecification queryableRequest= SpecificationQuerier.query(requestSpecification);
		
	String	Baseuri=queryableRequest.getBaseUri();
	System.out.println("the base uri : "+Baseuri );
	String	Basepath=queryableRequest.getBasePath();
	System.out.println("the base path : "+Basepath );
	Headers headers=queryableRequest.getHeaders();
	
	for (Header head:headers) {
		System.out.println("the header :"+head);
		
	}
	}
	
}
