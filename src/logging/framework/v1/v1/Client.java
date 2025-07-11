package logging.framework.v1.v1;

import logging.framework.v1.v1.enums.Destination;
import logging.framework.v1.v1.enums.Level;
import logging.framework.v1.v1.enums.factory.LoggerFactory;
import logging.framework.v1.v1.model.Logger;

import static logging.framework.v1.v1.enums.Level.WARNING;

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
