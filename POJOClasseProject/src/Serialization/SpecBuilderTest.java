package Serialization;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJOClasses.AddPlace;
import POJOClasses.Location;
import Specifications.SpecBuilders;

public class SpecBuilderTest {
	public static void main(String[] args)
	{
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		List<String> mylist = new ArrayList();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);	
		
		String res =given().spec(SpecBuilders.ReqSpecBuilder()).
		body(p).when().post("/maps/api/place/add/json").then().spec(SpecBuilders.ResponseSpecBuilder()).extract().response().asString();
		
		System.out.println(res);
		
}
}