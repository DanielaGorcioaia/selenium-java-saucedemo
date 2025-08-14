package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {

	WebDriver driver;

	public ThankYouPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By pageTitle = By.xpath("//span[@class=\"title\"]");
	
	By headerComplete = By.xpath("//h2[@data-test=\"complete-header\"]");
	By textComplete = By.xpath("//div[@data-test=\"complete-text\"]");

			

	// actions

	public boolean isPageTitleDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}

	public String getTitlePageText() {
		return driver.findElement(pageTitle).getText();
	}
	
	public String getCompleteHeader() {
		return driver.findElement(headerComplete).getText();
	}
	
	public String getCompleteText() {
		return driver.findElement(textComplete).getText();
	}

}
