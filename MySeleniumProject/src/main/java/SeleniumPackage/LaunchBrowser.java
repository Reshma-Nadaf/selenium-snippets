package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.screener.in/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		if(title.equals("Stock Screener and fundamental analysis tool for Indian stocks - Screener")) {
			
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
			
		}
		
		WebElement loginButton = driver.findElement(By.xpath("//a[@class='button account']"));
		loginButton.click();
		
		WebElement userName = driver.findElement(By.id("id_username"));
		userName.clear();
		userName.sendKeys("reshmanadaf201@gmail.com");
		
		WebElement password = driver.findElement(By.id("id_password"));
		password.clear();
		password.sendKeys("Screener@123");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.submit();
		
		
		if(driver.findElement(By.xpath("//a[contains(text(),'Feed')]")).isDisplayed())
		{
			System.out.println("Logged in successfully");
		}
		
	}

}
