package cases.logging.framework.v1.v1.model;

import cases.logging.framework.v1.v1.enums.Destination;
import cases.logging.framework.v1.v1.enums.Level;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FileLogger implements Logger {
    private static Logger INSTANCE;
    private Class<?> clazz;

    private FileLogger(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void debug(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.FILE, Level.DEBUG, clazz, message);
    }

    @Override
    public void info(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.FILE, Level.INFO, clazz, message);
    }

    @Override
    public void warning(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.FILE, Level.WARNING, clazz, message);
    }

    @Override
    public void error(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.FILE, Level.ERROR, clazz, message);
    }

    @Override
    public void fatal(String message) {
        print(Timestamp.valueOf(LocalDateTime.now()), Destination.FILE, Level.FATAL, clazz, message);
    }

    public static Logger getInstance(Class<?> clazz) {
        if (INSTANCE == null) {
            synchronized (FileLogger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FileLogger(clazz);
                }
            }
        }

        return INSTANCE;
    }
}
