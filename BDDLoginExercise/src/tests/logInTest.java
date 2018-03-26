package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class logInTest {
	
	static String ffDriverPath = "/Users/isaiasi/QA/Automation/Selenium/geckodriver";
	static String url = "http://store.demoqa.com/";
	static String userName = "isaiasif";
	static String userPassword = "^iu51bQFv#fHv*2k";

	
	static WebDriver driver;
	static By myAccountLink = By.xpath("//*[@id=\"account\"]/a");
	static By usernameTextbox = By.id("log");
	static By passwordTextBox = By.id("pwd");
	static By loginButton = By.id("login");
	static By logoutButton = By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a");
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ffDriverPath);
		driver = new FirefoxDriver();
		driver.get(url);
		driver.findElement(myAccountLink).click();
		
		driver.findElement(usernameTextbox).sendKeys(userName);
		driver.findElement(passwordTextBox).sendKeys(userPassword);
		driver.findElement(loginButton).click();
		
		driver.findElement(logoutButton).click();
		
	}
	
}
