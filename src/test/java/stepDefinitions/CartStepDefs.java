package stepDefinitions;


import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import framework.TestContext;
import framework.WebDriverUtils;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import io.cucumber.java.en.*;

public class CartStepDefs {
	private static Properties prop;
	Logger logger = LogManager.getLogger(CartStepDefs.class);
	private TestContext context;
	public WebDriverUtils WbUtil;
	public CartPage cart;
	
	public CartStepDefs(TestContext context) {
		this.context = context;
		this.cart=context.getCart();
		this.WbUtil=context.getUtils();
	}
	
	@Then("Click on Checkout btn")
	public void click_on_Checkout_btn() throws Throwable {
		logger.info("********Clicking on Checkout btn********");
    	cart.clickOnCheckOut();
	}

	@Then("Enter user First name {string} last name {string} and Postal code {string}")
	public void enter_user_First_name_last_name_and_Postal_code(String fName, String lName, String zipcode) throws Throwable {
		logger.info("********Enter Required User Details********");
    	cart.enterUserDetails(fName, lName, zipcode);
	}

	@Then("Click on Continue btn")
	public void click_on_Continue_btn() throws Throwable {
		logger.info("********Clicking on Continue btn********");
    	cart.clickOnContinue();
	}

	@Then("Click on Finish btn")
	public void click_on_Finish_btn() throws Throwable {
		logger.info("********Clicking on Finish btn********");
    	cart.clickOnFinish();
	}


}
