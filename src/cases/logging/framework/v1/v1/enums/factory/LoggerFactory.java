package cases.logging.framework.v1.v1.enums.factory;

import cases.logging.framework.v1.v1.enums.Destination;
import cases.logging.framework.v1.v1.model.ConsoleLogger;
import cases.logging.framework.v1.v1.model.DatabaseLogger;
import cases.logging.framework.v1.v1.model.FileLogger;
import cases.logging.framework.v1.v1.model.Logger;

import static cases.logging.framework.v1.v1.enums.Destination.*;

public class LoggerFactory {
    public Logger getLogger(Destination destination, Class<?> clazz) {
        if (CONSOLE.equals(destination)) {
            return ConsoleLogger.getInstance(clazz);
        } else if (FILE.equals(destination)) {
            return FileLogger.getInstance(clazz);
        } else if (DATABASE.equals(destination)) {
            return DatabaseLogger.getInstance(clazz);
        }
        throw new RuntimeException("Invalid type of logger.");
    }
}
