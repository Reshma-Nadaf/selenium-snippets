package ExtentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportsTest {

	
		ExtentReports extent;
		ExtentTest test;
		
		@BeforeSuite
		public void setupReports()
		{
			extent = ExtentreportsUtil.getInstance();
		}
	
		@Test
		public void LoginTests()
		{
			test = extent.createTest("LoginTests");
			
			test.pass("test login");
			 test.pass("Navigated to login page");
		        test.pass("Entered username and password");
		        test.pass("Clicked on Login");		}
		@AfterSuite
		public void tearDown()
		{
			extent.flush();
		}
}
