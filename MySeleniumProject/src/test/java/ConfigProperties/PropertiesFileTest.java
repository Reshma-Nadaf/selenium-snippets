package ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesFileTest {
	
 public static void main(String[] args) throws IOException
 {
	 
	 Properties prop = new Properties();
	 FileInputStream ip = new FileInputStream("C:\\Users\\hasan\\eclipse-workspace\\"+
	 "MySeleniumProject\\src\\test\\java\\ConfigProperties\\configuration.properties");
	 
	 //load the input file
	 prop.load(ip);
	 
	 System.out.println(prop.getProperty("browser"));
	 
	 
	 WebDriver driver ;
	 String  browserName = "Chrome";
	 if(browserName.equals(prop.getProperty("browser")))
	 {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//i[@class='icon-user-line blue-icon']")).click();
			driver.findElement(By.id("id_username")).clear();
			driver.findElement(By.id("id_username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.id("id_password")).clear();
			driver.findElement(By.id("id_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//button[@type='submit']")).submit();	
			driver.quit();
		 
	 }
 }
 
 
 }
	

