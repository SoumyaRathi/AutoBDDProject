package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singleton class that encapsulates the user settings specified in the
 * properties file 
 */

public class Settings {

	private static Properties properties = loadFromPropertiesFile();
	static Logger log = LogManager.getLogger(Settings.class);
	
	private Settings() {
		// To prevent external instantiation of this class
	}
	
//	to return singleton instance
	public static Properties getInstanceProperties() {
		return properties;
	}
	
	
	private static Properties loadFromPropertiesFile() {
		Properties prop = new Properties();
		try {
		FileInputStream fis=new FileInputStream("GlobalSettings.properties");
		prop.load(fis);
		} catch(IOException  e) {
			log.error(e.getMessage());
		}
		return prop;
	}
}
