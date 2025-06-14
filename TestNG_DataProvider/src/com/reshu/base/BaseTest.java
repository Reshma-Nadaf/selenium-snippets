package com.reshu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dev.failsafe.internal.util.Durations;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
