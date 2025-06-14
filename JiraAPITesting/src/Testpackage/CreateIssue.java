package Testpackage;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.File;

import PayLoadPackage.Payloads;
import UtiltiesPackage.jsonToString;


public class CreateIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://reshma-nadaf.atlassian.net";
		String response = given().header("Content-Type", "application/json").header("Authorization","Basic cmVzaG1hbmFkYWYyMDFAZ21haWwuY29tOkFUQVRUM3hGZkdGMHY4N0JlSlF6VllaUDcyLVZRVE5LVG1oSUxaMTFlMTVjUGptVnVvNjM5bTJuOVU4RVJaOE0tY21nOHZaLXNzYU5YeHJiMWpaVzBxZGh1NzBtV0dMcHZWNE9BalJQamxkVGFwd1E4bGhWWUdFb3ppYW0zNGktM2dfTzhxeHVGWllqNUpuZmVkcURhbkd6QVdDWUpSYWFkS0tjWnBXUWdoZ2xMeGJianNwRFdwbz02OTExNUVDOA==").
		body(Payloads.CreateBug()).
		when().post("/rest/api/2/issue").then().log().all().statusCode(201).extract().response().asString();
		
		String issueId = jsonToString.convertJson(response);
		
		System.out.println(issueId);
		
		given().header("Authorization","Basic cmVzaG1hbmFkYWYyMDFAZ21haWwuY29tOkFUQVRUM3hGZkdGMHY4N0JlSlF6VllaUDcyLVZRVE5LVG1oSUxaMTFlMTVjUGptVnVvNjM5bTJuOVU4RVJaOE0tY21nOHZaLXNzYU5YeHJiMWpaVzBxZGh1NzBtV0dMcHZWNE9BalJQamxkVGFwd1E4bGhWWUdFb3ppYW0zNGktM2dfTzhxeHVGWllqNUpuZmVkcURhbkd6QVdDWUpSYWFkS0tjWnBXUWdoZ2xMeGJianNwRFdwbz02OTExNUVDOA==").
		header("X-Atlassian-Token","no-check").
		pathParam("key",issueId).
		multiPart("file", new File("C:\\Users\\hasan\\Pictures\\Screenshots\\hamcrest.png")).
		when().post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		
		
	}

}
