package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		SeleniumWaits();
		driver.quit();
	}

	public static void SeleniumWaits() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // default polling time 500 milliseconds
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("SDET");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);

		WebDriverWait newWait = new WebDriverWait(driver, 30);
		WebElement ele = newWait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		ele.click();
		
		driver.close();
	}
}
