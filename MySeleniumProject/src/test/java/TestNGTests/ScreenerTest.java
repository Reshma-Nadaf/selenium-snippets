package TestNGTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScreenerTest {

	WebDriver driver;
	@BeforeMethod
	@Parameters({"browser"})
	public void SetupMethod(String browser)
	{
		if(browser.contains("chrome"))
		{
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		driver.get("https://www.screener.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}
	
	@Test
	@Parameters({"username","password"})
	public void LoginTest(String username, String password )
	{
		driver.findElement(By.xpath("//i[@class='icon-user-line blue-icon']")).click();
		driver.findElement(By.id("id_username")).clear();
		driver.findElement(By.id("id_username")).sendKeys(username);
		driver.findElement(By.id("id_password")).clear();
		driver.findElement(By.id("id_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();		
		System.out.println("logged in");
	}
	
	@Test(dependsOnMethods ="LoginTest")
	public void HomepageTest()
	{
		driver.findElement(By.xpath("//i[@class='icon-user-line blue-icon']")).click();
		driver.findElement(By.id("id_username")).clear();
		driver.findElement(By.id("id_username")).sendKeys("reshmanadaf201@gmail.com");
		driver.findElement(By.id("id_password")).clear();
		driver.findElement(By.id("id_password")).sendKeys("Screener@123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		boolean condition = driver.findElement(By.xpath("//a[contains(text(),'Feed')]")).isDisplayed();
		Assert.assertTrue(condition);		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
}
