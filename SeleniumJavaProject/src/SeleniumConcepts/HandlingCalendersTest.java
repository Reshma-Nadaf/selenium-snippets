package SeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalendersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hasan\\eclipse-workspace\\SeleniumJavaProject\\Drivers\\chromedriver\\chromedriver.exe");

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//div[@class='labelCalendarContainer']/i")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']"))));
		
		String dates = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[position()=2]")).getText();
		//System.out.println(currentDate);
		
		String[] currentDates = dates.split(" ");
		
		String month = currentDates[0];
		String year = currentDates[1];
		System.out.println(month);
		
		System.out.println(currentDates[1]);
		
	/*	while(month.equals("Dec 2025"))
		{
			driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[position()=3]")).click();
			dates = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[position()=2]")).getText();
			currentDates = dates.split(" ");
			month = currentDates[0];
			
		}
		*/
		do
		{
			driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[position()=3]")).click();
			dates = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[position()=2]")).getText();
			currentDates = dates.split(" ");
			month = currentDates[0];
			System.out.println(month);
		}
		
		
		while(!month.equals("Aug") & (!year.contains("2025")));
		driver.findElement(By.xpath("//div/span[contains(text(),'21')]")).click();
		
		

	}

}
