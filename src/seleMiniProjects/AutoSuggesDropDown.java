package seleMiniProjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggesDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.xpath("//textarea[@title='Search']"));
		search.sendKeys("idl");
		
		Thread.sleep(Duration.ofSeconds(5));
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul//li//div[@role='presentation']//span"));
		for(WebElement ele:suggestions)
		{
			if(ele.getText().contains("Idli"));
			ele.click();
			break;
		}
	}

}
