package seleMiniProjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;



public class newClass {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		driver.get("https://www.screener.in/");
		
		driver.findElement(By.xpath("//a[@class='button account']")).click();
		driver.findElement(By.name("username")).sendKeys("reshmanadaf201@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Screener@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement l: links)
		{
			String linkText = l.getText();
			System.out.println(linkText);
			if(linkText.equalsIgnoreCase("SCREENS"))
			{
				l.click();
				System.out.println("Clicked on link");
				break;
			}
		}
	
		//take screenshot for the page
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String filepath = System.getProperty("user.dir")+"/screenshots/"+ "newsc_timestamp"+".jpg";
		File dest = new File(filepath);
		FileUtils.copyFile(scr, dest);
	}
	

}
