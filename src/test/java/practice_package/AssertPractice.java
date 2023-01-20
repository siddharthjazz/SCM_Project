package practice_package;

import static org.testng.Assert.assertNull;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	
	@Test
	public void Sample_1() {
		System.out.println("Testscript 1");
		System.out.println("Testscript 2");
		Assert.assertEquals("A", "B");
		System.out.println("Testscript 3");
		System.out.println("Testscript 4");
	}
	
	@Test
	public void Sample_2() {
		System.out.println("Testscript 5");
		System.out.println("Testscript 6");
		Assert.assertNotEquals("A","B" );
		System.out.println("Testscript 7");
		System.out.println("Testscript 8");
	}

	@Test
	public void Sample_3() {
		String a=null;
		assertNull(a);
		System.out.println("-----");
	}
	
	@Test
	public void Sample_4() {
		System.out.println(" test 9");
		SoftAssert so=new SoftAssert();
		so.assertEquals("X", "Y");
		System.out.println("test 10");
		so.assertAll();
	}
}
