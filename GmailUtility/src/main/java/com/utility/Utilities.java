package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.scripts.OpenBrowser;

import static com.scripts.OpenBrowser.*;

public class Utilities {
	public static String Content;

	public static String GetKey(String key)

	{
		String value = System.getenv(key);
		return value;
	}

	public static void enterValue(String key, String key2) throws FileNotFoundException {

		Properties propmain = new Properties();

		FileInputStream FileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties"));
		try {

			propmain.load(FileInputStream);
			String locator = propmain.getProperty(key);
			String value = GetKey(key2);
			OpenBrowser.driver.findElement(By.id(locator)).sendKeys(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clickElement(String key) throws FileNotFoundException {

		Properties propmain = new Properties();

		FileInputStream FileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties"));

		try {

			propmain.load(FileInputStream);
			String locator = propmain.getProperty(key);
			OpenBrowser.driver.findElement(By.xpath(locator)).click();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void waitforElement() throws FileNotFoundException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void enterValues1(String key, String key2) throws FileNotFoundException {

		Properties propmain = new Properties();
		FileInputStream FileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties"));
		try {

			propmain.load(FileInputStream);
			String locator = propmain.getProperty(key);
			String value = GetKey(key2);
			OpenBrowser.driver.findElement(By.xpath(locator)).sendKeys(value);
			OpenBrowser.driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void enterValues(String key, String key2) throws FileNotFoundException {

		Properties propmain = new Properties();
		FileInputStream FileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties"));
		try {

			propmain.load(FileInputStream);
			String locator = propmain.getProperty(key);
			String value = GetKey(key2);
			OpenBrowser.driver.findElement(By.xpath(locator)).sendKeys(value);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void enter(String key) throws FileNotFoundException {

		Properties propmain = new Properties();
		FileInputStream FileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ObjectRepository.properties"));
		try {
			propmain.load(FileInputStream);
			String locator = propmain.getProperty(key);
			OpenBrowser.driver.findElement(By.id(locator)).sendKeys("Keys.ENTER");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getContent() throws FileNotFoundException {

		Content = OpenBrowser.driver.findElement(By.cssSelector(".ii.gt")).getText();

		return Content;

	}

	public static void takeScreenshot() throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String Timegiven = dtf.format(now);
		String Time = Timegiven.replace(":", "");
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File((System.getProperty("user.home") + "\\Desktop\\" + Time + "Picture.png")));
		System.out.println("the Screenshot is taken");

	}

}
