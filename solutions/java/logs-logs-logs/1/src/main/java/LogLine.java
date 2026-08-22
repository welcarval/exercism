import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {

    private final LogLevel logLevel;
    private final String message;

    public LogLine(String logLine) {
        String regex = "\\[([A-Z]{3})\\]: (.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logLine);
        if (matcher.find()) {
            String abbr = matcher.group(1);
            this.message = matcher.group(2);

            this.logLevel = switch (abbr) {
                case "TRC" -> LogLevel.TRACE;
                case "DBG" -> LogLevel.DEBUG;
                case "INF" -> LogLevel.INFO;
                case "WRN" -> LogLevel.WARNING;
                case "ERR" -> LogLevel.ERROR;
                case "FTL" -> LogLevel.FATAL;
                default -> LogLevel.UNKNOWN;
            };
        } else {
            this.message = logLine;
            this.logLevel = LogLevel.UNKNOWN;
        }
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", this.logLevel.getNum(), this.message);
    }
}
