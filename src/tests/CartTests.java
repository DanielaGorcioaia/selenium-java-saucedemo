package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pages.OneProductPage;
import testdata.pages.Products;
import testdata.pages.YourCart;

public class CartTests extends BaseTest {

	@Test 
	public void addAndRemoveItemToCart() {

		loginPage.autheticate(standardUser);
		Assert.assertEquals(Products.TITLE, productsPage.getTitlePageText());

		productsPage.clickItemName(oneItem.getName());
		Assert.assertTrue(oneProductPage.isBackButtonDisplayed());

		Assert.assertEquals(oneItem.getDescription(), oneProductPage.getItemDescription());
		Assert.assertEquals(oneItem.getPrice(), oneProductPage.getItemPrice());

		Assert.assertTrue(oneProductPage.isAddToCartButtonDisplayed());
		oneProductPage.clickAddToCartButton();

		Assert.assertTrue(oneProductPage.isRemoveButtonDisplayed());
		Assert.assertTrue(headerPage.isShoppingBadgeDisplayed());
		Assert.assertEquals(1, headerPage.numberOfItemsInCart());

		headerPage.clickShoppingCart();
		Assert.assertEquals(YourCart.TITLE, yourCartPage.getTitlePageText());

		Assert.assertTrue(yourCartPage.isNameInTheTable(oneItem.getName()));
		Assert.assertEquals(oneItem.getName(), yourCartPage.getItemName());
		Assert.assertEquals(oneItem.getDescription(), yourCartPage.getItemDescription());
		Assert.assertEquals(oneItem.getPrice(), yourCartPage.getItemPrice());
		Assert.assertTrue(yourCartPage.areNameDescriptionAndPriceOnSameItem(oneItem.getName(), oneItem.getDescription(), oneItem.getPrice()));

		Assert.assertTrue(yourCartPage.isRemoveButtonDisplayed());
		yourCartPage.clickRemoveButton();
		
		Assert.assertTrue(yourCartPage.wasAnItemRemoved());
		Assert.assertEquals(0, headerPage.numberOfItemsInCart());
		Assert.assertFalse(headerPage.isShoppingBadgeDisplayed());
		Assert.assertFalse(yourCartPage.isItemNameDisplayed());
		Assert.assertFalse(yourCartPage.isItemDescriptionDisplayed());
		Assert.assertFalse(yourCartPage.isItemPriceDisplayed());
		
		yourCartPage.clickContinueShoppingButton();
		Assert.assertEquals(Products.TITLE, productsPage.getTitlePageText());
		Assert.assertTrue(productsPage.noRemoveButtonDisplayed());
	}

}
