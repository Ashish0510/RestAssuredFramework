package Session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonResponseDeserializer {
	
	@Test
	void jasondatadeserial() {
		RequestSpecification request=RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/users");
		
	JSONObject payload= new JSONObject();
	payload.put("name","Ashish");
	payload.put("job","QA");
	
	
	Response response=request.contentType(ContentType.JSON).body(payload.toJSONString()).post();
	
	ResponseBody responseBody=response.getBody();
	
	JsonResponseData responseclass= responseBody.as(JsonResponseData.class);
	
	System.out.println("The name is :"+responseclass.name);
	System.out.println("The job is :"+responseclass.job);
	System.out.println("The id is :"+responseclass.id);
	
	Assert.assertEquals(responseclass.name,"Ashish");
	Assert.assertEquals(responseclass.job,"QA");
	//Assert.assertEquals(responseclass.id,231);
	}

}
