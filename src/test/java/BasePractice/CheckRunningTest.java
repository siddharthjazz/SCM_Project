package BasePractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.pom.AddProductPage;
import com.scm.pom.EditProductPage;
import com.scm.pom.HomePageManu;
import com.scm.pom.LoginPageManu;

public class CheckRunningTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
		
		LoginPageManu lp= new LoginPageManu(driver);
		lp.login(username,password);
		Thread.sleep(4000);
		
		HomePageManu hp=new HomePageManu(driver);
		hp.addproduct();
		//hp.clickonhome();
		//hp.productClick();
		Thread.sleep(40000);
		
		AddProductPage ap=new AddProductPage(driver);
		ap.addproducts();
		Thread.sleep(40000);
		
		EditProductPage ep=new EditProductPage(driver);
		ep.editProduct();
		ep.updateproduct();

	}

}
