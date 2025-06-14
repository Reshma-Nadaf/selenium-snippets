package OOPSInheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		Homepage hp = new Homepage(driver);
		hp.openUrl("https://www.amazon.in/");
		hp.maximizeWindow();
		hp.searchProduct();
	}

}
