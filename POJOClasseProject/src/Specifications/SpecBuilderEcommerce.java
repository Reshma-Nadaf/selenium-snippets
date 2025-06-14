package Specifications;
import EcommerceApp.LoginTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class SpecBuilderEcommerce {

	public static ResponseSpecification ResponseSpecBuilder()
	{
		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		return res;
		
	}
	
	public static RequestSpecification RequestSpecBuilder()
	{
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				setContentType(ContentType.JSON).build();
		return req;
	}
	public static ResponseSpecification ResponseSpecBuilderAddProd()
	{
		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(201).build();
		return res;
		
	}
	
	
}
