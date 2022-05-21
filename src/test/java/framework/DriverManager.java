package framework;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;

public class DriverManager {

	private static WebDriver driver;
	private static Properties properties;
	static final Logger logger = LogManager.getLogger(DriverManager.class); 
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void setUpDriver() throws Exception {
		properties = Settings.getInstanceProperties();
		
		String browserType=properties.getProperty("browser");
		try {
		switch(browserType) {
		case "LOCAL_CHROME":
			System.setProperty("webdriver.chrome.driver",properties.getProperty("ChromePath"));
			driver=new ChromeDriver();
			break;
		case "LOCAL_EDGE":
			System.setProperty("webdriver.edge.driver",properties.getProperty("EdgePath"));
			driver = new EdgeDriver();
			break;
		case "LOCAL_FIREFOX":	
			System.setProperty("webdriver.gecko.driver",properties.getProperty("FirefoxPath"));
			driver = new FirefoxDriver();
			break;
		default:
			throw new Exception("Unhandled browser!");	
		 }
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("******** Launching browser*********");

		
	  } catch (Exception ex) {
		  logger.error(ex.getMessage());
			ex.printStackTrace();
	    }
	}

	
	public static String getScreenshot() {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/target/Screenshots/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(source,destination );
		} catch (IOException e) {
			System.out.println("Capture Failed" + e.getMessage());
		}
		return path;
	}
	
	
	public byte[] getByteScreenshot() throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent= FileUtils.readFileToByteArray(src);
		return fileContent;
	}
	
	
	
}
