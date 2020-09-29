package demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabsDemo {
	private static WebDriver driver = null;
	public static final String username = "amol306";
	public static final String accesskey = "8850d60d-6e50-4c30-abae-22b2fe0e478d";
	public static final String URL = "https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {
		SauceLabsTest();
		driver.quit();
	}

	public static void SauceLabsTest() throws Exception {
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "windows 10");
		cap.setCapability("version", "latest");
		cap.setCapability("name", "GoogleTest");
		cap.setCapability("extendedDebugging", "true");

		// driver = new ChromeDriver();
		driver = new RemoteWebDriver(new java.net.URL(URL), cap);

		driver.get("https://google.com");
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("SDET");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		driver.close();
		System.out.println("Test completed!");
	}

}
