package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependenciesDemo {

	// @Test(dependsOnMethods = { "test2", "test3" })
	@Test(dependsOnGroups = { "group.*" })
	public void test1() {
		System.out.println("inside test 1");
	}

	@Test(groups = "group")
	public void test2() {
		System.out.println("inside test 2");
	}

	@Test(groups = "group2")
	public void test3() {
		System.out.println("inside test 3");
		// Assert.assertTrue(false);
	}
}
