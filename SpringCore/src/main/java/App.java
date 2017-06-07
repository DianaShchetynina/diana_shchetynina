import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.IOException;
import java.util.Map;

public class App {
    @Autowired
    private Client client;

    @Autowired
    private CacheFileEventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;
    private JdbcTemplate jdbcTemplate;
    public App(Client client,
               CacheFileEventLogger cacheFileEventLogger,
               Map<EventType, EventLogger> loggers,
               JdbcTemplate jdbcTemplate) {
        defaultLogger = cacheFileEventLogger;
        this.client = client;
        this.loggers = loggers;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void logEvent(Event event, EventType eventType) throws IOException {
        EventLogger eventLogger = loggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger;
        }
        String message = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
        jdbcTemplate.update("INSERT INTO events (Message) VALUES ('"+event.toString().replaceAll("'","")+ "');");
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
