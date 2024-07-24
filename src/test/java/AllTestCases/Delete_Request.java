package AllTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete_Request {
	@Test
	public void testCase5() {
		RestAssured.baseURI="https://reqres.in/api/users/726";
		RestAssured.given().when().delete().then().statusCode(204).log().all();
		
	}

}
