package RetailerTestscript;

import org.testng.annotations.Test;

import com.scm.GenericUtilities.SCMRetailerBaseClass;
import com.scm.pom.HomeRetailerPage;
import com.scm.pom.OrderItemsPage;

public class ExecuteRetailersTestusingBaseClass extends SCMRetailerBaseClass{
	
	@Test(groups={"smoke","regression"})
	public void executeRetailer (){
		
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
	
	


