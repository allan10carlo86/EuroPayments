package framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.LoginPage;
import framework.base.MainPage;
import framework.base.PasswordReset;
import framework.utils.PaymentsUtils;

public class PasswordResetValidate {

	public PaymentsUtils utils;
	public LoginPage loginP;
	public WebDriver driver;
	public PasswordReset passwordResetPage;
	

	@BeforeTest
	public void beforeTest() {
		utils = new PaymentsUtils();
		driver = utils.initialize();
		loginP = new LoginPage(driver);
		passwordResetPage = new PasswordReset(driver);
	}

	@Test
	public void test() throws InterruptedException {
		loginP.goToForgotPassword();
		passwordResetPage.validatePasswordResetText();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
