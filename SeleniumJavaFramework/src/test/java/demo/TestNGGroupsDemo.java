package demo;

import org.testng.annotations.Test;

@Test(groups = { "AllClassTests" })
public class TestNGGroupsDemo {

	@Test(groups = { "sanity" })
	public void Test1() {
		System.out.println("This is Test 1!");
	}

	@Test(groups = { "windows.regression" })
	public void Test2() {
		System.out.println("This is Test 2!");
	}

	@Test(groups = { "linux.regression" })
	public void Test3() {
		System.out.println("This is Test 3!");
	}

	@Test
	public void Test4() {
		System.out.println("This is Test 4!");
	}
}
