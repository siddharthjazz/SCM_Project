package AdminTestscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.AdminAddUnitPage;
import com.scm.pom.AdminHomePage;
import com.scm.pom.AdminViewUnit2Page;
import com.scm.pom.AdminViewUnitPage;
import com.scm.pom.LoginAdminPage;

public class Admin2Test {

	public static void main(String[] args) throws Throwable {
		
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wdu=new WebDriverUtility();
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
		
		LoginAdminPage lap=new LoginAdminPage(driver);
		lap.login(username, password);
		
		Thread.sleep(3000);

		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.manageunitclick();
		
		Thread.sleep(3000);
		
		AdminViewUnitPage avup=new AdminViewUnitPage(driver);
		avup.addunitclick();
		
		Thread.sleep(3000);
		
		AdminAddUnitPage aaup=new AdminAddUnitPage(driver);
		aaup.fillunitnametxt();
		
		aaup.filldetailstxt();
		
		aaup.addunitbuttonclick();
		
		wdu.acceptAlert(driver);
		
		aaup.manageunitbtnclick();
		
		AdminViewUnit2Page avu2p =new AdminViewUnit2Page(driver);
		avu2p.checkboxclick();
		
		avu2p.deleteclick();
		
		wdu.acceptAlert(driver);
		
		
		
		
	}

}
