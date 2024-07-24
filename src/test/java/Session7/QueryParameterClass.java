package Session7;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameterClass {
	@Test
	void QueryParametermethod() {
		RequestSpecification respec = RestAssured.given();
		respec.baseUri("https://reqres.in/");
		respec.basePath("api/users/");
		respec.queryParam("page", 2);
		respec.queryParam("id", 8);

		Response response = respec.get();

		ResponseBody resbody = response.getBody();
		String BodyString = resbody.asString();

		System.out.println("the particular data on page 2 :" + BodyString);

		JsonPath jsonpathview = resbody.jsonPath();
		String firstName = jsonpathview.get("data.first_name");
		System.out.println("The first Name of the json path is :" + firstName);

		Assert.assertEquals(firstName, "Lindsay");

	}

}
