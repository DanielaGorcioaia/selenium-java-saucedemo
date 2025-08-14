package tests;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.OneProductPage;
import pages.ProductsPage;
import pages.ThankYouPage;
import pages.YourCartPage;
import testdata.URL;
import testdata.classes.Client;
import testdata.classes.Item;
import testdata.classes.Product;
import testdata.classes.User;
import testdata.pages.Login;

public class BaseTest {

	static WebDriver driver;
	static LoginPage loginPage;
	static CheckoutPage checkoutPage;
	static ProductsPage productsPage;
	static ThankYouPage thankYouPage;
	static YourCartPage yourCartPage;
	static OneProductPage oneProductPage;
	static CheckoutOverviewPage checkoutOverviewPage;
	static HeaderPage headerPage;

	public User standardUser = new User("standardUser");
	public User lockedoutUser = new User("lockedoutUser");
	public Client validInfoClient = new Client("validInfoClient");
	public Item oneItem = new Item("oneItem");
	
	@BeforeClass
	public static void beforeAll() {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		chromeOption.addArguments("disable-infobars"); // Disable infobars
		chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
		chromeOption.addArguments("disable-default-apps"); // Disable default apps
		chromeOption.addArguments("no-first-run"); // Skip first run wizards
		chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
		chromeOption.addArguments("--disable-search-engine-choice-screen");

		chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
		chromeOption.addArguments("disable-notifications"); // Disable notifications
		chromeOption.addArguments("disable-extensions"); // Disable extensions
		chromeOption.addArguments("guest"); // Disable change password popup

		System.setProperty("webdriver.chrome.driver", "src/source/chromedriver.exe");

		driver = new ChromeDriver(chromeOption);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// full screen for browser
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		checkoutPage = new CheckoutPage(driver);
		productsPage = new ProductsPage(driver);
		yourCartPage = new YourCartPage(driver);
		thankYouPage = new ThankYouPage(driver);
		oneProductPage = new OneProductPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		headerPage = new HeaderPage(driver);
	}

	@AfterClass
	public static void afterAll() {
		driver.close();
	}

	@Before
	public void before()  {
		driver.get(URL.MAIN);
		Assert.assertEquals(Login.HEADER, loginPage.getHeaderText());
	}

}
