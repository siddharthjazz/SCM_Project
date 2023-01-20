package ManufacturerTestscript;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.pom.AddProductPage;
import com.scm.pom.EditProductPage;
import com.scm.pom.HomeManuPage;
import com.scm.pom.LoginManuPage;


public class ManufacturerTest {

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
		
		LoginManuPage lp= new LoginManuPage(driver);
		lp.login(username,password);
		Thread.sleep(2000);
		
		HomeManuPage hp=new HomeManuPage(driver);
		hp.addproduct();
		//hp.clickonhome();
		//hp.productClick();
		Thread.sleep(2000);
		
		AddProductPage ap=new AddProductPage(driver);
		ap.addproducts();
		Thread.sleep(2000);
		
		hp.productClick();
		
		EditProductPage ep=new EditProductPage(driver);
		ep.editProduct();
		ep.updateproduct();
	}

}
