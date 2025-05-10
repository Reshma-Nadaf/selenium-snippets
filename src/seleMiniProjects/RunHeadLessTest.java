package seleMiniProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import junit.framework.Assert;

public class RunHeadLessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920, 1080");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.screener.in/");

        System.out.println("Title is: " + driver.getTitle());

       
        driver.findElement(By.xpath("//a[@class='button account']")).click();
		driver.findElement(By.name("username")).sendKeys("reshmanadaf@201");
		driver.findElement(By.name("password")).sendKeys("Screener@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		
		 driver.quit();		
		
	}

}
