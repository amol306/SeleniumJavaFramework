package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	WebDriver driver = null;

	By txtSearch = By.name("q");
	By btnSearch = By.xpath("(//input[@name='btnK'])[2]");

	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextinSearchBox(String text) {
		driver.findElement(txtSearch).sendKeys(text);
	}

	public void clickSearchButton() {
		driver.findElement(btnSearch).sendKeys(Keys.RETURN);
	}
}
