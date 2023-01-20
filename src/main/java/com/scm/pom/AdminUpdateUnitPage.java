package com.scm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUpdateUnitPage {
	
	@FindBy(id="unitName")
private WebElement unitnametxt;
	
	@FindBy(id="unitDetails")
	private WebElement unitdetailstxt;
	
	
	@FindBy(xpath="//input[@value='Update Unit']")
	private WebElement updateunitbtn;
	
	public AdminUpdateUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	



	public WebElement getUnitnametxt() {
		return unitnametxt;
	}







	public WebElement getUnitdetailstxt() {
		return unitdetailstxt;
	}







	public WebElement getUpdateunitbtn() {
		return updateunitbtn;
	}







	public void fillunitname() {
		unitnametxt.sendKeys("pcs");
		
	}
	
	public void filldetails() {
		unitdetailstxt.sendKeys("pieces");
	}
	
	public void updateunitclick() {
		updateunitbtn.click();
		
	}
	
	}
	
	//td[text()=' kg ']/../td/input[@name='chkId[]']

