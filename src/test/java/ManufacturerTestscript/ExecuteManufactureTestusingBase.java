package ManufacturerTestscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.SCMBaseClass;
import com.scm.pom.AddProductPage;
import com.scm.pom.EditProductPage;
import com.scm.pom.HomeManuPage;
import com.scm.pom.LoginManuPage;
@Listeners(com.scm.GenericUtilities.ListenerImplementationClass.class)
public class ExecuteManufactureTestusingBase extends SCMBaseClass{

	@Test(groups="Regression")
	public void executeManufacture() throws Throwable {
		
		HomeManuPage hp=new HomeManuPage(driver);
		hp.addproduct();
		//hp.clickonhome();
		//hp.productClick();
		Thread.sleep(2000);
		
		AddProductPage ap=new AddProductPage(driver);
		ap.addproducts();
		Thread.sleep(2000);
		
		hp.productClick();
		Assert.fail();
		EditProductPage ep=new EditProductPage(driver);
		ep.editProduct();
		ep.updateproduct();
	}


}
