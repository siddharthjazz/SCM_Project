package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeManuPage {
	//WebDriver driver=null;
	@FindBy(linkText = "Add Products")
	private WebElement addproduct;

	public WebElement getAddproduct() {
		return addproduct;
		}

	public HomeManuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	//public void clickonhome() {
		//addproduct.click();
	//}
	@FindBy(linkText = "Products")
	private WebElement productclick;

	public WebElement getProductclick() {
		return productclick;
	}
	public void productClick() throws InterruptedException {
		Thread.sleep(2000);
		productclick.click();
	}
	public void addproduct(){
		addproduct.click();
	}
	
	
	
	
	
	
	
	
	
	

}
