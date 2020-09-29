package listeners;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	private static WebDriver driver;

	@Test
	public void Test1() {
		System.out.println("inside Test 1");
	}

	@Test
	public void Test2() {
		System.out.println("inside Test 2");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("//input[@name='qabc']")).sendKeys("Xpath Text");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
	}

	@Test
	public void Test3() {
		System.out.println("inside Test 3");
	}

}
