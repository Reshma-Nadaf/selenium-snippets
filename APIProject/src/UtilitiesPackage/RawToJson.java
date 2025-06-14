package UtilitiesPackage;

import io.restassured.path.json.JsonPath;

public class RawToJson {

	public static String convertToJson(String response, String param)
	{
		String jsonReponse;
		
		JsonPath js = new JsonPath(response);
		jsonReponse = js.getString(param);
		
		return jsonReponse;
	}
}
