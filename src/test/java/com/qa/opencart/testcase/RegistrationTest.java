package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.factory.WebDriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class RegistrationTest extends TestBase{
	private Logger log=LogManager.getLogger(RegistrationTest.class.getName());
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  log.info("initialising the page class objects");
	  homePg=new HomePage(driver);
	  regPg=new RegistrationPage(driver);
	 homePg.navigateToRegisterPage(); 
	   myaccountPg=new MyAccountPage(driver); 
  }

  @Test
  public void registrationTest() throws InterruptedException {
	 try {
		log.info("Verify the Registration page title");
		 regPg.waitForPageLoad(2000);
		 Assert.assertEquals(regPg.getTitle(), Constants.REGISTRATION_PAGE_TITLE);
		 String fname=WebDriverFactory.randomeString();
		 log.info("setting the first name:"+fname);
		 regPg.setFirstName(fname);
		 String lname=WebDriverFactory.randomeString();
		 log.info("setting the last name:"+lname);
		 regPg.setLastName(lname);
		 String email=WebDriverFactory.randomeString()+"@gmail.com";
		 log.info("setting the email:"+email);
		 regPg.setEmail(email);
		 String telephone=WebDriverFactory.randomeNumber();
		 log.info("setting the telephone:"+telephone);
		 regPg.setTelePhone(telephone);
		 String pwd=WebDriverFactory.randomAlphaNumeric();
		 log.info("setting the password value is:"+pwd);
		 regPg.setPassword(pwd);
		 regPg.setConfirmPassword(pwd);
		 log.info("select the subscribe option yes");
		 regPg.selectSubScribe("Yes");
		 log.info("check the Privacy policy checkbox");
		 regPg.checkAgreeCheckbox();
		 log.info("Click on Continue button");
		 regPg.clickContinueBtn();
		 regPg.waitForPageLoad(2000);
		 log.info("verify the Account Creation success message and  header ");
		 Assert.assertEquals(regPg.getAccountCreatedHeader(), Constants.YOUR_ACCNT_CREATED_HEADER);
		 Assert.assertEquals(regPg.getAccountCreatedSuccMsg(), Constants.YOUR_ACCNT_CREATED_SUCC_MSG);
		 log.info("click on Account Created Continue button");
		 regPg.clickAccountCreatedContinueBtn();
		 log.info("validate the my Account Page title");
		Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	} catch (InterruptedException e) {
		log.info("Account creation failed");
		e.printStackTrace();
	}
  
  }
  
  
}
