package com.qa.opencart.testcase;

import org.testng.annotations.Test;
import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class HomePageTest extends TestBase {
	private Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeClass
	public void beforeClass() {
		homepg = new HomePage(driver);
		regPg = new RegistrationPage(driver);
		loginPg = new LoginPage(driver);
	}

	@BeforeMethod
	public void setup() {
		homepg.waitForPageLoad(3000);
	}

	@Test(description = "verifying the opecart logo", priority = 1, alwaysRun = true)
	public void opencartLogoTest() throws InterruptedException {
		log.info("Running opencartLogoTest...");
		try {

			String actLogoTxt = homepg.getOpenCartLogoText();
			System.out.println(actLogoTxt);
			Assert.assertEquals(actLogoTxt, "Your Store");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "verifying the opecart Home page title", priority = 5)
	public void opencartTitleTest() throws InterruptedException {
		Assert.assertEquals(loginPg.getTitle(), "Your Store");
	}

	@Test(description = "navigate to registration page and then naviagte to the opecart Home page", priority = 2)
	public void navigateToRegisterTest() throws InterruptedException {
		try {
			homepg.navigateToRegisterPage();
			regPg.waitForPageLoad(3000);
			Assert.assertEquals(loginPg.getTitle(), "Register Account");
			regPg.clickHomeIcon();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "navigate to home page and then naviagte to the opecart Home page", priority = 3)
	public void navigateToLoginTest() throws InterruptedException {
		try {
			homepg.goToLoginPage();
			loginPg.waitForPageLoad(2000);
			Assert.assertEquals(loginPg.getTitle(), "Account Login");
			loginPg.clickHomeIcon();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		Assert.assertEquals(loginPg.getTitle(), "Your Store");
		homepg.waitForPageLoad(2000);
	}
}