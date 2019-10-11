package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	

	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/InternetExplorer.exe");
			driver=new InternetExplorerDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.Chrome.driver","./Drivers/ChromeDriverServer.exe");
			driver=new ChromeDriver();
		}
		else 
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
		
	}
	

}
