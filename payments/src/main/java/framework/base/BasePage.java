package framework.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	public WebDriver webDriverInstance;
	public WebDriverWait wait;
	public Actions actions;
	public JavascriptExecutor js;
	public BasePage (WebDriver instance) {
		this.webDriverInstance = instance;
		wait = new WebDriverWait(this.webDriverInstance, 20);
		actions = new Actions(webDriverInstance);
	}

}
