package AdminTestscript;

import org.testng.annotations.Test;

import com.scm.GenericUtilities.SCMBaseClass;
import com.scm.GenericUtilities.SCMRetailerBaseClass;
import com.scm.pom.Admin_RetailerHomePage;
import com.scm.pom.Admin_Retailer_MyOrdersPage;
import com.scm.pom.Admin_Retailer_OrderItemsPage;

public class ExecuteAdminTestusingBaseClass extends SCMRetailerBaseClass{
	
	@Test(groups="smoke")
	public void executeAdmin() {
		
		Admin_RetailerHomePage arh=new Admin_RetailerHomePage(driver);
		arh.NewOrderbtnclick();
		
		Admin_Retailer_OrderItemsPage aro=new Admin_Retailer_OrderItemsPage(driver);
		aro.enterquantity();
		aro.postorderclick();
		
		
	}
	@Test(groups="smoke")
	public void sample() {
		System.out.println("Hello");
	}
	

}
