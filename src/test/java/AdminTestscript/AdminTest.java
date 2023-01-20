package AdminTestscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.pom.Admin_RetailerHomePage;
import com.scm.pom.Admin_Retailer_MyOrdersPage;
import com.scm.pom.Admin_Retailer_OrderItemsPage;
import com.scm.pom.LoginAdminPage;


import com.scm.pom.LoginRetailerPage;


public class AdminTest {

	public static void main(String[] args) throws Throwable {
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
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
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginRetailerPage lpr=new LoginRetailerPage(driver);
		lpr.login(username, password);
		
		Thread.sleep(4000);
		
		Admin_RetailerHomePage arh=new Admin_RetailerHomePage(driver);
		arh.NewOrderbtnclick();
		
		Admin_Retailer_OrderItemsPage aro=new Admin_Retailer_OrderItemsPage(driver);
		aro.enterquantity();
		aro.postorderclick();
		
		Admin_Retailer_MyOrdersPage arm=new Admin_Retailer_MyOrdersPage(driver);
		arm.logoutclick();
        
        
        
        


	}	

}
