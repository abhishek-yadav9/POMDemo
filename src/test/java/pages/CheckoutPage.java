package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(css = "input[data-test='firstName']")
	WebElement firstName;
	
	@FindBy(css = "input[data-test='lastName']")
	WebElement lastName;
	
	@FindBy(css = "input[data-test='postalCode']")
	WebElement postalCode;
	
	@FindBy(css = "input[data-test='continue']")
	WebElement contBtn;
	
	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(css = "h2.complete-header")
	WebElement successMsg;
	
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void provideDetails(String strfName, String strlName, String pCode) {
		firstName.sendKeys(strfName);
		lastName.sendKeys(strlName);
		postalCode.sendKeys(pCode);
		contBtn.click();
	}
	
	public void checkoutOrder() {
		finishBtn.click();
	}
	
	public boolean isOrderSuccess() {
		return successMsg.isDisplayed();
	}

}

