package seleMiniProjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingFilesOps {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		/***
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\hasan\\Desktop\\IMG_0400.jpg");
		***/
		// downloading the file
		HashMap<String, Object> chromPrefs = new HashMap<>();
		chromPrefs.put("download.default_directory","C:\\Users\\hasan\\Desktop");
		chromPrefs.put("download.prompt_to_download", false);
		
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("prefs",chromPrefs);
		
		WebDriver driver= new ChromeDriver(op);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		//driver.findElement(By.xpath("//a[contains(text(),'Download sample pdf file')]")).click();
		
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir")+"/screenshots/newScreenshot_"+timestamp+".jpg";
		File dest = new File(screenshotPath);
		
		FileUtils.copyFile(screenShot, dest);
		
		
		
		
		

}
}