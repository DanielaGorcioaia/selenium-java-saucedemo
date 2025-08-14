package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OneProductPage {

	WebDriver driver;

	public OneProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
    By backButton = By.id("back-to-products");
	By addToCartButton = By.id("add-to-cart");
	By removeButton = By.xpath("//button[@name=\"remove\"]");

	By itemName = By.xpath("//div[@data-test=\"inventory-item-name\"]");
	By itemDescription = By.xpath("//div[@data-test=\"inventory-item-desc\"]");
	By itemPrice = By.xpath("//div[@data-test=\"inventory-item-price\"]");

	// actions
	
	public boolean isBackButtonDisplayed() {
		return driver.findElement(backButton).isDisplayed();
	}

	public void clickBackButton() {
		driver.findElement(backButton).click();
	}

	public boolean isAddToCartButtonDisplayed() {
		return driver.findElement(addToCartButton).isDisplayed();
	}

	public void clickAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}


	public boolean isRemoveButtonDisplayed() {
		return driver.findElement(removeButton).isDisplayed();
	}

	public void clickRemoveButton() {
		driver.findElement(removeButton).click();
	}

	public boolean isItemNameDisplayed() {
		return driver.findElement(itemName).isDisplayed();
	}

	public String getItemName() {
		return driver.findElement(itemName).getText();
	}

	public boolean isItemDescriptionDisplayed() {
		return driver.findElement(itemDescription).isDisplayed();
	}

	public String getItemDescription() {
		return driver.findElement(itemDescription).getText();
	}

	public boolean isItemPriceDisplayed() {
		return driver.findElement(itemPrice).isDisplayed();
	}

	public String getItemPrice() {
		return driver.findElement(itemPrice).getText();
	}

	public double transformPriceInDoubleValue(String price) {
		String newPrice = price.substring(1);
		return Double.parseDouble(newPrice);
	}

}
