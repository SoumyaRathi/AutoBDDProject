package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.DriverManager;
import framework.TestContext;
import io.cucumber.java.Scenario;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
	DriverManager driverManager = new DriverManager();
	private TestContext context;
	WebDriver driver;
	
	public Hooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void setUp() throws Exception {
		context.getDriverManager().setUpDriver();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException, InterruptedException{
		if(scenario.isFailed()){
			scenario.attach(context.getDriverManager().getByteScreenshot(), "image/png", "Failed Scenario Screenshot");
			context.getDriverManager().getScreenshot();
		}else{
			scenario.attach(context.getDriverManager().getByteScreenshot(), "image/png", "Screenshot");
		}
		
	}
	
	@After
	public void closeDriver(){
		context.getDriverManager().getDriver().quit();
	}

}
