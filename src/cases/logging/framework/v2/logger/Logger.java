package cases.logging.framework.v2.logger;

import cases.logging.framework.v2.enums.LogLevel;
import cases.logging.framework.v2.dispatcher.LogDispatcher;

public abstract class Logger {
    private final LogLevel minimumLogLevel;
    private final LogDispatcher logDispatcher;
    private boolean isShutdown;

    public Logger(LogLevel minimumLogLevel, LogDispatcher logDispatcher) {
        this.minimumLogLevel = minimumLogLevel;
        this.logDispatcher = logDispatcher;
    }

    public void log(LogLevel logLevel, String message) {
        if (isShutdown) {
            throw new RuntimeException("RESOURCE_CLOSED");
        }
        if (!logLevel.isSevereAs(minimumLogLevel)) return;
        LogMessage logMessage = new LogMessage(logLevel, message);
        logDispatcher.dispatch(logMessage.format());
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    public void shutdown() {
        isShutdown = true;
        logDispatcher.shutdown();
    }
}
