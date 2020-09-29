package listeners;

import org.testng.*;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("***** onTestStart for result.getName() : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("***** onTestSuccess for result.getName() : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** onTestFailure for result.getName() : " + result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("***** onStart for context.getName() : " + context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("***** onFinish for context.getName() : " + context.getName());
	}
}
