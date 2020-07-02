package framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage  extends BasePage {
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//span[text()='Log out']/parent::a")
	public WebElement logOutButton;
	
	@FindBy(how = How.XPATH, using="//h1[text()='Account Overview']")
	public WebElement accountOverview;
	
	public void verifyMainPage() {
		WebElement accountOv = super.wait.until(ExpectedConditions.visibilityOf(accountOverview));
		Assert.assertTrue(accountOv.isDisplayed(), "Account Overview is not Displayed");
		System.out.println("--- Main Page is Seen? " + accountOv.isDisplayed());
	}
	
	public void logOutEpaymentsPage() {
		WebElement logOutButtonMet = super.wait.until(ExpectedConditions.visibilityOf(logOutButton));
		Assert.assertEquals(logOutButton.isDisplayed(), true, "Log out Button is not Displayed");
		logOutButtonMet.click();
	}
}
