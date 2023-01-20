package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.scm.GenericUtilities.WebDriverUtility;

public class AddProductPage extends WebDriverUtility {
	WebDriverUtility wdu=new WebDriverUtility();
	@FindBy(id="product:name")
	private WebElement productname;
	@FindBy(id="product:price")
	private WebElement productprice;
	@FindBy(id="product:description")
	private WebElement productdescription;
@FindBy(id="product:unit")
private WebElement selectunit;
@FindBy(id="product:category")
private WebElement selectcategory;
@FindBy(xpath = "(//input[@name='rdbStock'])[1]")
private WebElement enable;
@FindBy(xpath = "//input[@value='Add Product']")
private WebElement clickonaddproduct;
public WebElement getEnable() {
	return enable;
}

public WebElement getClickonaddproduct() {
	return clickonaddproduct;
}

public AddProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

public void addproducts() throws InterruptedException {
	productname.sendKeys("veg puff");
	productprice.sendKeys("5");
	productdescription.sendKeys("order successfully");
	wdu.select("KG",selectunit );
	Thread.sleep(2000);
	wdu.select(selectcategory, "3");
	enable.click();
	clickonaddproduct.click();
}

public WebDriverUtility getWdu() {
	return wdu;
}

public WebElement getProductname() {
	return productname;
}

public WebElement getProductprice() {
	return productprice;
}

public WebElement getProductdescription() {
	return productdescription;
}

public WebElement getSelectunit() {
	return selectunit;
}

public WebElement getSelectcategory() {
	return selectcategory;
}


		
		
	}

