package PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageFactoryTest extends BaseClass  {


	PageClass pg;
	
    
	
	@BeforeTest()
	public void initilize()
	{		
		
		setupDriver();
	      pg = new PageClass(driver);
	        
	}
	@Test
	public void TestPageFactory()
	{
		
		pg.clickFromElement();
		
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
