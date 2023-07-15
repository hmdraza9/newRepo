package extentReposClass;

import org.testng.annotations.BeforeMethod;

public class ExtentReportingClass {

	public ExtentReportingClass() {
		System.out.println("Extent class called");
	}
	
	@BeforeMethod
	public void anotherB4Test() {
		
		System.out.println("ExtentReportingClass @BeforeMethod method");
		
	}
	
	
}
