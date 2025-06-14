package TestPackage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import PayLoadPackage.payload;


public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//given - all input data
		//when - crud operation with resource path
		//then - assertion of status code
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response = given().log().all().
		queryParam("key", "qaclick123").
		header("Content-Type", "application/json").
		body(payload.AddPlace()).
		when().post("/maps/api/place/add/json").
		//then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();		
		//to store the respose in string use extract method
		
		System.out.println(response);
		JsonPath js = new JsonPath(response); // parsing json
		String placeID = js.getString("place_id");
		System.out.println(placeID);
		
		
		
	}
	

}
