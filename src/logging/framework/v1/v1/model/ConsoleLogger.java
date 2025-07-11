package logging.framework.v1.v1.model;

import logging.framework.v1.v1.enums.Destination;
import logging.framework.v1.v1.enums.Level;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    private static Logger INSTANCE;
    private Class<?> clazz;

    private ConsoleLogger(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void debug(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.CONSOLE, Level.DEBUG, clazz, message);
    }

    @Override
    public void info(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.CONSOLE, Level.INFO, clazz, message);
    }

    @Override
    public void warning(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.CONSOLE, Level.WARNING, clazz, message);
    }

    @Override
    public void error(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.CONSOLE, Level.ERROR, clazz, message);
    }

    @Override
    public void fatal(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.CONSOLE, Level.FATAL, clazz, message);
    }

    public static Logger getInstance(Class<?> clazz) {
        if (INSTANCE == null) {
            synchronized (ConsoleLogger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConsoleLogger(clazz);
                }
            }
        }

        return INSTANCE;
    }
}
