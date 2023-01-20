package practice_package;

import org.testng.annotations.Test;

public class GroupTestNG4 {
	
	@Test(groups="regression")
	public void simple7() {
		System.out.println("test 7");
	}
	
	@Test(groups="smoke")
	public void simple8() {
		System.out.println("test 8");
	}

}
