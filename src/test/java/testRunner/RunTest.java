package testRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\resources\\Features"},
//		features= {"src\\test\\resources\\Features\\Login.feature"},
//		features= {"src\\test\\resources\\Features\\ProductsAndCart.feature"},
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,//removes unwanted symbols from condole window//	
		plugin= {"pretty","html:target/cucumber-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags= "@scenario"
		)

public class RunTest extends AbstractTestNGCucumberTests{

	

}
