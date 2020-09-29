package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {

	@Test
	public void Test1() {
		System.out.println("This is Test 1!");
	}

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void Test2() {
		System.out.println("This is Test 2!");
		int a = 10 / 0;
	}

	@Test
	public void Test3() {
		System.out.println("This is Test 3!");
		Assert.assertTrue(false);

	}
}
