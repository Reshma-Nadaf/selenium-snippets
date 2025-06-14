package polymorphism;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomepageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = DriverFactory.getDriver("chrome");
		driver.get("https://www.amazon.in/");
		
		HomePage h = new HomePage(driver);
		h.searchProduct();
		
	}

}
