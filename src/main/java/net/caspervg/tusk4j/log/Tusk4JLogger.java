package net.caspervg.tusk4j.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tusk4JLogger {

    public static void log(Level level, String message) {
        Logger.getLogger("Tusk4J").log(level, message);
    }

    public static void log(Level level, String message, Throwable throwable) {
        Logger.getLogger("Tusk4J").log(level, message, throwable);
    }

}
