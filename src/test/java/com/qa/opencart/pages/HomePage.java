package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils{

private static Logger log=LogManager.getLogger(HomePage.class.getName());
private WebDriver driver;
//create a constructor
public HomePage(WebDriver driver){
	super(driver);
	
}

@FindBy(name="search")
private WebElement searchEditbox;
@FindBy(xpath="//button[@type='button' and @class='btn btn-default btn-lg']")
private WebElement searchIcon;
@FindBy(css="div#logo>h1>a")
private WebElement openCartLogo;

@FindBy(xpath="//div[@id='top-links']/ul/li[2]/a")
private WebElement myAccountMenu;

@FindBy(linkText="Register")
private WebElement registerLink;

@FindBy(linkText="Login")
private WebElement loginLink;

public void openMyAccountMenu() throws InterruptedException {
	log.info("opening the myAccount menu");
	
	click(myAccountMenu);
}

public void navigateToRegisterPage() throws InterruptedException {
	openMyAccountMenu();
	log.info("click on Register link ");
	click(registerLink);
	
}

public void goToLoginPage() throws InterruptedException {
	openMyAccountMenu();
	log.info("clik on Login link");
	click(loginLink);
	
}

public String getOpenCartLogoText() throws InterruptedException {
	
	return getText(openCartLogo);
}

	
}

