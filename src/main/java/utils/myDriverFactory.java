package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


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
        System.out.println("Browser initialization");
        try {
			if(driver==null){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;
	}
}
