package OAuthentication;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import POJOClasses.Api;
import POJOClasses.GetCourseDetails;
import POJOClasses.WebAutomation;

public class OAuthTest {

	public static void main(String[] args)
	{
		
		String response = given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		formParams("grant_type","client_credentials").
		formParams("scope","trust").
		when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js = new JsonPath(response);
				String accessToken = js.getString("access_token");
		
		//Get Request
		GetCourseDetails gc = given().queryParam("access_token", accessToken).when().log().all().
		get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourseDetails.class);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(gc.getInstructor());
		
		//get courseTitel for soupUI
		String soupCourse = gc.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(soupCourse);
		
		//get courseTitel for soupUI without using index
	 List<Api> apiCourses = gc.getCourses().getApi();
		for(int i=0; i<apiCourses.size();i++)
		{
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
				System.out.println(gc.getCourses().getApi().get(i).getCourseTitle());
					}
		}
		//print all courses title of WebAutomation category
		System.out.println("printing all web automation courses");
		List<WebAutomation> webCourses = gc.getCourses().getWebAutomation();
		for(int i=0; i<webCourses.size();i++)
		{
			System.out.println(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
		}
		
		// comapring the list of web courses with mentioned in  this class with courses in json
		String[] coursesArray = {"Selenium Webdriver Java", "Cypress", "Protractor"}; // using array as list is not dynamic
		
		ArrayList<String> coursesList = new ArrayList<String>(); //using array list as list might to dynamic
		
		for(int i=0; i<webCourses.size();i++)
		{
			coursesList.add(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
		}
		
		List<String> c = Arrays.asList(coursesArray);
		Assert.assertEquals(c,coursesList );
	
				
	}
	
	
}
