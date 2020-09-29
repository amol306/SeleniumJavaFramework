package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTestNG {
	private static WebDriver driver = null;

	@BeforeTest
	public void SetupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}

	@Test
	public static void GoogleSearchTest() {
		GoogleSearchPageObjects obj = new GoogleSearchPageObjects(driver);
		obj.setTextinSearchBox("SDET");
		obj.clickSearchButton();
	}

	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
