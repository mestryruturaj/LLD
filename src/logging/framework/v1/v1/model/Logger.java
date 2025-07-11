package logging.framework.v1.v1.model;

import logging.framework.v1.v1.enums.Destination;
import logging.framework.v1.v1.enums.Level;

import java.sql.Timestamp;

public interface Logger {
    public void debug(String message);
    public void info(String message);
    public void warning(String message);
    public void error(String message);
    public void fatal(String message);

    default void print(Timestamp timestamp, Destination destination, Level level, Class<?> clazz, String message) {
        System.out.printf("[%s] [%s] [%s] [%s]: %s%n", timestamp.toString(), destination.name(), level.name(), clazz.getName(), message);
    }
}
