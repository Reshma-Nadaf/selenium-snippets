package seleMiniProjects;
import java.net.URL;
import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validate_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link: links)
		{
			String urlLink = link.getDomAttribute("href");
			if(urlLink==null || urlLink.isEmpty())
			{
				System.out.println("url is empty");
				continue;
				
			}
			try {
			URI uri = URI.create(urlLink);
			URL url = uri.toURL();
			
			HttpURLConnection connect = (HttpURLConnection)url.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			
			int responseCode = connect.getResponseCode();
			if(responseCode>= 400)
			{
				System.out.println("link is broken"+responseCode);
			}
			else
			{
				System.out.println("link is valid");
			}
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
}
