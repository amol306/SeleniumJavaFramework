package demo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {
	// Sample test in Java to run Automate session.

	public static final String AUTOMATE_USERNAME = "amoljagtap3";
	public static final String AUTOMATE_ACCESS_KEY = "uM5TxKQS5SUp8VJzTWKq";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "14");
		caps.setCapability("device", "iPhone 11");
		caps.setCapability("real_mobile", "true");
		caps.setCapability("name", "GoogleTest");
		caps.setCapability("browserstack.appium_version", "1.18.0");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.console", "info");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
