package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_RetailerHomePage {
	
@FindBy(linkText="New Order")
private WebElement neworder_btn;

public Admin_RetailerHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getNeworder_btn() {
	return neworder_btn;
}

public void NewOrderbtnclick() {
	neworder_btn.click();
}




}
