package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testdata.classes.Item;
import testdata.classes.Product;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By pageTitle = By.xpath("//span[@class=\"title\"]");
	By selectContainer = By.xpath("//select[@class=\"product_sort_container\"]");

	By itemNames = By.xpath("//div[@class=\"inventory_item_name \"]");
	By itemDescriptions = By.xpath("//div[@class=\"inventory_item_desc \"]");
	By itemPrices = By.xpath("//div[@class=\"inventory_item_price \"]");
	By buttonsLocator = By.xpath("//button");

	// actions
	public boolean isPageTitleDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}

	public String getTitlePageText() {
		return driver.findElement(pageTitle).getText();
	}

	public boolean isSelectContainerDisplayed() {
		return driver.findElement(selectContainer).isDisplayed();
	}

	public void clickSelectContainer() {
		driver.findElement(selectContainer).click();
	}

	public void clickItemName(String itemName) {
		List<WebElement> items = driver.findElements(itemNames);
		for (WebElement elem : items) {
			String elemText = elem.getText();
			if (elemText.equals(itemName)) {
				elem.click();
				break;
			}
		}
	}

	public boolean noRemoveButtonDisplayed() {
		boolean reply = true;
		List<WebElement> buttons = driver.findElements(buttonsLocator);
		for (WebElement b : buttons) {
			if (b.getText().contains("Remove")) {
				reply = false;
			}
		}
		return reply;
	}

	public double transformPriceInDoubleValue(String price) {
		String newPrice = price.substring(1);
		return Double.parseDouble(newPrice);
	}

	public List<Product> currentList() {

		List<Product> products = new ArrayList<Product>();
		String text1 = null;
		String text2 = null;
		String text3 = null;

		for (int i = 1; i < 7; i++) {
			text1 = driver.findElement(By.xpath("//div[@data-test=\"inventory-item\"][" + i + "]/div[2]/div[1]/a/div")).getText();
			text2 = driver.findElement(By.xpath("//div[@data-test=\"inventory-item\"][" + i + "]/div[2]/div[1]/div")).getText();
			text3 = driver.findElement(By.xpath("//div[@data-test=\"inventory-item\"][" + i + "]/div[2]/div[2]/div")).getText();

			Product product = new Product(text1, text2, transformPriceInDoubleValue(text3));
			products.add(product);
		}
		return products;
	}

	public void clickOptionSortingNameAZ() {
		Select classicSelect = new Select(driver.findElement(selectContainer));
		classicSelect.selectByIndex(0);
	}

	public void clickOptionSortingNameZA() {
		Select classicSelect = new Select(driver.findElement(selectContainer));
		classicSelect.selectByIndex(1);
	}

	public void clickOptionSortingPriceLowToHigh() {
		Select classicSelect = new Select(driver.findElement(selectContainer));
		classicSelect.selectByIndex(2);
	}

	public void clickOptionSortingPriceHighToLow() {
		Select classicSelect = new Select(driver.findElement(selectContainer));
		classicSelect.selectByIndex(3);
	}

	public List<Product> sortingListByNameAZ(List<Product> list) {
		Product temp;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				String name1 = list.get(i).getName();
				String name2 = list.get(j).getName();

				if (name1.compareTo(name2) > 0) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	public List<Product> sortingListByNameZA(List<Product> list) {
		Product temp;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				String name1 = list.get(i).getName();
				String name2 = list.get(j).getName();

				if (name1.compareTo(name2) < 0) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
	
	public List<Product> sortingListByPriceLowToHigh(List <Product> list){
		Product temp;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				double price1 = list.get(i).getPrice();
				double price2 = list.get(j).getPrice();

				if (price1>price2) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}		
		return list;
	}
	
	public List<Product> sortingListByPriceHighToLow(List <Product> list){
		Product temp;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				double price1 = list.get(i).getPrice();
				double price2 = list.get(j).getPrice();

				if (price1<price2) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}		
		return list;
	}


	public boolean compareLists(List<Product> list1, List<Product> list2) {
		boolean reply = true;
		for (int i = 0; i < list1.size(); i++) {
			Product p1 = list1.get(i);
			Product p2 = list2.get(i);

			if (!p1.getName().equals(p2.getName())) {
				return reply = false;
			}
			if (!p1.getDescription().equals(p2.getDescription())) {
				return reply = false;
			}
			if (p1.getPrice() != p2.getPrice()) {
				return reply = false;
			}
		}
		return reply;

	}

}
