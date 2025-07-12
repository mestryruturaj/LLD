package logging.framework.v2.enums;

public enum LogLevel {
    INFO,
    DEBUG,
    WARNING,
    ERROR,
    FATAL;

    public boolean isSevereAs(LogLevel level) {
        return this.ordinal() >= level.ordinal();
    }
}
