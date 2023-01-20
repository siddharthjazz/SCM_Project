package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Retailer_MyOrdersPage {
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbtn;
	
	public Admin_Retailer_MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public void logoutclick() {
		logoutbtn.click();
	}

}
