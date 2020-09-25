package com.scripts;

import static com.scripts.OpenBrowser.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utility.Utilities;

public class LoginGmail extends OpenBrowser {
	@Test
	public static void loginSearchContent() throws InterruptedException, IOException {

		/** Entered the credentials **/
		Utilities.waitforElement();
		Utilities.enterValues("login.email", "Email");
		Utilities.clickElement("login.next");
		Utilities.waitforElement();
		Utilities.enterValues("login.password", "Password");
		Utilities.clickElement("login.passwordnext");
		Utilities.takeScreenshot();

		/**** Mail search through subject using the environment variable****/
		Utilities.waitforElement();
		Utilities.takeScreenshot();
		Utilities.enterValues1("mail.subject", "Subject");
		Utilities.waitforElement();
		Utilities.takeScreenshot();
		Utilities.clickElement("mail.mail");
		Utilities.takeScreenshot();
		Utilities.waitforElement();
		
		/***** Getting the content from the mail****/
		Utilities.takeScreenshot();
		Utilities.waitforElement();
		Utilities.getContent();
		Utilities.takeScreenshot();
		
	}

}
