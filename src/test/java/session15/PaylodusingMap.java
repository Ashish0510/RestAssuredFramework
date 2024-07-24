package session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PaylodusingMap {
	
	@Test
	void Payloadusingcollection(){
		
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users");
		
		Map<String,Object> payloadMap= new HashMap<String,Object>();
		
		payloadMap.put("firstname","Ashish");
		payloadMap.put("lastname","Srivastava");
		payloadMap.put("Age",28);
		payloadMap.put("salary",10000.2);
		
		ArrayList<String> hobbieStrings=new ArrayList<String>();
		hobbieStrings.add("music");
		hobbieStrings.add("cricket");
		hobbieStrings.add("reading");
		
		payloadMap.put("hobbies",hobbieStrings);
		
		HashMap<String, String> techSkills= new HashMap<String, String>();
		techSkills.put("programming language","java");
		techSkills.put("Framework","selenium");
		techSkills.put("Department","Testing");
		
		payloadMap.put("Techskills",techSkills);
		
		
		Response response= requestSpecification.contentType(ContentType.JSON)
				.body(payloadMap).post();
		
		response.prettyPrint();
		
		
		
		
	}

}
