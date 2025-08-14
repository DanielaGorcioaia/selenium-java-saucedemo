package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {

	WebDriver driver;

	public YourCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By pageTitle = By.xpath("//span[@class=\"title\"]");

	By continueShoppingButton = By.id("continue-shopping");
	By checkoutButton = By.id("checkout");

	By itemNames = By.xpath("//div[@class=\"inventory_item_name\"]");
	By itemPrices = By.xpath("//div[@class=\"inventory_item_price\"]");
	By itemDescriptions = By.xpath("//div[@class=\"inventory_item_desc\"]");
	By itemLocators = By.xpath("//div[@class=\"cart_item\"]");

	By removeButton = By.xpath("//button[contains(text(),\"Remove\")]");
	By removeCartItemLocator = By.xpath("//div[@class=\"removed_cart_item\"]");

	// actions
	public boolean isPageTitleDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}

	public String getTitlePageText() {
		return driver.findElement(pageTitle).getText();
	}

	public boolean isContinueShoppingButtonDisplayed() {
		return driver.findElement(continueShoppingButton).isDisplayed();
	}

	public void clickContinueShoppingButton() {
		driver.findElement(continueShoppingButton).click();
	}

	public boolean isCheckoutButtonDisplayed() {
		return driver.findElement(checkoutButton).isDisplayed();
	}

	public void clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
	}

	public boolean isNameInTheTable(String name) {
		List<WebElement> names = driver.findElements(itemNames);
		boolean reply = false;
		for (WebElement elem : names) {
			String elemText = elem.getText();
			if (elem.getText().equals(name)) {
				reply = true;
			}
		}
		return reply;
	}

	public boolean areNameDescriptionAndPriceOnSameItem(String name, String Description, String Price) {
		List<WebElement> items = driver.findElements(itemLocators);
		boolean reply = false;
		for (WebElement elem : items) {
			String elemText = elem.getText();
			if ((elemText.contains(Description)) && (elemText.contains(Price)) && (elemText.contains(name))) {
				reply = true;
			}
		}
		return reply;
	}

	public boolean wasAnItemRemoved() {
		return driver.findElement(removeCartItemLocator).isEnabled();
	}

	public boolean isRemoveButtonDisplayed() {
		return driver.findElement(removeButton).isDisplayed();
	}

	public void clickRemoveButton() {
		driver.findElement(removeButton).click();
	}
	
	public boolean isItemNameDisplayed() {
	    List<WebElement> names = driver.findElements(itemNames);
	    if (names.isEmpty()) {
	        return false;
	    }
	    return names.get(0).isDisplayed();
	}

	public String getItemName() {
		return driver.findElement(itemNames).getText();
	}

	public boolean isItemDescriptionDisplayed() {
	    List<WebElement> descriptions = driver.findElements(itemDescriptions);
	    if (descriptions.isEmpty()) {
	        return false;
	    }
	    return descriptions.get(0).isDisplayed();
	}
	public String getItemDescription() {
		return driver.findElement(itemDescriptions).getText();
	}

	public boolean isItemPriceDisplayed() {
	    List<WebElement> prices = driver.findElements(itemPrices);
	    if (prices.isEmpty()) {
	        return false;
	    }
	    return prices.get(0).isDisplayed();
	}
	

	public String getItemPrice() {
		return driver.findElement(itemPrices).getText();
	}

	public double transformPriceInDoubleValue(String price) {
		String newPrice = price.substring(1);
		return Double.parseDouble(newPrice);
	}

	

}
