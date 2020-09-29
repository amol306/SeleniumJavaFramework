import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities_Demo {
	private static WebDriver driver;

	public static void main(String[] args) {

		// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/DesiredCapabilities.html
		// https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
		// https://help.crossbrowsertesting.com/faqs/testing/why-do-i-get-the-message-use-of-desiredcapabilities-has-been-deprecated-in-c/
		InternetExplorerOptions caps = new InternetExplorerOptions();
		caps.setCapability("ignoreProtectedModeSettings", true);

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver(caps);

		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);

		driver.close();
		driver.quit();

	}

}
