package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import testdata.classes.Product;
import testdata.pages.Checkout;
import testdata.pages.CheckoutOverview;
import testdata.pages.Products;
import testdata.pages.ThankYou;
import testdata.pages.YourCart;

public class EndToEndTest extends BaseTest{

    @Test 
    public void fullPurchaseFlowTest() {
    	
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

		yourCartPage.clickCheckoutButton();
		checkoutPage.submitInfo(validInfoClient);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
  
		Assert.assertEquals(oneItem.getName(), checkoutOverviewPage.getItemName());
		Assert.assertEquals(oneItem.getDescription(), checkoutOverviewPage.getItemDescription());
		Assert.assertEquals(oneItem.getPrice(), checkoutOverviewPage.getItemPrice());
		
		Assert.assertEquals(CheckoutOverview.PAYMENT_INFO_VALUE, checkoutOverviewPage.getPaymentInfo());
		Assert.assertEquals(CheckoutOverview.SHIPPING_INFO_VALUE, checkoutOverviewPage.getShippingInfo());
		Assert.assertTrue(checkoutOverviewPage.areEqual(checkoutOverviewPage.calculateTotalPriceByItemPrice(oneItem.getPrice()),checkoutOverviewPage.getTotalPrice()));
 
		Assert.assertTrue(checkoutOverviewPage.isFinishButtonDisplayed());
		checkoutOverviewPage.clickFinishButton();
		
		Assert.assertFalse(headerPage.isShoppingBadgeDisplayed());
		Assert.assertEquals(0, headerPage.numberOfItemsInCart());
		
		Assert.assertEquals(ThankYou.TITLE, thankYouPage.getTitlePageText());
		Assert.assertEquals(ThankYou.COMPLETE_HEADER, thankYouPage.getCompleteHeader());
		Assert.assertEquals(ThankYou.COMPLETE_TEXT, thankYouPage.getCompleteText());

    }
	
	
}
