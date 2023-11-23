package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(enabled=false)
	public void sample() {
		System.out.println("hello");
	}

	@Test
	public void sample1() {
		System.out.println("Fail");
	}
	
	@Test
	public void sample2() {
		Assert.fail();
		System.out.println("Faile2");
	}

	
}
