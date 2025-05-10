package seleMiniProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/webtables");
		WebElement table = driver.findElement(By.xpath("//div[@class='rt-table']"));
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));
		
		for(int i =1; i<rows.size(); i++)
		{
			WebElement row = rows.get(i);
			
			List<WebElement> col = row.findElements(By.xpath(".//div[@class='rt-td']"));
			for(WebElement colVal: col)
			{
				System.out.print(colVal.getText()+"|");
			}
			 System.out.println(); 
		}
		
		driver.quit();
		
	}

}
