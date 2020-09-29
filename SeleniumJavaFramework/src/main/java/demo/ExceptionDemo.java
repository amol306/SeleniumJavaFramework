package demo;
public class ExceptionDemo {

	public static void main(String[] args) throws Exception {
		Exception();
		ExceptionThrow();
	}

	public static void Exception() {
		try {
			System.out.println("Hello Exception!");
			int a = 1 / 0;
			System.out.println("Completed!");
		} catch (ArithmeticException ex) {
			System.out.println("Catch ArithmeticException!");
			System.out.println("ex.getMessage() : " + ex.getMessage());
			System.out.println("ex.getCause() : " + ex.getCause());
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Catch Exception!");
			System.out.println("ex.getMessage() : " + ex.getMessage());
			System.out.println("ex.getCause() : " + ex.getCause());
			ex.printStackTrace();
		} finally {
			System.out.println("finally!");
		}

	}

	public static void ExceptionThrow()	throws Exception {
		System.out.println("Hello Exception Throw!");
		int a = 1 / 0;
		System.out.println("Completed!");

	}
}
