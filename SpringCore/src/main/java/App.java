import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {
    private EventLogger eventLogger;
    private Client client;
    private CacheFileEventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, CacheFileEventLogger cacheFileEventLogger, Map<EventType, EventLogger> loggers) {
        defaultLogger = cacheFileEventLogger;
        this.client = client;
        this.loggers = loggers;


    }


    public void logEvent(Event event, EventType eventType) throws IOException {
        EventLogger eventLogger = loggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger;
        }
        String message = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event1 = (Event) ctx.getBean("event");
        event1.setMsg("some event for user 1");
        Event event2 = (Event) ctx.getBean("event");
        event2.setMsg("some event for user 2");
        app.logEvent(event1, EventType.ERROR);
        app.logEvent(event2, EventType.INFO);
        System.out.println(app.client.getGreeting());
        ctx.close();
    }


}
