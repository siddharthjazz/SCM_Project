package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Retailer_OrderItemsPage {
	
	@FindBy(id="1")
	private WebElement firsttextbtn;
	
	@FindBy(id="btnSubmit")
	private WebElement postorderbtn;
	
	public Admin_Retailer_OrderItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirsttextbtn() {
		return firsttextbtn;
	}

	public WebElement getPostorderbtn() {
		return postorderbtn;
	}
	
	public void enterquantity() {
		firsttextbtn.sendKeys("7");
	}
	
	public void postorderclick() {
	postorderbtn.click();
	}
	

}
