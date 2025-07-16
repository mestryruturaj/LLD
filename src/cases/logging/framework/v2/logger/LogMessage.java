package cases.logging.framework.v2.logger;

import cases.logging.framework.v2.enums.LogLevel;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LogMessage {
    private LogLevel logLevel;
    private String message;
    private Timestamp timestamp;
    private String threadName;

    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.threadName = Thread.currentThread().getName();
    }

    public String format() {
        return String.format("[%s] [%7s] [%s]: %s",
                timestamp, logLevel, threadName, message);
    }
}
