package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemoTestNG {
	private static WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void setup() {
		// http://extentreports.com/docs/versions/3/java/#testng-examples
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extentReportTestNG1.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void Test1() {
		driver.get("https://google.com");

		// creates a toggle for the given test, adds all log events under it
		ExtentTest testReport = extent.createTest("Google Test 1", "Sample Google Test description");
		// log(Status, details)
		testReport.log(Status.INFO, "This step shows usage of log(status, details)");

		driver.findElement(By.name("q")).sendKeys("Auto Test");
		testReport.pass("Entered Text");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		testReport.pass("Button click");

		// info(details)
		testReport.info("This step shows usage of info(details)");

		// log with snapshot
		try {
			testReport.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test with snapshot
		try {
			testReport.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Test2() {
		driver.get("https://google.com");
		// creates a toggle for the given test, adds all log events under it
		ExtentTest testReport = extent.createTest("Google Test 2", "Sample Google Test description");
		// log(Status, details)
		testReport.log(Status.INFO, "This step shows usage of log(status, details)");

		driver.findElement(By.name("q")).sendKeys("Auto Test");
		testReport.pass("Entered Text");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		testReport.fail("Fail Test");

		// info(details)
		testReport.info("This step shows usage of info(details)");

		// log with snapshot
		try {
			testReport.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test with snapshot
		try {
			testReport.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}

	@AfterSuite
	public void tearDown() {
		// calling flush writes everything to the log file
		extent.flush();
	}

}
