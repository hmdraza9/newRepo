package SeleniumTestSuit.NewSeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.PropertyReaderClass;
import utils.myDriverFactory;

public class testBase {

	static WebDriver driver;
	public static ChromeOptions co;
	public static PropertyReaderClass pr;
	public DesiredCapabilities cap = null;

	public WebDriver BrowserInitSetup() {
		driver = getDriver();
		return driver;

	}

	public static WebDriver getDriver() {

		return myDriverFactory.getDriver();
	}

	public void BrowserQuit() {

		System.out.println("BrowserQuit - Driver: " + driver);
		getDriver().quit();
	}

}