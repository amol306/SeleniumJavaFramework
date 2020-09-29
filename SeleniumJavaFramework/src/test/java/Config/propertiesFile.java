package Config;

import java.io.FileInputStream;
import java.io.*;
import java.util.Properties;

import test.TestNG_Demo;

public class propertiesFile {

	private static Properties prop = new Properties();

	public static void main(String[] args) {
		getProperties();
		setProperties("browser", "chrome");
		getProperties();
	}

	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\Config\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			TestNG_Demo.browserName = prop.getProperty("browser");
		} catch (Exception ex) {
			System.out.println("Catch Exception!");
			System.out.println("ex.getMessage() : " + ex.getMessage());
			System.out.println("ex.getCause() : " + ex.getCause());
			ex.printStackTrace();
		}
	}

	public static void setProperties(String key, String value) {
		try {
			OutputStream output = new FileOutputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\Config\\config.properties");
			prop.setProperty(key, value);
			prop.store(output, "");
		} catch (Exception ex) {
			System.out.println("Catch Exception!");
			System.out.println("ex.getMessage() : " + ex.getMessage());
			System.out.println("ex.getCause() : " + ex.getCause());
			ex.printStackTrace();
		}
	}
}
