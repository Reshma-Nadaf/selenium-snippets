package polymorphism;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
		public HomePage(WebDriver driver)
		{
			super(driver);
		}

		By searchFiled = By.id("twotabsearchtextbox");
		
		
		public void clickElement(WebElement element)
		{
			element.clear();
			element.click();
			System.out.println("element has been clicked");
		}
		
		public void searchProduct()
		{
			WebElement search = findElement(searchFiled);
			clickElement(search);
			search.sendKeys("phones");
			search.sendKeys(Keys.ENTER);
			
		}
}
