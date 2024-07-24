package Session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonobjectusingArrayorjsonobject {
	
	@Test(enabled = false)
	void Payloadusingjsonobjectandjsonarray() {
		RequestSpecification requestSpecification=RestAssured.given();
		
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users");
		
		JSONObject user1=new JSONObject();
		user1.put("name", "Ashish");
		user1.put("Age", "28");
		user1.put("salary", 1000.5);
		user1.put("Loaction", "Faridabad");
		
		JSONObject user2=new JSONObject();
		user2.put("name", "Amit");
		user2.put("Age", "29");
		user2.put("salary", 1000.55);
		user2.put("Loaction", "Gurgaon");
		
		JSONObject user3=new JSONObject();
		user3.put("name", "sonia");
		user3.put("Age", "30");
		user3.put("salary", 10000.5);
		user3.put("Loaction", "Rohtak");
		
		
		JSONArray payloadArray=new JSONArray();
		payloadArray.add(user1);
		payloadArray.add(user2);
		payloadArray.add(user3);
		
		
		Response response=requestSpecification
				.contentType(ContentType.JSON)
				.body(payloadArray).post();
		
		response.prettyPrint();
		
	
	}
	
	@Test
	void Payloadusingmap_and_array() {
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users");
		
		Map<String,String> user1=new HashMap<String,String>();
		user1.put("name","Ashish");
		user1.put("Salary","1000.5");
		user1.put("Location","Faridabad");
		user1.put("age","30");
		
		Map<String,String> user2=new HashMap<String,String>();
		user2.put("name","Amit");
		user2.put("Salary","1000.55");
		user2.put("Location","Delhi");
		user2.put("age","31");
		
		
		ArrayList<Map<String, String>> payloadArrayList=new ArrayList<Map<String, String>>();
		payloadArrayList.add(user1);
		payloadArrayList.add(user2);
		
		Response response=requestSpecification.contentType(ContentType.JSON)
				.body(payloadArrayList).post();
		
		response.prettyPrint();
		
		
		
		
	}

}
