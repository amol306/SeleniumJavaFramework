import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	private static WebDriver driver;

	public static void main(String[] args) {
		// before WebDriverManager, driver exe path should be set as JVM properties
		// Alternately you can add browser driver path to System environment variable
		// "PATH", then you dont need to set below JVM property
		System.setProperty("webdriver.gecko.driver", "src/test/resources/BrowserDrivers/geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "src/test/resources/BrowserDrivers/chromedriver.exe");
		// System.setProperty("webdriver.ie.driver",
		// "src/test/resources/BrowserDrivers/IEDriverServer.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.close();

		// after WebDriverManager, WebDriverManager do driver management for you
		// https://github.com/bonigarcia/webdrivermanager
		// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Xpath Text");
		driver.close();
		driver.quit();
	}
}
