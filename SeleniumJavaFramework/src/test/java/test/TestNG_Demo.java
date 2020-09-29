package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.propertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {
	private static WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void SetupTest() {
		try {
			propertiesFile.getProperties();
			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} catch (Exception ex) {

		}
	}

	@Test
	public static void GoogleSearchTest() {
		try {
			driver.get("http://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("Auto Test");
			driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
			propertiesFile.setProperties("result", "PASS");
		} catch (Exception ex) {
			propertiesFile.setProperties("result", "FAIL");
		}
	}

	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
