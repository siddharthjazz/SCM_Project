package RetailerTestscript;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;


import com.scm.pom.HomeRetailerPage;

import com.scm.pom.LoginRetailerPage;
import com.scm.pom.OrderItemsPage;

public class RetailersTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		//WebDriver driver=null;
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
		
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLaod(driver);
		
		
		driver.get(url);
		LoginRetailerPage lp= new LoginRetailerPage(driver);
		lp.login(username,password);
		Thread.sleep(4000);
		
		HomeRetailerPage hp=new HomeRetailerPage(driver);
		//hp.clickHomeFeature(driver);
		//hp.getProdListPage().click();
		
        //hp.clickMyOrderFeature(driver);
        //hp.clickMyInvoiceFeature(driver);
        
		hp.clickNewOrderFeature(driver);
        
		//hp.clickEditProfileFeature(driver);
		
		OrderItemsPage oip=new OrderItemsPage(driver);
		oip.createAnOrder();
       
		/*
		 * EditProfilePageRetailer ep=new EditProfilePageRetailer(); ep.clearPhoneTbx();
		 * ep.clearEmailTbx(); ep.clearAddressTbx(); ep.updateProfile();
		 * ep.changePassword(); OrderItemsPage op=new OrderItemsPage(driver);
		 * op.createAnOrder();
		 */        
	}

}
