package framework.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class ExtraPages extends BasePage {

	public ExtraPages(WebDriver instance) {
		super(instance);
		PageFactory.initElements(instance, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Privacy Policy")
	public WebElement privacyPolicyLink;

	@FindBy(how = How.LINK_TEXT, using = "Service agreements")
	public WebElement serviceAgreementLink;

	@FindBy(how = How.LINK_TEXT, using = "Recommendations for the safe usage")
	public WebElement recommendationsForSafeLink;

	public String[] arrayText = { "//h1[text()='Privacy Policy']",
			"//h1[text()='General Payment Services Agreement for Private Clients']",
			"//h1[text()='How to use the Paysera services safely?']" };

	List<WebElement> linkTextList = new ArrayList();
	List<WebElement> contentTextList = new ArrayList();

	public void addElementsInList() {
		linkTextList.add(privacyPolicyLink);
		linkTextList.add(serviceAgreementLink);
		linkTextList.add(recommendationsForSafeLink);

		System.out.println(linkTextList);
	}

	public void checkLinks() {
		LoginPage loginPage = new LoginPage(super.webDriverInstance);
		super.wait.until(ExpectedConditions.visibilityOf(loginPage.textLoginName));
		System.out.println("--- Login Button is Displayed");

		WebElement elementText = null;

		for (int i = 0; i < linkTextList.size(); i++) {

			super.wait.until(ExpectedConditions.visibilityOf(linkTextList.get(i)));
			System.out.println("---- Show Web element: " + linkTextList.get(i).getText());
			linkTextList.get(i).click();
			elementText = super.wait.until(
					ExpectedConditions.visibilityOf(super.webDriverInstance.findElement(By.xpath(arrayText[i]))));
			super.wait.until(ExpectedConditions.visibilityOf(elementText));
			System.out.println("--- Text: " + elementText.getText());
			super.webDriverInstance.navigate().back();
			super.wait.until(ExpectedConditions.visibilityOf(loginPage.textLoginName));
			System.out.println("--- Login Button is Displayed");

		}
	}

}
