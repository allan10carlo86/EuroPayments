package framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.utils.PaymentsUtils;

public class PasswordReset extends BasePage{
	
	public PaymentsUtils utilsWeb;
	
	public PasswordReset (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		utilsWeb = new PaymentsUtils();
	}
	
	@FindBy(how = How.XPATH, using="//div[contains(text(), 'Password reset')]")
	public WebElement passwordResetText;
	
	
	public void validatePasswordResetText() {
		utilsWeb.checkForFieldsIsDisplayed(super.wait, passwordResetText);

	}
	
	

}
