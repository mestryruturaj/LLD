package logging.framework.v2.logger;

import logging.framework.v2.enums.LogLevel;
import logging.framework.v2.dispatcher.LogDispatcher;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(LogLevel minimumLogLevel, LogDispatcher logDispatcher) {
        super(minimumLogLevel, logDispatcher);
    }
}
