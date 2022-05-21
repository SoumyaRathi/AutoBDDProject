package framework;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class TestContext {

	private DriverManager driverManager;
	private LoginPage login;
	private WebDriverUtils utils;
	private ProductsPage products;
	private CartPage cart;
	
	public DriverManager getDriverManager() {
		if(driverManager==null) {
			driverManager = new DriverManager();
		}
		return driverManager;
	}
	
	public ProductsPage getProducts() {
		if(products==null) {
			products = new ProductsPage(driverManager.getDriver());
		}
		return products;
	}
	
	public LoginPage getLogin() {
		if(login==null) {
			login = new LoginPage(driverManager.getDriver());
		}
		return login;
	}
	
	public CartPage getCart() {
		if(cart==null) {
			cart = new CartPage(driverManager.getDriver());
		}
		return cart;
	}
	
	public WebDriverUtils getUtils() {
		if(utils==null) {
			utils = new WebDriverUtils(driverManager.getDriver());
		}
		return utils;
	}
	
	
}
