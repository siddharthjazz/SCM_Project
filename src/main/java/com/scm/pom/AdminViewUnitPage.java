package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewUnitPage {

	@FindBy(xpath="(//input[@type='button'])[2]")
	private WebElement addunitbtn;
	
	public AdminViewUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddunitbtn() {
		return addunitbtn;
	}
	
	public void addunitclick() {
		addunitbtn.click();
	}
	
}
