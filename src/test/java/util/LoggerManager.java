package util;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * This  class Helps to generate log after reading Log4j2 configuration file.
 *
 * @author Swarnaprabha Ghosh
 */

public class LoggerManager {
    private static final Logger Log =  LogManager.getLogger(LoggerManager.class);

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}
