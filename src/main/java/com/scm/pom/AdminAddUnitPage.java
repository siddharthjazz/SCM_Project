package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddUnitPage {
	
	@FindBy(id="unitName")
	private WebElement unitnametxt;
	
	@FindBy(id="unitDetails")
	private WebElement detailstxt;
	
	@FindBy(xpath="//input[@value='Add Unit']")
	private WebElement addunitbutton;
	
	@FindBy(linkText="Manage Unit")
	private WebElement manageunitbtn;
	
	public AdminAddUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	



	public WebElement getUnitnametxt() {
		return unitnametxt;
	}







	public WebElement getDetailstxt() {
		return detailstxt;
	}







	public WebElement getAddunitbutton() {
		return addunitbutton;
	}







	public WebElement getManageunitbtn() {
		return manageunitbtn;
	}







	public void fillunitnametxt() {
		unitnametxt.sendKeys("KG");
	}
	
	public void filldetailstxt() {
		detailstxt.sendKeys("Kilogram");
	}
	
	public void addunitbuttonclick() {
		addunitbutton.click();
	}
	
	public void manageunitbtnclick() {
		manageunitbtn.click();
	}
	

}
