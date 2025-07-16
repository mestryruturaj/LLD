package cases.logging.framework.v2.logger;

import cases.logging.framework.v2.enums.LogLevel;
import cases.logging.framework.v2.dispatcher.LogDispatcher;

public class FileLogger extends Logger {
    public FileLogger(LogLevel minimumLogLevel, LogDispatcher logDispatcher) {
        super(minimumLogLevel, logDispatcher);
    }
}
