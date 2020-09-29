package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		HeadlessChrome();
		driver.quit();
	}

	public static void HeadlessChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1280,800");
		driver = new ChromeDriver(options);

		System.out.println("Headless Test started!");
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("SDET");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		driver.close();
		System.out.println("Test completed!");
	}

}
