package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testdata.classes.Client;
import utils.RandomGenerator;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	By pageTitle = By.xpath("//span[@class=\"title\"]");
	
	By firstnameInput=By.id("first-name");
	By lastnameInput=By.id("last-name");
	By postalcodeInput=By.id("postal-code");
	
	By cancelButton = By.id("cancel");
	By continueButton = By.id("continue");
	
	By errorMessage=By.xpath("//h3[@data-test=\"error\"]");
	
	//actions
	public boolean isPageTitleDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}

	public String getTitlePageText() {
		return driver.findElement(pageTitle).getText();
	}
	
	public boolean isCancelButtonDisplayed() {
		return driver.findElement(cancelButton).isDisplayed();
	}
	
	public boolean isContinueButtonDisplayed() {
		return driver.findElement(continueButton).isDisplayed();
	}
	
	public void clickCancelButton() {
		driver.findElement(cancelButton).click();
	}
	
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
	
	public void enterFirstname(String firstname) {
		driver.findElement(firstnameInput).sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		driver.findElement(lastnameInput).sendKeys(lastname);
	}
	
	public void enterPostalcode(String postalcode) {
		driver.findElement(postalcodeInput).sendKeys(postalcode);
	}
	
	public void submitInfo(Client client) {
		enterFirstname(client.getFirstname());
		enterLastname(client.getLastname());
		enterPostalcode(client.getPostalcode());
		clickContinueButton();
	}
	
	public boolean isErrorMessageDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public String getErrorText() {
		return driver.findElement(errorMessage).getText();
	}


}
