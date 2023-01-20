package practice_package;

import org.testng.annotations.Test;

public class GroupTestNG3 {
	
	@Test(groups= {"smoke","regression"})
	public void simple5() {
		System.out.println("test 5");
	}
	
	@Test(groups="system")
	public void simple6() {
		System.out.println("test 6");
	}

}
