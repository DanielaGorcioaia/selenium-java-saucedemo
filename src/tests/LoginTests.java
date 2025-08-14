package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testdata.classes.User;
import testdata.pages.Login;
import testdata.pages.Products;
import utils.RandomGenerator;

public class LoginTests extends BaseTest {

	@Test 

	public void validLoginLogoutStandardUser() {
		loginPage.autheticate(standardUser);
		Assert.assertEquals(Products.TITLE, productsPage.getTitlePageText());

		headerPage.logout();
		Assert.assertEquals(Login.HEADER, loginPage.getHeaderText());
	}

	@Test 

	public void invalidLoginMissingUsername() {
		User user = standardUser;
		user.setUsername("");

		loginPage.autheticate(user);
		Assert.assertEquals(Login.ERROR_USER_MISSING, loginPage.getErrorText());
	}

	@Test 

	public void invalidLoginMissingPassword() {
		User user = standardUser;
		user.setPassword("");

		loginPage.autheticate(user);
		Assert.assertEquals(Login.ERROR_PASSWORD_MISSING, loginPage.getErrorText());
	}

	@Test 
	
	public void invalidLoginUserNotInDB() {
		User user = standardUser;
		user.setUsername(RandomGenerator.stringValue(9));
		user.setPassword(RandomGenerator.stringValue(9));

		loginPage.autheticate(user);
		Assert.assertEquals(Login.ERROR_USER_NOT_IN_DB, loginPage.getErrorText());
	}

	@Test 

	public void invalidLoginLockedOutUser() {
		loginPage.autheticate(lockedoutUser);
		Assert.assertEquals(Login.ERROR_LOCKED_OUT, loginPage.getErrorText());
	}
}
