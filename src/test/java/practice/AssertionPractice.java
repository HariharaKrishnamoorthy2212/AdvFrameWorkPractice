package practice;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class AssertionPractice {

	@Test
	public void practice() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals(1, 1);
		System.out.println("step4");
	}
	
	@Test
	public void practice1() {
		SoftAssert sa=new SoftAssert();
		System.out.println("step1");
		sa.assertEquals(true,true);
		System.out.println("step2");
		sa.assertEquals("B","A");
		System.out.println("step3");
		sa.assertAll();
	
	}
}
