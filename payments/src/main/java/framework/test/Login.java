package framework.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.LoginPage;
import framework.utils.PaymentsUtils;

public class Login {
	
  public PaymentsUtils utils;
  public LoginPage loginP;
  public WebDriver driver;
  public WebDriverWait wait;
  @BeforeTest 
  public void beforeTest() {
	  utils = new PaymentsUtils();
	  driver = utils.initialize();
	  loginP = new LoginPage(driver);
	  wait = new WebDriverWait(driver, 20);
  }
  
  @Test
  public void test() throws InterruptedException {
	loginP.loginToPaySera();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
