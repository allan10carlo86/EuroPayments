package framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.LoginPage;
import framework.base.MainPage;
import framework.utils.PaymentsUtils;

public class Login {

	public PaymentsUtils utils;
	public LoginPage loginP;
	public WebDriver driver;
	public MainPage mainPage;

	@BeforeTest
	public void beforeTest() {
		utils = new PaymentsUtils();
		driver = utils.initialize();
		loginP = new LoginPage(driver);
		mainPage = new MainPage(driver);
	}

	@Test
	public void test() throws InterruptedException {
		loginP.loginToPaySera();
		mainPage.verifyMainPage();
		mainPage.logOutEpaymentsPage();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}
