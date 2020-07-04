package framework.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import framework.utils.Constants;
import framework.utils.PaymentsUtils;

public class LoginPage extends BasePage {

	private JavascriptExecutor execute;
	public PaymentsUtils utilsWeb;
	
	public LoginPage(WebDriver driverInstance) {
		super(driverInstance);
		PageFactory.initElements(driverInstance, this);
		utilsWeb = new PaymentsUtils();
	}

	@FindBy(how = How.ID, using = "userIdentifier")
	public WebElement textLoginName;

	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	public WebElement loginButtonFirstPage;

	@FindBy(how = How.XPATH, using = "//a[@aria-controls='login-methods-body-user_credentials']/following-sibling::div//button[text()='Log in']")
	public WebElement loginButtonSecondPage;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	public WebElement cancelButton;

	@FindBy(how = How.XPATH, using = "//div[@id=\"login-methods-heading-user_credentials\"]")
	public WebElement passwordOpen;

	@FindBy(how = How.ID, using = "password")
	public WebElement passwordInput;

	@FindBy(how = How.XPATH, using = "//span[text()='Incorrect password. Please try again.']")
	public WebElement wrongPasswordMessage;
	
	@FindBy(how = How.XPATH, using = "//div[text()='The specified user could not be found']")
	public WebElement wrongUsernameMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@href=\"/en/registration\"]")
	public WebElement registerNewUser; 
	
	@FindBy(how = How.XPATH, using ="//a[text()='Forgot password?']")
	public WebElement forgotPasswordLink;

	public void loginToPaySera() throws InterruptedException {

		loginUsername();
		/*
		 * boolean isDisplayedCancelButton = false;
		 * 
		 * do { isDisplayedCancelButton =
		 * super.wait.until(ExpectedConditions.visibilityOf(cancelButton)).isDisplayed()
		 * ; System.out.println("--- Is Displayed Cancel Button Seen : " +
		 * isDisplayedCancelButton); } while (!(isDisplayedCancelButton));
		 * 
		 * super.wait.until(ExpectedConditions.visibilityOf(passwordOpen));
		 * 
		 * execute = (JavascriptExecutor) super.webDriverInstance;
		 * execute.executeScript(
		 * "document.getElementById(\"login-methods-heading-user_credentials\").click();"
		 * ); System.out.println("--- Input Password---");
		 * System.out.println("--- Password is: " + Constants.password);
		 * super.wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(
		 * Constants.password);
		 * super.wait.until(ExpectedConditions.visibilityOf(loginButtonSecondPage)).
		 * click();
		 */
		loginPassword();
	}

	public void loginPassword() {
		boolean isDisplayedCancelButton = false;
		
		try {
			isDisplayedCancelButton = super.wait.until(ExpectedConditions.visibilityOf(cancelButton)).isDisplayed();
			System.out.println("--- Is Displayed Cancel Button Seen : " + isDisplayedCancelButton);
		} catch (TimeoutException e) {
			isDisplayedCancelButton = false;
		}

		super.wait.until(ExpectedConditions.visibilityOf(passwordOpen));


		if (isDisplayedCancelButton) {
			execute = (JavascriptExecutor) super.webDriverInstance;
			execute.executeScript("document.getElementById(\"login-methods-heading-user_credentials\").click();");
		}
		
		System.out.println("--- Input Password---");
		System.out.println("--- Password is: " + Constants.password);
		super.wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(Constants.password);
		super.wait.until(ExpectedConditions.visibilityOf(loginButtonSecondPage)).click();

	}

	public void loginPassword(String password) {
		
		validateIfMobileSectionIsExisting();

		System.out.println("--- Input Password---");
		System.out.println("--- Password is: " + password);
		super.wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
		super.wait.until(ExpectedConditions.visibilityOf(loginButtonSecondPage)).click();

		boolean wrongPasswordMesasgeIsSeen = super.wait.until(ExpectedConditions.visibilityOf(wrongPasswordMessage))
				.isDisplayed();
		Assert.assertEquals(wrongPasswordMesasgeIsSeen, true, "wrong password is not seen");
		System.out.println("--- Wrong Password");
	}

	public void validateIfMobileSectionIsExisting() {
		boolean isDisplayedCancelButton = false;

		
		try {
			isDisplayedCancelButton = super.wait.until(ExpectedConditions.visibilityOf(cancelButton)).isDisplayed();
			System.out.println("--- Is Displayed Cancel Button Seen : " + isDisplayedCancelButton);
		} catch (TimeoutException e) {
			isDisplayedCancelButton = false;
		}

		super.wait.until(ExpectedConditions.visibilityOf(passwordOpen));


		if (isDisplayedCancelButton) {
			execute = (JavascriptExecutor) super.webDriverInstance;
			execute.executeScript("document.getElementById(\"login-methods-heading-user_credentials\").click();");
		}

	}
	public void loginUsername() {
		System.out.println("---Input Username ---");
		System.out.println("--- Username: " + Constants.username);
		utilsWeb.checkForFields(super.wait, textLoginName);
		textLoginName.sendKeys(Constants.username);
		loginButtonFirstPage.click();
	}
	
	public void wrongUsername()
	{
		System.out.println("---Input Username ---");
		System.out.println("--- Username: " + Constants.incorrectUsername);
		super.wait.until(ExpectedConditions.visibilityOf(textLoginName));
		textLoginName.sendKeys(Constants.incorrectUsername);
		loginButtonFirstPage.click();
		
		boolean isErrorMessageDisplayed = super.wait.until(ExpectedConditions.visibilityOf(wrongUsernameMessage)).isDisplayed();
		Assert.assertEquals(isErrorMessageDisplayed, true, "Error Message is not Displayed");
		System.out.println("--- Username Error Message is displayed");
		
	}

	public void wrongPassword() {
		loginUsername();
		loginPassword(Constants.wrongPassword);

	}
	
	public void clickCreateNewUser() {
		utilsWeb.checkForFieldsIsDisplayed(super.wait, registerNewUser);
		registerNewUser.click();
	}
	
	public void goToForgotPassword() throws InterruptedException {
		loginUsername();
		validateIfMobileSectionIsExisting();
		utilsWeb.checkForFields(super.wait, forgotPasswordLink);
		forgotPasswordLink.click();
		
	}
}
