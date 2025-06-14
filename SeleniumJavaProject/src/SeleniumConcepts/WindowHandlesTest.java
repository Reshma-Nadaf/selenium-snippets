package SeleniumConcepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\hasan\\eclipse-workspace\\SeleniumJavaProject\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement searchTab = driver.findElement(By.id("twotabsearchtextbox"));
		searchTab.click();
		searchTab.sendKeys("Phone");
		searchTab.sendKeys(Keys.ENTER);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,400");
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		WebElement thirdProduct = driver.findElement(By.xpath(("(//div[@class='puisg-row']//h2[@class])[position()=3]/a/span")));
		js.executeScript("arguments[0].scrollIntoView(true);", thirdProduct);
		//js.executeScript("arguments[0].scrollInToView(true);", thirdProduct);
		
		js.executeScript("arguments[0].click();", thirdProduct);
		
		System.out.println("procuct selected");
		Thread.sleep(5000);
		
		
		String mainWindow = driver.getWindowHandle();
		System.out.println("mainWindow"+mainWindow);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("allWindows"+allWindows);

		for(String handle:allWindows)
		{
			if(!handle.equals(mainWindow))
			{
				System.out.println("switching window");

				driver.switchTo().window(handle);
				System.out.println("switching window");

				break;
			}
			
		}
		//driver.switchTo().parentFrame();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-box a-accordion-active celwidget']//input[@id='add-to-cart-button']")));
		driver.findElement(By.xpath("//div[@class='a-box a-accordion-active celwidget']//input[@id='add-to-cart-button']")).submit();
		
		String validateText = driver.findElement(By.xpath("(//h4[contains(text(),'Added to Cart')])[position()=2]")).getText();
		
		if(validateText.equals("Added to Cart"))
		{
			System.out.println("added to cart");
		}
		
		
}}