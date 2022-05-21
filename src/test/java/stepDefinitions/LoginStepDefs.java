package stepDefinitions;


import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import framework.DriverManager;
import framework.Settings;
import framework.TestContext;
import framework.WebDriverUtils;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import io.cucumber.java.en.*;

public class LoginStepDefs {
	private static Properties prop;
	Logger logger = LogManager.getLogger(LoginStepDefs.class);
	private TestContext context;
	public LoginPage login;
	public WebDriverUtils WbUtil;
	
	public LoginStepDefs(TestContext context) {
		this.context = context;
		this.login=context.getLogin();
		this.WbUtil=context.getUtils();
	}
	
	@Given("^I am in the login page of the application$")
	public void i_am_in_login_page() throws InterruptedException {
		 prop = Settings.getInstanceProperties();
		 logger.info("******** Opening URL*********");
		 context.getDriverManager().getDriver().get(prop.getProperty("Url"));
		 System.out.println(prop.getProperty("Url"));
		 context.getDriverManager().getDriver().manage().window().maximize();	
		 assertTrue(context.getDriverManager().getDriver().getTitle().contains("Swag Labs"));
		
	}
	
	@When("User login in application with userName {string} and password {string}")
	public void user_login_in_application_with_userName_and_password(String username, String password) throws Throwable {
		logger.info("******** Give login details*********");
		System.out.println(username+" "+password);
		login.enterUserNameAndPassword(username, password);
	}

	@When("Click on Login btn")
	public void click_on_Login_btn() throws Throwable {
		logger.info("********click Login button *********");
    	login.clickOnLoginBtn();
	}

	@Then("Verify that user is succesfully logged in {string}")
	public void verify_that_user_is_succesfully_logged_in(String title) throws Throwable {
		logger.info("********Verify whether user logged in or not *********");
    	login.verifyPageDisplayed(title);
    	logger.info("********User logged in *********");
	}

	
	@Then("Validate Error msg displayed when credentials are Invalid")
    public void validate_error_msg_displayed_when_credentials_are_invalid() throws Throwable {
    	logger.info("********Validate Error Msg if Credentials Invalid********");
    	login.checkErrorMsg();
    }
	
	@Then("close browser")
	public void close_browser() throws Throwable {
		logger.info("********closing browser********");
		context.getDriverManager().getDriver().quit();
	}

	
//	@When("I am in the login page Url of the application")
//	 public void i_am_in_the_login_page_of_the_application() throws Throwable {
//		 prop = Settings.getInstanceProperties();
//		 logger.info("******** Opening URL*********");
//		 context.getDriverManager().getDriver().get(prop.getProperty("Url"));
//		 System.out.println(prop.getProperty("Url"));
//		 context.getDriverManager().getDriver().manage().window().maximize();
//	    }
//	
}
