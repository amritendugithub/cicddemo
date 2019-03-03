package com.udemy.cicddemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {
    public static WebDriver driver;
    
    // Below 3 line for Browserstack remote driver setup variable 
    public static final String USERNAME = "amritendu1";
    public static final String AUTOMATE_KEY = "fzLvAxx7skHGGjq9PEhV";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    
    @BeforeMethod
	/*public void launchDriver()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\MyStudies\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().fullscreen();
	}*/
    
    
    // Accessing Selenium Grid Hub by using Node for chrome driver
   
    /*
     Start Selenium Grid Hub, Go To command prompt and execute below:
     java -jar selenium-server-standalone-3.141.59.jar -role hub
    */
    
    /* 
     Registered node with chrome driver and connect node to Selenium Grid hub, Go to another command prompt and execute below:
     java -Dwebdriver.chrome.driver="C:\MyStudies\Selenium\drivers\chromedriver_win32\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.0.25:4444/grid/register/ -port 5566
     */
    
    public void launchDriver() throws MalformedURLException
	{
    
    	/*
    DesiredCapabilities dr = null;
    
    dr = DesiredCapabilities.chrome();
    dr.setBrowserName("chrome");
    dr.setPlatform(Platform.WIN10);
    
	System.setProperty("webdriver.chrome.driver", "C:\\MyStudies\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");	
	
	driver = new RemoteWebDriver(new URL("http://192.168.0.25:4444/wd/hub"), dr);
	*/
    	
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "60.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("project", "CICD Demo Project");
    caps.setCapability("build", "Build 1.1");
    caps.setCapability("name", "BrowserTitleTest");
    caps.setCapability("resolution", "1024x768");
    driver = new RemoteWebDriver(new URL(URL), caps);

	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	//driver.manage().window().fullscreen();
	
	}
    
  
    @Test
    public void test1() {
    	driver.navigate().to("https://www.google.com");
    	System.out.println("Test 1 Title is : "+driver.getTitle());
    }
    
    @Test
    public void test2() {
    	driver.navigate().to("https://www.yahoo.com");
    	System.out.println("Test 2 Title is : "+driver.getTitle());	
    }
    
    @Test
    public void test3() {
    	driver.navigate().to("https://www.apple.com");
    	System.out.println("Test 3 Title is : "+driver.getTitle());
}
    @AfterMethod
    public void quit()
    {driver.quit();
    	
    }
}
