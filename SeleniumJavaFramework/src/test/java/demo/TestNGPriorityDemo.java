package demo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {

	@Test(priority = 1)
	public void Test1() {
		System.out.println("inside Test 1");
	}

	@Test
	public void Zest2() {
		System.out.println("inside Test 2");
	}

	@Test
	public void Test3() {
		System.out.println("inside Test 3");
	}
}
