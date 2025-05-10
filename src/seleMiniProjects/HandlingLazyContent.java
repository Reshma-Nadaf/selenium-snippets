package seleMiniProjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingLazyContent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		driver.get("https://enviragallery.com/demo/lazy-loading-demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> images_1 = driver.findElements(By.xpath("//a[@class='envira-gallery-225278 envira-gallery-link']/div/img"));
		System.out.println(images_1.size());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		long lastHeight = 0;
		long newHeight = 1;
		
		while(newHeight>lastHeight)
		{
			lastHeight= newHeight;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			//js.executeScript("window.scrollBy(0,1500);");
			Thread.sleep(2000);
			
			newHeight=(long)js.executeScript("return document.body.scrollHeight");
			
		}
		
		//count all loaded images
		List<WebElement> images = driver.findElements(By.xpath("//a[@class='envira-gallery-225278 envira-gallery-link']/div/img"));
		System.out.println(images.size());
		
	}

}
