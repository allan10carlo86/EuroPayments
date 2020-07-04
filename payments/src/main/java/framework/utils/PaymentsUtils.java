package framework.utils;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentsUtils {
	public WebDriver initialize() {
		System.out.println("-----Initialize Properties-------");

		String operatingSystem = getOSName();
		System.out.println("----Operating System: " + operatingSystem + "---");

		if (operatingSystem.startsWith(Constants.macString)) {
			System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
		}

		WebDriver driver = new ChromeDriver();
		System.out.println("Website is : " + Constants.url);
		driver.get(Constants.url);
		return driver;
	}

	public String getOSName() {
		return System.getProperty("os.name");
	}

	public String createRandomText() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;

		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		System.out.println("----  Text Generated: " + generatedString);
		return generatedString;
	}
	
	public String generatePassword() {
		return createRandomText() + "!@#$%^&*()_+" + "11";
	}
	
	public String createRandomEmail() {
		return createRandomText() + "@gmail.com";
	}
	
	public void checkForFields(WebDriverWait waitVar, WebElement webElement) {
		waitVar.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println("--- Element is existing  -- " + webElement);
	}

	public boolean checkForFieldsIsDisplayed(WebDriverWait waitVar, WebElement webElement) {
		boolean isDisplayed = waitVar.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
		System.out.println("--- Element is existing  -- " + webElement);
		return isDisplayed;
	}
	
	public void checkForClickability(WebDriverWait waitVar, WebElement webElement) {
		waitVar.until(ExpectedConditions.elementToBeClickable(webElement));
		System.out.println("--- Element is Clickable  -- " + webElement);
	}
	
	public String generateRandomCellNumber() {
		String areaCode = "+63917";
	    String contactNumber = areaCode;
	    
	    String[] possibleContactNumbers = {
	    		"4895071",
	    		"3012319",
	    		"7930920",
	    		"9382909",
	    		"9320499",
	    };
	    

	    Random randomNumber = new Random();
	    int randomNumberInt = randomNumber.nextInt(5);
	    System.out.println("---- RandomNumber Int: " + randomNumberInt);
	    contactNumber = contactNumber + possibleContactNumbers[randomNumberInt];
		System.out.println("----- Contact Number is: " + contactNumber);
		return contactNumber;
	}
}
