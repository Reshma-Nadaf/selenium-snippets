package OOPSInheritance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	BasePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));//
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public WebElement findElement(By locator)
	{
		WebElement ele = driver.findElement(locator);
		return ele;
	}
	
	public void clickElement(WebElement ele)
	{
		ele.click();
	}
	
	public void SendKeysToField(String value, WebElement ele)
	{
		ele.sendKeys(value);
	}
	
	public WebElement waitforElementToBeVisible(WebElement ele)
	{
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public WebElement waitforElementToBeClikable(WebElement ele)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}


