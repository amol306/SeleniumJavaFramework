package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGMultiBrowserDemo {
	private static WebDriver driver;

	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		System.out.println("Browser Name : " + browserName);
		System.out.println("Thread# : " + Thread.currentThread().getId());
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("i")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
	}

	@Test
	public void Test1() throws Exception {
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		Thread.sleep(10000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed!");
	}
}
