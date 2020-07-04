package framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.base.ExtraPages;
import framework.utils.PaymentsUtils;

public class TestLinks {
  
  public PaymentsUtils utils;
  public WebDriver driver;
  public ExtraPages extraPages;
  @BeforeTest
  public void beforeTest() {
	  
	  utils = new PaymentsUtils();
	  driver = utils.initialize();
	  extraPages = new ExtraPages(driver);
	 
  }
  @Test
  public void test() {
	  extraPages.addElementsInList();
	  extraPages.checkLinks();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
