package SeleniumPackage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNgClass {
	
	WebDriver driver = null;
	@BeforeTest
	public void SetupDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\hasan\\\\Downloads\\\\chromedriver\\\\chromedriver-win32\\\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@Test
	public void MainTest()
	{
		driver.get("https://www.screener.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void TearDownMethod()
	{
		driver.quit();
		
		
		
		
	}

/* this content of the xml file
 * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Testing_testng">
    <test name="TestNgTests">
        <classes>
            <class name="SeleniumPackage.TestNgClass"/>
        </classes>
    </test>
</suite>
 * 
 */

}

