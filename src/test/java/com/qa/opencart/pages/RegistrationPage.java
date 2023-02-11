package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class RegistrationPage extends WebDriverUtils{
	JavaScriptUtils jsUtils;
	private Logger log=LogManager.getLogger(RegistrationPage.class.getName());
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		jsUtils=new JavaScriptUtils(driver);
	}

	@FindBy(css="h1")
	private WebElement registerAccntHeader;
	
	@FindBy(css="div#content>p")
	private WebElement registerAccntStaticTxt;
	
	@FindBy(css="css=div#content>p>a")
	private WebElement registerAccntLoginPageLink;
	
	@FindBy(css="fieldset#account>legend")
	private WebElement registerAccntLegendTxt;
	@FindBy(id="input-firstname")
	private WebElement firstNameEditbox;
	@FindBy(name="lastname")
	private WebElement lastNameEditbox;
	@FindBy(id="input-email")
	private WebElement emailEditbox;
	@FindBy(css="#input-telephone")
	private WebElement telephoneEditbox;
	
	@FindBy(css="#input-password")
	private WebElement passwordEditbox;
	@FindBy(css="input[id='input-confirm']")
	private WebElement passwordConfirmEditbox;
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement subscribeYesRadioBtn;
	@FindBy(xpath="//input[@name='newsletter' and @value='0']")
	private WebElement subscribeNoRadioBtn;
	@FindBy(css="a.agree")
	private WebElement privacyPolicyLink;
	@FindBy(css="input[name='agree']")
	private WebElement privacyPolicyCheckbox;
	@FindBy(css="input.btn.btn-primary")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//i[contains(@class,'fa fa-home')]")
	private WebElement regHomeIcon;
	
	public void setFirstName(String fname) throws InterruptedException {
		log.info("enetering the firstname value");
		sendData(firstNameEditbox, fname);
	}
	
	public void setLastName(String lname) throws InterruptedException {
		log.info("enetering the larstname value");
		sendData(lastNameEditbox, lname);
	}
	
	public void setEmail(String email) throws InterruptedException {
		log.info("enetering the email value");
		sendData(emailEditbox, email);
	}
	public void setTelePhone(String telephone) throws InterruptedException {
		log.info("enetering the telephone value");
		sendData(telephoneEditbox, telephone);
	}
	public void setPassword(String pwd) throws InterruptedException {
		log.info("enetering the pwd value");
		sendData(passwordEditbox, pwd);
	}
	public void setConfirmPassword(String confirmPwd) throws InterruptedException {
		log.info("enetering the confirm value");
		sendData(passwordConfirmEditbox, confirmPwd);
	}
	public void selectSubScribe(String subScribe) throws InterruptedException {
		log.info("enetering the subscribe value");
		if(subScribe.equalsIgnoreCase("Yes")) {
			log.info("select Yes radio buton");
			click(subscribeYesRadioBtn);
		}else {
			log.info("select No radio buton");
			click(subscribeNoRadioBtn);
		}
	}
	public void checkAgreeCheckbox() throws InterruptedException {
		log.info("check Agree Checkbox");
		check(privacyPolicyCheckbox);
	}
	public void clickContinueBtn() throws InterruptedException {
		log.info("click on Continue button");
		click(continueBtn);
	}
	public void clickHomeIcon() throws InterruptedException {
		log.info("clickHomeIcon");
		jsUtils.clickElementByJS(regHomeIcon);
	}
}



