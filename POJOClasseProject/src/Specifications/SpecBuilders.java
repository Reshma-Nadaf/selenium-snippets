package Specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	public static RequestSpecification ReqSpecBuilder()
	{
		
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		
		return req;
	}

	public static ResponseSpecification ResponseSpecBuilder()
	{
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		return resp;
	}
	
}
