package Session8;

import org.apache.http.StatusLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class Basic_Authentication {
	@Test(enabled=false)
	void BasicAuthentication() {

		// in basic Authentication to encrypt base64 is used and it is 2 types primitive
		// and non primitive
		// in non primitive is basic it provide the username and password to the server
		// if server ask for the credentials
		// in primitive it provide the credentials whether server is asked for it or
		// not.
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("http://postman-echo.com/");
		requestSpecification.basePath("basic-auth");

		Response response = requestSpecification.auth().basic("postman", "password").get();

		System.out.println("The response Body is :" + response.getStatusCode());

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

		//

	}

	@Test
	void DigestAuthentication() {
		// in this encryption is with Algorithm
		RequestSpecification requestSpecification = RestAssured.given();

		requestSpecification.baseUri("http://httpbin.org/");
		requestSpecification.basePath("digest-auth/undefined/Ashish/Ashish");

		Response response = requestSpecification.auth().digest("Ashish", "Ashish").get();

		int Statuscode = response.statusCode();
		
		System.out.println("The Actual Status code :"+Statuscode );
		
		Assert.assertEquals(Statuscode, 200);
		// http://httpbin.org/digest-auth/undefined/Ashish/Ashish
	}

}
