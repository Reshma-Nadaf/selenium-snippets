package TestPackage;

import java.lang.reflect.Array;
import java.util.List;

import org.testng.Assert;

import PayLoadPackage.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.ParseJson());
		
		// 1. retrive the course size
		int size = js.getInt("courses.size()");
		System.out.println(size);
		
		// 2. retrive the title of first course that are inside array denoted by []
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
		//3. get the total purchase amount
		int priceTotal = js.getInt("dashboard.purchaseAmount");
		System.out.println(priceTotal);
		
		//4. retrive course price and title one by one
		int count = js.getInt("courses.size()");
				
		for (int i=0;i<count;i++)
		{
			String title = js.getString("courses["+i+"].title");
			System.out.println(title);
			int price = js.getInt("courses["+i+"].price");
			System.out.println(price);	
		}
		
		//5. Retrive no of copies sold by course RPA
		
		for(int i=0; i<count; i++)
		{
			String title = js.getString("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA"))
			{
				int RPAPrice = js.getInt("courses["+i+"].price");
				System.out.println(RPAPrice);
				
				int soldcopies = js.getInt("courses["+i+"].copies");
				System.out.println(soldcopies);
			
				System.out.println(RPAPrice * soldcopies );
				break;
			}
		}
			
		//6. sum of all courses sold is equal to total
		System.out.println("*****************************************");
		int sum = 0;
		for(int i=0; i<count; i++)
		{
			String title = js.getString("courses["+i+"].title");
			int Price = js.getInt("courses["+i+"].price");
			//System.out.println(Price);
			
			int soldcopies = js.getInt("courses["+i+"].copies");
			//System.out.println(soldcopies);
		
			int SoldPrice = Price * soldcopies ;
			
			sum =sum + SoldPrice;
					
		}
		System.out.println(sum);

		Assert.assertEquals(sum, priceTotal);
			
			
	}

}
