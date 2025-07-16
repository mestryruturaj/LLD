package cases.logging.framework.v2.logger;

import cases.logging.framework.v2.enums.LogLevel;
import cases.logging.framework.v2.dispatcher.ConsoleLogDispatcher;
import cases.logging.framework.v2.dispatcher.FileLogDispatcher;

public class LoggerFactory {
    public Logger getConsoleLogger(LogLevel minimumLogLevel) {
        return new ConsoleLogger(minimumLogLevel, new ConsoleLogDispatcher());
    }

    public Logger getFileLogger(LogLevel minimumLogLevel, String path) {
        return new FileLogger(minimumLogLevel, new FileLogDispatcher(path));
    }
}
