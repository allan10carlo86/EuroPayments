package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentsUtils {
	public WebDriver initialize() {
		System.out.println("-----Initialize Properties-------");
		
		String operatingSystem = getOSName();
		System.out.println("----Operating System: " + operatingSystem);
		
		if(operatingSystem.startsWith(Constants.macString)){
			System.setProperty("webdriver.chrome.driver",
					"drivers/mac/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					"drivers/windows/chromedriver.exe");
		}
		
		WebDriver driver = new ChromeDriver();
        System.out.println("Website is : " + Constants.url);
        driver.get(Constants.url);
        return driver;
	}
	
	public String getOSName() {
		return System.getProperty("os.name");
	}
}
