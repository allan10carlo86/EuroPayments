package framework.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import framework.utils.Constants;
public class LoginPage extends BasePage {

	private JavascriptExecutor execute;
	public LoginPage(WebDriver driverInstance) {
		super(driverInstance);
		PageFactory.initElements(driverInstance, this);
		
	}
	
    @FindBy(how = How.ID, using="userIdentifier")
    public WebElement textLoginName;

    @FindBy(how = How.XPATH, using="//button[text()='Log in']")
    public WebElement loginButtonFirstPage;
    
    @FindBy(how = How.XPATH, using="//a[@aria-controls='login-methods-body-user_credentials']/following-sibling::div//button[text()='Log in']")
    public WebElement loginButtonSecondPage;
    
    @FindBy(how = How.XPATH, using="//button[text()='Cancel']")
    public WebElement cancelButton;
        	
    @FindBy(how = How.XPATH, using="//div[@id=\"login-methods-heading-user_credentials\"]")
    public WebElement passwordOpen;
    
    @FindBy(how = How.ID, using="password")
    public WebElement passwordInput;
    
    
    public void loginToPaySera() throws InterruptedException{
       
       loginUsername();
       boolean isDisplayedCancelButton = false;
       
       do {
    	   isDisplayedCancelButton = super.wait.until(ExpectedConditions.visibilityOf(cancelButton)).isDisplayed();
    	   System.out.println("Is Displayed Cancel Button Seen : " + isDisplayedCancelButton);
       } while (!(isDisplayedCancelButton));
       
       super.wait.until(ExpectedConditions.visibilityOf(passwordOpen));
       
       execute = (JavascriptExecutor) super.webDriverInstance;
       execute.executeScript(
    		 "document.getElementById(\"login-methods-heading-user_credentials\").click();"
    		   );
       System.out.println("---Input Password---");
       System.out.println("---Password is: " + Constants.password);
       super.wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(Constants.password);
       super.wait.until(ExpectedConditions.visibilityOf(loginButtonSecondPage)).click(); 
    }
    
    public void loginUsername() {
        textLoginName.sendKeys(Constants.username);
        loginButtonFirstPage.click();
    }
}
