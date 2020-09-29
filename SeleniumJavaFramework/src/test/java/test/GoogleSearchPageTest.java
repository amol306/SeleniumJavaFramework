package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		GoogleSearchTest();
	}

	public static void GoogleSearchTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://google.com");
		GoogleSearchPageObjects obj = new GoogleSearchPageObjects(driver);
		obj.setTextinSearchBox("SDET");
		obj.clickSearchButton();
		driver.close();
		driver.quit();
	}

}
