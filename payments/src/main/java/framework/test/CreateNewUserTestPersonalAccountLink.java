package framework.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.CreateNewUser;
import framework.base.LoginPage;
import framework.utils.PaymentsUtils;

public class CreateNewUserTestPersonalAccountLink {
	
	public PaymentsUtils utils;
	public WebDriver driver;
	public LoginPage loginPage;
	public CreateNewUser createNewUserPage;
	
	@BeforeTest
	public void beforeTest() {
		utils = new PaymentsUtils();
		driver = utils.initialize();
		loginPage = new LoginPage(driver);
		createNewUserPage = new CreateNewUser(driver);
	}
	
	@Test
	public void test() {
		loginPage.clickCreateNewUser();
		createNewUserPage.goToPersonalAccount();	
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
