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

public class ProductStepDefs {
	private static Properties prop;
	Logger logger = LogManager.getLogger(ProductStepDefs.class);
	private TestContext context;
	public ProductsPage products;
	public WebDriverUtils WbUtil;
	
	public ProductStepDefs(TestContext context) {
		this.context = context;
		this.products=context.getProducts();
		this.WbUtil=context.getUtils();
	}

	@Then("Add the product {string} to the cart")
	public void add_the_product_to_the_cart(String product) throws Throwable {
		logger.info("********Adding product to Cart*********");
    	products.clickOnAddToCartBtnForProduct(product);
	}

	@Then("Get description and price of product {string} from Products page")
	public void get_description_and_price_of_product_from_Products_page(String product) throws Throwable {
		logger.info("********Getting Description and Price of Product from products page*********");
    	products.getProductDescription(product);
    	products.getProductPrice(product);
	}

	@Then("Click on Cart icon and validate the product details of product {string} from Cart page")
	public void click_on_Cart_icon_and_validate_the_product_details_of_product_from_Cart_page(String product) throws Throwable {
		logger.info("********Validate Product details displayed correctly in Cart page*********");
    	products.validateProductDetailsOfProductPresentInCart(product);
	}

}
