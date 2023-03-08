package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static void launchBrowser(String browser) throws Throwable {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {

			throw new Exception("Given browser name is not matching");
		}
	}

	public static void openApp(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void enterText(WebElement ele, String name) {

		ele.sendKeys(name);

	}

	public static void clickButton(WebElement ele) {

		ele.click();

	}

	public static String getProperty(String key) throws Throwable, IOException {

		Properties p = new Properties();
		p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config/System.property")));

		return p.getProperty(key);

	}

}
