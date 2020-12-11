package com.actiTime.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass

{

	static WebDriver driver;
	ReadDataConfiguration readconfig=new ReadDataConfiguration();
	//public WebDriver;
	//@Parameters("browser")
	@BeforeClass
	//Accessing different browser
	//public void setUp(String br)
	public void setUp()
	{
		//		if (br.equals("Chrome"))
		//		{
		// ChromeDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("get url");
		System.out.println(readconfig.getUrl());
		driver.get(readconfig.getUrl());
		System.out.println(readconfig.getUrl());
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//		}
		//		else if(br.equals("Firefox"))
		//		{
		//		WebDriverManager.firefoxdriver().setup();
		//		WebDriver driver=new FirefoxDriver();
		//		System.out.println("get url");
		//		System.out.println(readconfig.getUrl());
		//		driver.get(readconfig.getUrl());
		//		System.out.println(readconfig.getUrl());
		//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//		}
	}
	public void takeScreebshot(String testName)
	{
		try
		{
			TakesScreenshot screenshots=(TakesScreenshot)Baseclass.driver;
			System.out.println("Driver taking screenshot");
			File source=screenshots.getScreenshotAs(OutputType.FILE);
			System.out.println(source);
			System.out.println("Taking screenshot for failed Test case");
			//	String filePath="D:\\GitLocalRepo\\ActiTime_Automation\\Screenshots\\";
			String filePath="./Screenshots/";
			System.out.println("Screenhots taken");
			new File(filePath);
			System.out.println("Test case faile in: "+testName);
			FileUtils.copyFile(source,new File("./Screenshots/"+testName+".png"));
			System.out.println("Screenshots moved to screenshot folder");


		} 
		catch (Exception e) 
		{
			System.out.println("error while taking screenshots");
			System.out.println(e.getMessage());
		}

	}
	@AfterClass
	public void shutDown()
	{
		//driver.quit();
	}

}

