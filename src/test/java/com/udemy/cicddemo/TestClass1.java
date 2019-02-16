package com.udemy.cicddemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {
    public static WebDriver driver;
    @BeforeMethod
	public void launchDriver()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\MyStudies\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().fullscreen();
	}
    @Test
    public void test1() {
    	driver.navigate().to("https://www.google.com");
    	System.out.println("Test 1 Title is : "+driver.getTitle());
    }
    
    @Test
    public void test2() {
    	driver.navigate().to("https://www.google.com");
    	System.out.println("Test 2 Title is : "+driver.getTitle());	
    }
    
    @Test
    public void test3() {
    	driver.navigate().to("https://www.google.com");
    	System.out.println("Test 3 Title is : "+driver.getTitle());
}
    @AfterMethod
    public void quit()
    {driver.quit();
    	
    }
}
