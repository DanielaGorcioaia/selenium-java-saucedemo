package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import testdata.classes.Product;
import testdata.pages.Products;

public class SortingTests extends BaseTest {

	@Test
	public void sortingTest() throws InterruptedException{

		loginPage.autheticate(standardUser);
		Assert.assertEquals(Products.TITLE, productsPage.getTitlePageText());
		
		List <Product> sortedListAZ = productsPage.sortingListByNameAZ(productsPage.currentList());
		productsPage.clickOptionSortingNameAZ();
		Assert.assertTrue(productsPage.compareLists(sortedListAZ, productsPage.currentList()));
		
	    List <Product> sortedtListZA = productsPage.sortingListByNameZA(productsPage.currentList());
		productsPage.clickOptionSortingNameZA();
		Assert.assertTrue(productsPage.compareLists(sortedtListZA, productsPage.currentList()));
		
		List <Product> sortedListLowToHigh = productsPage.sortingListByPriceLowToHigh(productsPage.currentList());
		productsPage.clickOptionSortingPriceLowToHigh();
	    Assert.assertTrue(productsPage.compareLists(sortedListLowToHigh, productsPage.currentList()));

		List <Product> sortedListHighToLow = productsPage.sortingListByPriceHighToLow(productsPage.currentList());
		productsPage.clickOptionSortingPriceHighToLow();
	    Assert.assertTrue(productsPage.compareLists(sortedListHighToLow, productsPage.currentList()));	
	}
}