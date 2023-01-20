package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProductsPage {
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[8]")
	private WebElement editbutton;
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[1]")
	private WebElement checkbox;
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement clickdelete;
	public WebElement getClickdelete() {
		return clickdelete;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	public void ViewProducts(WebDriver driver) {
	PageFactory.initElements(driver, this);	

	}
	public WebElement getEditbutton() {
		return editbutton;
		
	}
	public void editbutton() {
		editbutton.click();
	}
	public void checkbox() {
		checkbox.click();
		clickdelete.click();
	}


}
