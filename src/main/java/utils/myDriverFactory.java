package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myDriverFactory{
	
	private static WebDriver driver = null;
	
	public myDriverFactory() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "C:/all-driver/chromedriver.exe");
	}
	public static WebDriver getDriver() {
		
		if(driver==null) {
			
			driver = BrowserInitSetup();
		}
		
		return driver;
	}
	
	
	private static WebDriver BrowserInitSetup() {
		System.setProperty("webdriver.chrome.driver", "C:/all-driver/chromedriver.exe");
		System.out.println("Browser initialization");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
}
