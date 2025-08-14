package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

	WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By pageTitle = By.xpath("//span[@class=\"title\"]");

	By itemName = By.xpath("//div[@data-test=\"inventory-item-name\"]");
	By itemDescription = By.xpath("//div[@data-test=\"inventory-item-desc\"]");
	By itemPrice = By.xpath("//div[@data-test=\"inventory-item-price\"]");

	By paymentInfo = By.xpath("//div[@data-test=\"payment-info-value\"]");
	By shippingInfo = By.xpath("//div[@data-test=\"shipping-info-value\"]");

	By totalPriceLabel = By.xpath("//div[@data-test=\"total-label\"]");
	By finishButton = By.id("finish");

	// actions
	public boolean isPageTitleDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}

	public String getTitlePageText() {
		return driver.findElement(pageTitle).getText();
	}

	public boolean isItemNameDisplayed() {
		return driver.findElement(itemName).isDisplayed();
	}

	public boolean isItemPriceDisplayed() {
		return driver.findElement(itemDescription).isDisplayed();
	}

	public boolean IsItemPriceDisplayed() {
		return driver.findElement(itemPrice).isDisplayed();
	}

	public String getItemName() {
		return driver.findElement(itemName).getText();
	}

	public String getItemDescription() {
		return driver.findElement(itemDescription).getText();
	}

	public String getItemPrice() {
		return driver.findElement(itemPrice).getText();
	}

	public double transformPriceInDoubleValue(String price) {
		String newPrice = price.substring(1);
		return Double.parseDouble(newPrice);
	}

	public String getPaymentInfo() {
		return driver.findElement(paymentInfo).getText();
	}

	public String getShippingInfo() {
		return driver.findElement(shippingInfo).getText();
	}

	public double getTotalPrice() {
		String totalPrice = driver.findElement(totalPriceLabel).getText().substring(8);
		return Double.parseDouble(totalPrice);
	}
	
	public double calculateTotalPriceByItemPrice(String price) {
		double tax = ((transformPriceInDoubleValue(price)+0.01)*8)/100;
		return transformPriceInDoubleValue(price)+tax;
	}
	
	public boolean areEqual(double a, double b) {
		if (a==b) {return true;}
		else return false;
		}
	
	public boolean isFinishButtonDisplayed() {
		return driver.findElement(finishButton).isDisplayed();
	}
	
	public void clickFinishButton() {
		driver.findElement(finishButton).click();
	}
	}


