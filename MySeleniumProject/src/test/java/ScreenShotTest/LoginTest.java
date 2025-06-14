package ScreenShotTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Screenshotutility.ScreenshotUtils;

public class LoginTest {

	WebDriver driver ;
	
	@Test
	public void LoginTests()
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.screener.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		ScreenshotUtils.captureScreenShot(driver, "loginTest");
	
	}
}
