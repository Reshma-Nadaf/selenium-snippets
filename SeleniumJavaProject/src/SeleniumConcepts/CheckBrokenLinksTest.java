package SeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckBrokenLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hasan\\eclipse-workspace\\SeleniumJavaProject\\Drivers\\chromedriver\\chromedriver.exe");

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement l : links)
		{
			String url = l.getAttribute("href");
			
			if(!url.isEmpty() & url!= null)
			{
				//checkURL(url); //needs apache package
			}
		}

	}
	

}
