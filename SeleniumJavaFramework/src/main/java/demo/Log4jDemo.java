package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("Log Demo. \n");
		
		logger.trace("Trace Message 1. \n");
		logger.info("info 1. \n");
		logger.error("error 2. \n");
		logger.warn("warn 3. \n");
		logger.fatal("fatal 4. \n");
		
		System.out.println("Log Demo completed. \n");
	}

}
