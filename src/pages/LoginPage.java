package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testdata.classes.User;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators

	By usernameInput = By.id("user-name");
	By passwordInput = By.id("password");

	By headerLogin = By.xpath("//div[@class=\"login_logo\"]");
	By loginButton = By.id("login-button");

	By errorLabel = By.xpath("//h3[@data-test=\"error\"]");

	// actions

	public boolean isLoginButtonDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void enterUsername(String userName) {
		driver.findElement(usernameInput).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public boolean isHeaderDisplayed() {
		return driver.findElement(headerLogin).isDisplayed();
	}

	public String getHeaderText() {
		return driver.findElement(headerLogin).getText();
	}

	public boolean isErrorDisplayed() {
		return driver.findElement(errorLabel).isDisplayed();
	}

	public String getErrorText() {
		return driver.findElement(errorLabel).getText();
	}

	public void autheticate(User user) {
		enterUsername(user.getUsername());
		enterPassword(user.getPassword());
		clickLoginButton();
	}
}
