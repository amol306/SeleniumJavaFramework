package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemoBasic {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// http://extentreports.com/docs/versions/3/java/#basic-example
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest testReport = extent.createTest("GoogleTest", "Sample Google Test description");

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://google.com");

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

		// calling flush writes everything to the log file
		extent.flush();

		driver.close();
		driver.quit();

	}

}
