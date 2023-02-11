package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class MyAccountPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(MyAccountPage.class.getName());
	JavaScriptUtils jsUtils;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		jsUtils=new JavaScriptUtils(driver) ;
	}
	//ul[@class='breadcrumb']/li[2]/a[text()='Account']
	//ul.breadcrumb>li:nth-child(2)>a
	@FindBy(css="ul.breadcrumb>li:nth-child(2)>a")
	private WebElement myaccountBreadcrumb;
	@FindBy(css="div#content>p")
	private WebElement accountLoggedOffMsg;
	@FindBy(css="a.btn.btn-primary")
	private WebElement continueBtn;

}