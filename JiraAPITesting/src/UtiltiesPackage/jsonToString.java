package UtiltiesPackage;

import io.restassured.path.json.JsonPath;

public class jsonToString {

	public static String convertJson(String response)
	{
		JsonPath json = new JsonPath(response);
		String id = json.get("id");
		return id;
		
	}
}
