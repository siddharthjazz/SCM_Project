package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	@FindBy(linkText="Manage Unit")
	private WebElement manageunitbtn;
	
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getManageunitbtn() {
		return manageunitbtn;
	}
	
	public void manageunitclick() {
		manageunitbtn.click();
	}

}
