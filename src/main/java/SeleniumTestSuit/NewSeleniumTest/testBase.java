package SeleniumTestSuit.NewSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class testBase 
{
	
	public static WebDriver driver;
	public static ChromeOptions co;
	public static PropertyReaderClass pr;
	
    public static void BrowserInitSetup() throws InterruptedException {
    	co = new ChromeOptions();
//    	co.addArguments("--headless");
    	System.out.println("Url test, Before Test, Browser initialization");
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
//		driver.get("http://www.demo.guru99.com/v4/");
    	Thread.sleep(2000);
    }

    public void BrowserQuit() {
    	System.out.println("Url test, After Test, Browser closing");
    	driver.quit();
    }
    


    public static void openGoogle() {
		driver.get("https://www.google.co.in/");
    	System.out.println(driver.getTitle());
    	System.out.println("Element found: "+driver.findElements(By.name("q")).size());
    }

    public static void openYahoo() {
		driver.get("https://in.yahoo.com/?p=us");
    	System.out.println(driver.getTitle());
    	System.out.println("Element found: "+driver.findElements(By.name("p")).size());
    }

    public static void openInDotCom() {
		driver.get("https://www.news18.com/entertainment/");
    	System.out.println(driver.getTitle());
    	System.out.println("Element found: "+driver.findElements(By.name("viewport")).size());
    }

    public static void openToolsQA() {
		driver.get("https://www.toolsqa.com/");
    	System.out.println(driver.getTitle());
    	System.out.println("Element found: "+driver.findElements(By.name("theme-color")).size());
    }

    public static void openGuru99demo() {
		driver.get("http://www.demo.guru99.com/v4/");
    	System.out.println(driver.getTitle());
    	System.out.println("Element found: "+driver.findElements(By.name("uid")).size());
    }
	

    public void AfterClassMethod() {
    	System.out.println("Url test, AfterClass");
    }

    public void beforeClassMethod() {
    	System.out.println("Url test, BeforeClass");
    }
}