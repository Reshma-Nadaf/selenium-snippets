package seleMiniProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		driver.get("https://demoqa.com/checkbox");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement home= driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		JavascriptExecutor  js = (JavascriptExecutor )driver;
		js.executeScript("arguments[0].style.border='2px solid pink'", home);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
		            home,"background: yellow; border: 2px solid red;"); //highlights in yellow color
		
		driver.findElement(By.xpath("(//span[@class='rct-text']//preceding-sibling::button[@title='Toggle'])[1]")).click();
		WebElement checkbox_Home = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']"));
		if(!checkbox_Home.isSelected())////span[@class='rct-title' and text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']
		{
			checkbox_Home.click();
		}
		
		//driver.findElement(By.xpath("//span[@class='rct-title' and text()='Downloads']/preceding-sibling::span[@class='rct-checkbox']")).click();
		
	
		//
		//driver.quit();
	}

}
