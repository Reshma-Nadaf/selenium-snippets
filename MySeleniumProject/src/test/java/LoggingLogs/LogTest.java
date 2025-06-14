package LoggingLogs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver ;
		Logger log = Logger.getLogger(LogTest.class);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.screener.in/dash/");	
		log.info("url is loaded in successful");
		
		
		
		
	}
	

}
