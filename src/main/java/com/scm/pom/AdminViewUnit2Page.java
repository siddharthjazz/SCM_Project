package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewUnit2Page {
	
	@FindBy(xpath="(//input[@name='chkId[]'])[last()]")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deletebtn;
	
	@FindBy(xpath="(//td[5])[last()]")
	private WebElement editbtn;
	
	public AdminViewUnit2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	
	
	public WebElement getCheckbox() {
		return checkbox;
	}



	public WebElement getDeletebtn() {
		return deletebtn;
	}



	public WebElement getEditbtn() {
		return editbtn;
	}



	public void checkboxclick() {
		checkbox.click();
	}
	
	public void deleteclick() {
		deletebtn.click();
	}
	
	public void editclick() {
		editbtn.click();
	}

}
