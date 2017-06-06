import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {
    List<EventLogger> eventLoggers;

    public CombinedEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    public void logEvent(Event event) throws IOException {
        for (EventLogger logger : eventLoggers) {
            logger.logEvent(event);
        }
    }
}
