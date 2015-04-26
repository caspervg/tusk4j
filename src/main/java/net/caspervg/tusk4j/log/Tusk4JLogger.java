package net.caspervg.tusk4j.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a logger for possible network exceptions that Tusk4J might encounter
 */
public class Tusk4JLogger {

    /**
     * Logs a message with a certain level
     *
     * @param level Severity of the log message
     * @param message Message to log
     */
    public static void log(Level level, String message) {
        Logger.getLogger("Tusk4J").log(level, message);
    }

    /**
     * Logs a message and exception with a certain level
     * @param level Severity of the exception/message
     * @param message Message to log
     * @param throwable Exception to log
     */
    public static void log(Level level, String message, Throwable throwable) {
        Logger.getLogger("Tusk4J").log(level, message, throwable);
    }
}
