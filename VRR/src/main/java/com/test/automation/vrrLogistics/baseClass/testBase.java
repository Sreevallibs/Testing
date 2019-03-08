package com.test.automation.vrrLogistics.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testBase {
	public static WebDriver driver;
	File file;
	public Properties OR=new Properties();
	
	
	public void init() throws IOException  
	{
		loadData();
		System.out.println(OR);
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}
	
	public void loadData() throws IOException 
	{
		file=new File("C:\\Users\\info00011\\eclipse-workspace\\VRR\\src\\main\\java\\com\\test\\automation\\vrrLogistics\\config\\config.properties"); 
		FileInputStream out= new FileInputStream(file);
		OR.load(out);
		
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\info00011\\eclipse-workspace\\VRR\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\info00011\\eclipse-workspace\\VRR\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	public void getUrl(String url)
	{
		driver.get(url);
	}

}
