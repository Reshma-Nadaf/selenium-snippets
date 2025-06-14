package ListenersTests;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(CustomeListner.class)
public class TestListeners extends BaseClass{
	
	@BeforeMethod
	public void SetUp()
	{
		initilization();
	}
	
	@Test
	public void TakeScreenShotTest()
	{
		Assert.assertEquals(false, true);
		
	}
	
	@Test
	public void LaunchBrowser()
	{
		Assert.assertEquals(false, true);

	}
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
}