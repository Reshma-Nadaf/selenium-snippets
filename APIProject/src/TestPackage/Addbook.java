package TestPackage;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayLoadPackage.payload;
import UtilitiesPackage.RawToJson;
import io.restassured.RestAssured;

public class Addbook {

	@Test(dataProvider = "booksData")
	public void AddBookToLib(String isbn, String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().header("Content-Type", "application/json").
		body(payload.libPayload(isbn, aisle)).
		when().post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
		String id =RawToJson.convertToJson(response, "ID");
		
		System.out.println(id);
	}
	
	//Arrays - collections of elements
	//multidimensional Array - collection of arrays
	
	@DataProvider(name = "booksData")
	
	public Object[][] getData()
	{
		return new Object[][] {{"ddswd","2651"},{"dfcdf","2866"},{"dchwd","9277"}};
	}
}
