package seleMiniProjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HandlingTabs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");  // This page has buttons that open new tabs
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.id("tabButton")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());

        driver.quit();
	}

}
