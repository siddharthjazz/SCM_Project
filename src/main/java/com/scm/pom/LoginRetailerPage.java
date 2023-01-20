package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.GenericUtilities.WebDriverUtility;

public class LoginRetailerPage extends WebDriverUtility {
	//declaration
		//WebDriverUtility wdu=new WebDriverUtility();
		
		@FindBy(id="login:username")
		private WebElement un;
		
		@FindBy(id="login:password")
		private WebElement pw;
		
		@FindBy(id="login:type")
		private WebElement logintypeDD;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement login;
		
		//initialization
		
		public LoginRetailerPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//utilization

		public WebElement getUn() {
			return un;
		}

		public WebElement getPw() {
			return pw;
		}

		public WebElement getLogintypeDD() {
			return logintypeDD;
		}

		public WebElement getLogin() {
			return login;
		}

		//login
		
		public void login(String username,String password) throws InterruptedException {
			un.sendKeys(username);
			pw.sendKeys(password);
			Thread.sleep(2000);
			select("Retailer", logintypeDD);
			login.click();
			
		}
		

}
