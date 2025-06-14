package polymorphism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	WebDriver driver;
	
	BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	// overloadding  - same method name, diff parameters
	public WebElement findElement(By locator)
	{
		return driver.findElement(locator);		
	}
	
	public WebElement findElement(String Xpath)
	{
		return driver.findElement(By.xpath(Xpath));
	}
	
	// over ridding - same method name, parameters different behavior
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
}
