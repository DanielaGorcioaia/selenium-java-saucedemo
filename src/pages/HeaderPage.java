package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {


	WebDriver driver;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators

	By logoHeader = By.xpath("div[@class=\"app_logo\"]");
	By menuButton = By.xpath("//div[@id=\"menu_button_container\"]/div/div[1]/div[1]/button");
	By logoutOption = By.id("logout_sidebar_link");
	
	By shoppingCart = By.id("shopping_cart_container");
	By shoppingBadge = By.xpath("//span[@class=\"shopping_cart_badge\"]");

	//actions
	public boolean isLogoHeaderDisplayed() {
		return driver.findElement(logoHeader).isDisplayed();
	}

	public String getLogoHeaderText() {
		return driver.findElement(logoHeader).getText();
	}

	public boolean isMenuButtonDisplayed() {
		return driver.findElement(menuButton).isDisplayed();
	}

	public void clickMenuButton() {
		driver.findElement(menuButton).click();
	}

	public boolean isShoppingCartDisplayed() {
		return driver.findElement(shoppingCart).isDisplayed();
	}

	public void clickShoppingCart() {
		driver.findElement(shoppingCart).click();
	}

	public boolean isLogoutOptionDisplayed() {
		return driver.findElement(logoutOption).isDisplayed();
	}

	public void clickLogoutOption() {
		driver.findElement(logoutOption).click();
	}

	public void logout() {
		clickMenuButton();
		clickLogoutOption();
	}
	
	public boolean isShoppingBadgeDisplayed() {
	    List<WebElement> badges = driver.findElements(shoppingBadge);
	    if (badges.isEmpty()) {
	        return false;
	    }
	    return badges.get(0).isDisplayed();
	}

	public String shoppingBadgeString() {
		return driver.findElement(shoppingBadge).getText();
	}
	
	public int numberOfItemsInCart() {
		int number = 0;
		if (isShoppingBadgeDisplayed()) {
			number = Integer.parseInt(shoppingBadgeString());
		}
		return number;
	}
	


	

}
