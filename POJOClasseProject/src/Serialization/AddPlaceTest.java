package Serialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import POJOClasses.AddPlace;
import POJOClasses.Location;

public class AddPlaceTest {
	public static void main(String[] args)
	{
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		ArrayList<String> mylist = new ArrayList();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res =given().queryParam("key", "qaclick123").
		body(p).when().post("/maps/api/place/add/json").then().assertThat().extract().response().asString();
		
		
}
}