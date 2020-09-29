package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		GoogleSearch();
		driver.quit();
	}

	public static void GoogleSearch() {
		// String projectPath = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver",
		// projectPath + "/src/test/resources/BrowserDrivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		GoogleSearchPage.TextboxSearch(driver).sendKeys("SDET");
		GoogleSearchPage.ButtonSearch(driver).sendKeys(Keys.RETURN);
		driver.close();
	}
}
