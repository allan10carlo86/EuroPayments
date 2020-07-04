package framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.LoginPage;
import framework.utils.PaymentsUtils;

public class WrongPassword {
	
	public PaymentsUtils utils;
	public LoginPage loginP;
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		utils = new PaymentsUtils();
		driver = utils.initialize();
		loginP = new LoginPage(driver);
	}
	
	@Test
	public void test() {
		loginP.wrongPassword();
	}
	
	@AfterClass
	public void afterTest() {
		driver.close();
	}
}
