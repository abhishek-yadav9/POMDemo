package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckoutPage chkoutPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		chkoutPage = new CheckoutPage(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://saucedemo.com");
	}
	
	
  @Test(priority = 1)
  public void validLogin() {
	  loginPage.login("standard_user", "secret_sauce");
	  boolean isValid = listPage.isOnProducts();
	  Assert.assertTrue(isValid);
  }
  
  @Test(priority = 2)
  public void addItem() {
	  listPage.addToCart();
	  listPage.viewCart();
	  boolean isItemsAvail = cartPage.isItemAdded();
  }
  
  @Test(priority = 3)
  public void checkoutTest() {
	  cartPage.checkoutItems();
	  chkoutPage.provideDetails("TestUser", "One", "324323");
	  chkoutPage.checkoutOrder();
	  Assert.assertTrue(chkoutPage.isOrderSuccess());
	  
  }
  
}
