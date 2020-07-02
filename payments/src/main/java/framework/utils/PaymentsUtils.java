package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentsUtils {
	public WebDriver initialize() {
		System.out.println("-----Initialize Properties-------");
		System.setProperty("webdriver.chrome.driver",
							"drivers/mac/chromedriver");
		WebDriver driver = new ChromeDriver();
        System.out.println("Website is : " + Constants.url);
        driver.get(Constants.url);
        return driver;
	}
}
