package listeners;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {

	@Test
	public void Test4() {
		System.out.println("inside Test 4");
	}

	@Test
	public void Test5() {
		System.out.println("inside Test 5");
	}

	@Test
	public void Test6() {
		System.out.println("inside Test 6");
	}

}
