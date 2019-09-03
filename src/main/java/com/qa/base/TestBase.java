package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		properties.load(fis);
	}
	
	public static void initialisation() {
		
		WebDriverManager.chromedriver().setup();
		
		// This line is for browser 
		driver = new ChromeDriver();
		
		// below code is for headless browser
		/*ChromeOptions options = new ChromeOptions();		
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.setExperimentalOptions("useAutomationExtension", false);
		options.addArguments("--proxy-server='direct://'");
		options.addArguments("--proxy-bypass-list=*");
		options.addArguments("--start-maximized");
		options.addArguments("--headless");	 
		driver = new ChromeDriver(options);*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));
	}

}
