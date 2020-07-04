package framework.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import framework.utils.Constants;
import framework.utils.PaymentsUtils;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;


public class CreateNewUser extends BasePage {
	
	public PaymentsUtils utilsWeb;
	public CreateNewUser(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		utilsWeb = new PaymentsUtils();
	}
	
	@FindBy(how = How.XPATH, using = "//span[text()='Account Registration']")
	public WebElement accountRegistrationText;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Business account')]")
	public WebElement businessAccountLink;
	
	@FindBy(how = How.XPATH, using="//a[contains(text(), 'Personal account')]")
	public WebElement personalAccountLink;
	
	@FindBy(how = How.XPATH, using="//img[@src='/assets/bundles/evpuser/img/registration/group-3.png']")
	public WebElement imageCellPhonePersonalLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Open business account')]")
	public WebElement openBusinessAccountButton;
	
	@FindBy(how = How.XPATH, using = "(//select[@name=\"countryCode\"])[2]")
	public WebElement selectCountryCode;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Personal email address']/following-sibling::input)[2]")
	public WebElement personalEmailAddressInput;
	
	@FindBy(how = How.XPATH, using = "(//label[contains(text(), 'Password')]/following-sibling::input)[2]")
	public WebElement passwordInput;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Repeat password']/following-sibling::input)[2]" )
	public WebElement repeatPasswordInput;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Name']/following-sibling::input)[2]")
	public WebElement nameInput;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Surname']/following-sibling::input)[2]")
	public WebElement surnameInput;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Contact phone']/following-sibling::input)[2]")
	public WebElement contactPhoneInput;
	
	@FindBy(how = How.XPATH, using = "(//label/input)[2]")
	public WebElement iAgreeWithCheckBox;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Open account')])[2]")
	public WebElement openAccountButton;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Your account has been created']")
	public WebElement yourAccountHasBeenCreatedMessage;
	
	@FindBy(how = How.XPATH, using = "//h4[text()='Are you a robot?']")
	public WebElement verifyRobotNotif;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'You have already started registration with this email address. In order to finish the registration ')]")
	public WebElement errorMessageUserNameAlreadyUsed;
	
	
	@FindBy(how = How.XPATH, using = "(//ng-transclude/li[contains(text(),'Passwords')])[2]")
	public WebElement errorMessagePasswordDoNotMatch;
	
	@FindBy(how = How.XPATH, using = "(//span[contains(text(), 'This phone number is already registered.')])[2]")
	public WebElement errorMessagePhoneNumberAlreadyUsed;
	

	

	public void validateAccountRegistrationPage() {
		super.wait.until(ExpectedConditions.visibilityOf(accountRegistrationText));
		System.out.println("---- Account Registration Page exist");
	}
	
	public void clickBusinessAccountLink() {
		super.wait.until(ExpectedConditions.visibilityOf(businessAccountLink)).click();
		System.out.println("---- Business Account Link Exist");
	}
	
	public void clickOpenBusinessAccountButton() {
		super.wait.until(ExpectedConditions.visibilityOf(openBusinessAccountButton)).click();
		System.out.println("--- Click Open Business Account");
	}
	
	
	public void validateInputFieldsForBusiness() {
		utilsWeb.checkForFields(super.wait, selectCountryCode);
		System.out.println("---- Select Field for country is Existing");
	}
	
	public void fillOutBusinessAccountDetails() {
		Select countrySelect = new Select(selectCountryCode);
		countrySelect.selectByVisibleText(Constants.countryVisibleText);
		
		utilsWeb.checkForFields(super.wait, personalEmailAddressInput);
		personalEmailAddressInput.sendKeys(utilsWeb.createRandomEmail());
		
		utilsWeb.checkForFields(super.wait, passwordInput);
		String password = utilsWeb.generatePassword();
		passwordInput.sendKeys(password);
		
		utilsWeb.checkForFields(super.wait, repeatPasswordInput);
		repeatPasswordInput.sendKeys(password);
		
		utilsWeb.checkForFields(super.wait, nameInput);
		nameInput.sendKeys(Constants.firstName);
		
		utilsWeb.checkForFields(super.wait, surnameInput);
		surnameInput.sendKeys(Constants.lastName);
		
		utilsWeb.checkForFields(super.wait, contactPhoneInput);
		contactPhoneInput.clear();
		contactPhoneInput.sendKeys(utilsWeb.generateRandomCellNumber());
		
		utilsWeb.checkForFields(super.wait, iAgreeWithCheckBox);
		iAgreeWithCheckBox.click();
		
		utilsWeb.checkForClickability(super.wait, openAccountButton);
		openAccountButton.click();
		
	}
	
	public void fillOutBusinessAccountDetailsPasswordDoNotMatch() {
		Select countrySelect = new Select(selectCountryCode);
		countrySelect.selectByVisibleText(Constants.countryVisibleText);
		
		utilsWeb.checkForFields(super.wait, personalEmailAddressInput);
		personalEmailAddressInput.sendKeys(utilsWeb.createRandomEmail());
		
		utilsWeb.checkForFields(super.wait, passwordInput);
		String password = utilsWeb.generatePassword();
		passwordInput.sendKeys(password);
		
		utilsWeb.checkForFields(super.wait, repeatPasswordInput);
		repeatPasswordInput.sendKeys(password+"1");
		
		utilsWeb.checkForFields(super.wait, nameInput);
		super.actions.moveToElement(nameInput).click().build().perform();
		
		utilsWeb.checkForFields(super.wait, errorMessagePasswordDoNotMatch);
		
	}
	
	
	public void verifyAccountIsCreated() {
		utilsWeb.checkForFields(super.wait, yourAccountHasBeenCreatedMessage);
	}
	
	public boolean verifyRobotNotifMethod() {
		try {
			utilsWeb.checkForClickability(super.wait, verifyRobotNotif);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public void checkPersonalAccountLink() {
		boolean isDisplayedLink;
		isDisplayedLink = utilsWeb.checkForFieldsIsDisplayed(super.wait, personalAccountLink);
		Assert.assertEquals(isDisplayedLink, true, "Personal Account Link is Not displayed");
		isDisplayedLink = utilsWeb.checkForFieldsIsDisplayed(super.wait, imageCellPhonePersonalLink);
		Assert.assertEquals(isDisplayedLink, true, "Image Cellphoneis Not displayed");
	}

	/**
	 * Go to Personal Account section and validate fields
	 */
	
	public void goToPersonalAccount() {
		validateAccountRegistrationPage();
		checkPersonalAccountLink();
	}
	
	/**
	 * Happy Path of Create user
	 */
	public void createUserHappyPath() {
		validateAccountRegistrationPage();
		clickBusinessAccountLink();
		clickOpenBusinessAccountButton();
		fillOutBusinessAccountDetails();
		if(!verifyRobotNotifMethod()) {
			verifyAccountIsCreated();
		}
	}
	
	/**
	 * Password is not matching
	 */
	public void passwordDoNotMatch() {
		validateAccountRegistrationPage();
		clickBusinessAccountLink();
		clickOpenBusinessAccountButton();
		fillOutBusinessAccountDetailsPasswordDoNotMatch();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
