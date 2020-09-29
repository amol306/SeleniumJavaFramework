package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	private static WebElement element = null;
	
	public static WebElement TextboxSearch(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;		
	}
	
	public static WebElement ButtonSearch(WebDriver driver) {
		element = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		return element;		
	}

}
