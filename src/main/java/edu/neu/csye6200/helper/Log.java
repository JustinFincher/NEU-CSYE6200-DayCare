package edu.neu.csye6200.helper;

import edu.neu.csye6200.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
	public static boolean verbose = true;
	private static final Logger logger = LoggerFactory.getLogger(Application.name);
//	public static void d(String str)
//	{
//		logger.debug(str);
//	}
	public static void i(String str)
	{
		logger.info(str);
	}
	public static void e(String str)
	{
		logger.error(str);
	}
}
