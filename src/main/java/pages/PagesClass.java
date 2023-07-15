package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.myDriverFactory;

public class PagesClass {
	static WebDriver driver;

	public PagesClass(WebDriver driver) {
		PagesClass.driver = driver;
		PagesClass.driver = myDriverFactory.getDriver();
	}

	public void openGoogle() {
		driver.get("https://www.google.co.in/");
		System.out.println("driver.getTitle: " + driver.getTitle());
		System.out.println("Element found: " + driver.findElements(By.name("q")).size());
	}

	public void openYahoo() {
		System.out.println("Driver: "+driver);
		myDriverFactory.getDriver().get("https://in.yahoo.com/?p=us");
		System.out.println("driver.getTitle: " + driver.getTitle());
		System.out.println("Element found: " + driver.findElements(By.name("p")).size());
	}

	public void openInDotCom() {
		driver.get("https://www.news18.com/entertainment/");
		System.out.println("driver.getTitle: " + driver.getTitle());
		System.out.println("Element found: " + driver.findElements(By.name("viewport")).size());
	}

	public void openToolsQA() {
		System.out.println("Driver: "+driver);
		driver.get("https://www.toolsqa.com/");
		System.out.println("driver.getTitle: " + driver.getTitle());
		System.out.println("Element found: " + driver.findElements(By.name("theme-color")).size());
	}

	public void openGuru99demo() {
		driver.get("http://www.demo.guru99.com/v4/");
		System.out.println("driver.getTitle: " + driver.getTitle());
		System.out.println("Element found: " + driver.findElements(By.name("uid")).size());
	}

}
