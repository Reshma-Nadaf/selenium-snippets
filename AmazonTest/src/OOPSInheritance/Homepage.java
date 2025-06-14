package OOPSInheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage{

	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	
	private By searchField = By.id("twotabsearchtextbox");
	
	
	public void searchProduct()
	{
		WebElement search = findElement(searchField);
		waitforElementToBeClikable(search);
		clickElement(search);
		SendKeysToField("phone", search);
		search.sendKeys(Keys.ENTER);
	}
	


}
