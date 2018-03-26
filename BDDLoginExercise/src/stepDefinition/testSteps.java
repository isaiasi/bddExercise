package stepDefinition;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.*;

public class testSteps {
	
	static String ffDriverPath = "/Users/isaiasi/QA/Automation/Selenium/geckodriver";
	static String url = "http://store.demoqa.com/";
	static String userName = "isaiasif";
	static String userPassword = "^iu51bQFv#fHv*2k";
	
	static WebDriver driver;
	static By myAccountLink = By.xpath("//*[@id=\"account\"]/a");
	static By usernameTextbox = By.id("log");
	static By passwordTextBox = By.id("pwd");
	static By loginButton = By.id("login");
	static By logoutButton = By.xpath("//*[@id=\"account_logout\"]");
	static By errorMessage = By.cssSelector("p.response:nth-child(1) > strong:nth-child(1)");
	
	
	@Given("^user is on the home page$")
	public void user_is_on_the_home_page() throws Throwable{
		System.setProperty("webdriver.gecko.driver", ffDriverPath);
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Given("^user navigates to the login page$")
	public void user_navigates_to_the_login_page() throws Throwable{
		driver.findElement(myAccountLink).click();
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
		driver.findElement(usernameTextbox).sendKeys(userName);
		driver.findElement(passwordTextBox).sendKeys(userPassword);
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable{
		driver.findElement(loginButton).click();
	}

	@Then("^MyAccount dashboard is displayed$")
	public void myaccount_dashboard_is_displayed() throws Throwable{
		if(driver.findElement(logoutButton).isEnabled()) {
			System.out.println("\nLogin was successful\n");
			driver.close();
		}
	}

	@When("^user enters incorrect \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\"$")
	public void user_enters_incorrect_username_and_password(String userid, String password) throws Throwable{
		driver.findElement(usernameTextbox).sendKeys(userid);
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	@Then("^\\\"([^\\\"]*)\\\" message is displayed$")
	public void invalid_login_message_is_displayed(String warning) throws Throwable{
		if(driver.findElement(errorMessage).isDisplayed()) {
			System.out.println("\nLogin was unsuccessful\n");
			driver.close();
		}
	}
	
}
