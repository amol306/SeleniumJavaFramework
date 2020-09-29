package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo2 {
	private static WebDriver driver = null;

	@BeforeTest
	public void SetupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public static void GoogleSearchTest2() {
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
	}

	@Test
	public static void GoogleSearchTest3() {
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Auto Test");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
