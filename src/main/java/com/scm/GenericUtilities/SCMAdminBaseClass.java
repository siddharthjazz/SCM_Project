package com.scm.GenericUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.scm.pom.HomeManuPage;
import com.scm.pom.LoginAdminPage;
import com.scm.pom.LoginManuPage;

public class SCMAdminBaseClass {

	public WebDriver driver;
	public DatabaseUtility du=new DatabaseUtility();
	public ExcelUtility eu=new ExcelUtility();
	public FileUtility fu=new FileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void connectDB() throws SQLException {
		//connect to DB
		du.connectToDB();
		System.out.println("----connect to DB----");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void launchbrowser() throws Throwable {
		//launching the browser
		String Browser=fu.readDataFromPropertyFile("browser");
		String URL =fu.readDataFromPropertyFile("url");
		if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			}
		else if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		wdu.maximizeWindow(driver);
		wdu.waitForPageLaod(driver);
		driver.get(URL);
		
		
		
		System.out.println("----launch or open the browser");
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void login() throws Throwable
	{
		String USERNAME=fu.readDataFromPropertyFile("username");
		String PASSWORD =fu.readDataFromPropertyFile("password");
		
		LoginAdminPage lap=new LoginAdminPage(driver);
		lap.login(USERNAME, PASSWORD);
		System.out.println("----login to app----");
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void logout() {
		HomeManuPage hmp=new HomeManuPage(driver);
		
	}
	@AfterClass(groups= {"smoke","regression"})
	public void closebrowser() {
		//driver.quit();
		System.out.println("-----close the browser-----");
	}
	
	@AfterSuite(groups= {"smoke","regression"})
	public void disconnectdB() {
		//du.closeDB();
		System.out.println("---disconnected from dB---");
	}
}
