package ManufacturerTestscript;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.LoginManuPage;

public class LoginTest {
	public static void main(String[] args) throws Throwable {
	ExcelUtility eu = new ExcelUtility();
	DatabaseUtility du = new DatabaseUtility();
	FileUtility fu = new FileUtility();
	JavaUtility ju = new JavaUtility();
	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver=null;
	
	String browser=fu.readDataFromPropertyFile("browser");
	String url=fu.readDataFromPropertyFile("url");
	String username=fu.readDataFromPropertyFile("username");
	String password=fu.readDataFromPropertyFile("password");
	
	
	if(browser.equals("Firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	
	wu.waitForPageLaod(driver);
	
	driver.get(url);
	LoginManuPage lp =new LoginManuPage(driver);
	lp.login(username,password);
	
	
	
		
	
	}
	
	
	

}
