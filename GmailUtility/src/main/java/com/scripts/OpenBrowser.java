package com.scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.Utilities;

public class OpenBrowser {
	public static WebDriver driver;

	@BeforeTest
	public static void OpenGmail() throws MalformedURLException {

		/********* Running through docker ***********************/

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4646/wd/hub"), cap);
		driver.get("https://gmail.com");

		/****** For using browser launch using selenium driver ***********/

		/*
		 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); driver
		 * = new ChromeDriver(); driver.manage().timeouts().pageLoadTimeout(30,
		 * TimeUnit.SECONDS); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS); driver.manage().window().maximize();
		 * driver.get("https://gmail.com");
		 */

	}

}
