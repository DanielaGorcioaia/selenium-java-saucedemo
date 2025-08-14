package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testdata.classes.Client;
import testdata.pages.Checkout;
import testdata.pages.CheckoutOverview;
import testdata.pages.Products;
import testdata.pages.YourCart;
import utils.RandomGenerator;

public class CheckoutTests extends BaseTest {

	@Before
	public void before() {
		super.before();
		loginPage.autheticate(standardUser);
		Assert.assertEquals(Products.TITLE, productsPage.getTitlePageText());

		headerPage.clickShoppingCart();
		Assert.assertEquals(YourCart.TITLE, yourCartPage.getTitlePageText());

		yourCartPage.clickCheckoutButton();
		Assert.assertEquals(Checkout.TITLE, checkoutPage.getTitlePageText());

	}

	@Test
	
	public void validInfoRandomValuesWithinRange() {
		checkoutPage.submitInfo(validInfoClient);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test

	public void firstnameLenghtAt00char_InvalidInfo() {
		Client client = validInfoClient;
		client.setFirstname("");

		checkoutPage.submitInfo(client);
		Assert.assertEquals(Checkout.ERROR_MISSING_FIRSTNAME, checkoutPage.getErrorText());
	}

	@Test

	public void firstnameLenghtAt01char_ValidInfo() {
		Client client = validInfoClient;
		client.setFirstname(RandomGenerator.stringValue(1));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());

	}

	@Test

	public void firstnameLenghtAt29char_ValidInfo() {
		Client client = validInfoClient;
		client.setFirstname(RandomGenerator.stringValue(29));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test
	
	public void firstnameLenghtAt30char_ValidInfo() {
		Client client = validInfoClient;
		client.setFirstname(RandomGenerator.stringValue(30));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test

	public void firstnameLenghtAt31char_InvalidInfo() {
		Client client = validInfoClient;
		client.setFirstname(RandomGenerator.stringValue(31));

		checkoutPage.submitInfo(client);
		Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
	}


	@Test
	
	public void lastnameLenghtAt00char_InvalidInfo() {
		Client client = validInfoClient;
		client.setLastname("");

		checkoutPage.submitInfo(client);
		Assert.assertEquals(Checkout.ERROR_MISSING_LASTNAME, checkoutPage.getErrorText());
	}

	@Test
	
	public void lastnameLenghtAt01char_ValidInfo() {
		Client client = validInfoClient;
		client.setLastname(RandomGenerator.stringValue(1));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());

	}

	@Test
	
	public void lastnameLenghtAt29char_ValidInfo() {
		Client client = validInfoClient;
		client.setLastname(RandomGenerator.stringValue(29));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test
	
	public void lastnameLenghtAt30char_ValidInfo() {
		Client client = validInfoClient;
		client.setLastname(RandomGenerator.stringValue(30));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test
	
	public void lastnameLenghtAt31char_InvalidInfo() {
		Client client = validInfoClient;
		client.setLastname(RandomGenerator.stringValue(31));

		checkoutPage.submitInfo(client);
		Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
	}

	@Test
	
	public void postalcodeLenghtAt0char_InvalidInfo() {
		Client client = validInfoClient;
		client.setPostalcode("");

		checkoutPage.submitInfo(client);
		Assert.assertEquals(Checkout.ERROR_MISSING_POSTALCODE, checkoutPage.getErrorText());
	}

	@Test
	
	public void postalcodeLenghtAt1char_ValidInfo() {
		Client client = validInfoClient;
		client.setPostalcode(RandomGenerator.stringValue(1));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());

	}

	@Test
	
	public void postalcodeLenghtAt5char_ValidInfo() {
		Client client = validInfoClient;
		client.setPostalcode(RandomGenerator.stringValue(5));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test
	
	public void postalcodeLenghtAt6char_ValidInfo() {
		Client client = validInfoClient;
		client.setPostalcode(RandomGenerator.stringValue(6));

		checkoutPage.submitInfo(client);
		Assert.assertEquals(CheckoutOverview.TITLE, checkoutOverviewPage.getTitlePageText());
	}

	@Test
	
	public void postalcodeLenghtAt7char_InvalidInfo() {
		Client client = validInfoClient;
		client.setPostalcode(RandomGenerator.stringValue(7));

		checkoutPage.submitInfo(client);
		Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
	}

	
}
