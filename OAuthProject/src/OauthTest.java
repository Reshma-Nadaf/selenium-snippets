import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OauthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		formParams("grant_type","client_credentials").
		formParams("scope","trust").
		when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);

		//get the access token
		JsonPath js = new JsonPath(response);
		String access_token = js.getString("access_token");
				
		//get request
		String response2 = given().queryParam("access_token", access_token).when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.asString();
		
		System.out.println(response2);
		
		
	}

}
