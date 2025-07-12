package logging.framework.v2;

import logging.framework.v2.enums.LogLevel;
import logging.framework.v2.logger.Logger;
import logging.framework.v2.logger.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger consoleLogger = loggerFactory.getConsoleLogger(LogLevel.INFO);

        consoleLogger.info("Info logging");
        consoleLogger.debug("debug logging");
        consoleLogger.warning("warning logging");
        consoleLogger.error("Error logging");
        consoleLogger.fatal("Fatal logging");

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd"));
        String path = String.format("src/logging/framework/v2/out/logs/%s.log", date);
        Logger fileLogger = loggerFactory.getFileLogger(LogLevel.WARNING, path);
        fileLogger.info("Info logging");
        fileLogger.debug("debug logging");
        fileLogger.warning("warning logging");
        fileLogger.error("Error logging");
        fileLogger.fatal("Fatal logging");

        consoleLogger.shutdown();
        fileLogger.shutdown();

        try {
            consoleLogger.fatal("Logging after a shutdown");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        try {
            fileLogger.fatal("Logging after a shutdown");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
