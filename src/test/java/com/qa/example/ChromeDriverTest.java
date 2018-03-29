package com.qa.example;

import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class ChromeDriverTest {

	//ScreenshotTestRule screenshot = new ScreenshotTestRule();

	private static WebDriver cDriver;
	//	private static WebDriver fDriver;
	ExtentTest test;

	@Before
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "C:/development/web_driver/chromedriver.exe");
		cDriver = new ChromeDriver();
		//fDriver = new FirefoxDriver();
	}

	@Test
	public void testGoogleSearch() throws Exception {
		// Optional, if not specified, WebDriver will search your path for chromedriver.

		try {
			ApachePOIExcelWrite excelWrite = new ApachePOIExcelWrite();
			excelWrite.init();
			ExcelUtils excelUtils = new ExcelUtils();
			excelUtils.initialise();

			cDriver.get("https://hungryhouse.co.uk/");
			cDriver.manage().window().fullscreen();
			Thread.sleep(2500); // Let the user actually see something!

			WebElement signIn = cDriver.findElement(By.xpath("/html/body/header/nav/div/div[1]/a"));
			signIn.click();
			Thread.sleep(2500);
			WebElement createAccount = cDriver.findElement(By.xpath("//*[@id=\"box-link-inside\"]/span"));
			createAccount.click();

			Thread.sleep(2500);

			WebElement enterEmail = cDriver.findElement(By.xpath("//*[@id=\"sign-up-form-join\"]"));
			enterEmail.sendKeys(excelUtils.getEmail());

			WebElement enterPassword = cDriver.findElement(By.xpath("//*[@id=\"sign-up-form-password\"]"));
			enterPassword.sendKeys(excelUtils.getPassword());

			WebElement enterPostcode = cDriver.findElement(By.name("postcode"));
			enterPostcode.sendKeys(excelUtils.getPostcode());

			Thread.sleep(5000);

			WebElement tickTerms = cDriver.findElement(By.xpath("//*[@id=\"user-join\"]/fieldset/label[1]/i"));
			tickTerms.click();

			Thread.sleep(5000);

			WebElement sumbitCreateAccount = cDriver.findElement(By.xpath("//*[@id=\"user-join\"]/fieldset/button"));
			sumbitCreateAccount.submit();

			Thread.sleep(2500);

			Screenshot screen = new Screenshot();
			screen.takeScreenshot();

			Thread.sleep(2500); // Let the user actually see something!

			// here you could assert page title or some text or by page URL you're in the
			// correct place
		} finally {
		}
	}

	@After
	public void tearDown() {
		cDriver.quit();
		//fDriver.quit();
	}

}

