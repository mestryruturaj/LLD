package cases.logging.framework.v1.v1;

import cases.logging.framework.v1.v1.enums.Destination;
import cases.logging.framework.v1.v1.enums.Level;
import cases.logging.framework.v1.v1.enums.factory.LoggerFactory;
import cases.logging.framework.v1.v1.model.Logger;

import static cases.logging.framework.v1.v1.enums.Level.WARNING;

public class Client {
    public static void main(String[] args) {
        Level level = WARNING;
        Destination destination = Destination.CONSOLE;

        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.getLogger(destination, Client.class);

        logger.info("Hello world.");
        logger.debug("Am from expected level?");
    }
}
